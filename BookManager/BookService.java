package BookManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

public class BookService {
    private HashMap<String,Book> mapbooks = new HashMap<String,Book>();
    public BookService(ArrayList<Book> books)
    {for(Book b:books){
        mapbooks.put(b.getId(),b);}
    }
   public Result<Book> findBookById(String id){
        Book book = mapbooks.get(id);
        if(book == null){return Result.failure("图书不存在,ID:"+id);}
        return Result.success(book);
    }

    public Result<String> addBook(String title,String writername,double price,int stock){
            String id = UUID.randomUUID().toString();
            Book b = new Book(id,title, writername, price, stock);
            mapbooks.put(id,b);
            Logger.log("添加图书:"+title+"ID为:"+id);
            return Result.success(id);
    }

    public Result<Void> deleteBook(String id){
        if (mapbooks.remove(id)==null){return Result.failure("图书不存在，ID：" + id);}
        else{return Result.success(null);}
     }

    public Result<Void> borrowBook(String id) {
        Result<Book> result = findBookById(id);
       if(!result.isSuccess()){
               return Result.failure(result.getMessage());
             }
             else{
                Book book = result.getData();
                if(book.getStock()>0){
                    book.setStock(book.getStock()-1);
                    book.setBorrowCount(book.getBorrowCount()+1);
                    Logger.log("借书:ID:"+id);
                    return Result.success(null);
                      
                    }
                
                else{return Result.failure("库存不足，当前库存为:"+book.getStock());}
                }
     }

    public Result<Void> returnBook(String id) {
         Result<Book> result  = findBookById(id);
         if(!result.isSuccess()){
                return Result.failure(result.getMessage());
            }
            else{
                Book book = result.getData();
                book .setStock(book .getStock()+1);
                Logger.log("还书:ID:"+id);
                return Result.success(null);
            }
        }

    public ArrayList<Book> searchBooks(String keywords){
            String lowerKeywords = keywords.trim().toLowerCase();
             ArrayList<Book> temporary = new ArrayList<Book>();
              for(Book b5:mapbooks.values()){
                    if(  b5.getTitle().toLowerCase().contains(lowerKeywords)|| b5.getWritename().toLowerCase().contains(lowerKeywords))
                    {
                        temporary.add(b5);
                    }
                }
                    return temporary;
                }
    public ArrayList<Book> getAllBooks(){
           return new ArrayList<>(mapbooks.values());
        
        }

    public ArrayList<Book> getTopBooksByBorrowCount(int count){
        ArrayList<Book> temp = new ArrayList<>(mapbooks.values());
        Collections.sort(temp,(b1,b2)->b2.getBorrowCount()-b1.getBorrowCount());
        if(count > temp.size()){
            count = temp.size();
        }
        return new ArrayList<>(temp.subList(0,count));
        }
    }


    




    
     
    
    


