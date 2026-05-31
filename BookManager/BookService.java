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
    public  Book findBookById(String id){
        return mapbooks.get(id);
    }

    public String addBook(String title,String writername,double price,int stock){
            String id = UUID.randomUUID().toString();
            Book b = new Book(id,title, writername, price, stock);
            mapbooks.put(id,b);
            Logger.log("添加图书:"+title+"ID为:"+id);
            return id;
    }

    public void deleteBook(String id) throws BookNotFoundException{
        if (mapbooks.remove(id)==null){throw new BookNotFoundException("ID为"+id+"的图书不存在");}
        else{Logger.log("删除图书:ID:"+id);}
     }

    public void borrowBook(String id) throws StockNotEnoughException,BookNotFoundException{
       Book tempbook = findBookById(id);
        if(tempbook == null){
               throw new BookNotFoundException("ID为"+id+"的图书不存在");
             }
             else{
                if(tempbook.getStock()>0){
                    tempbook.setStock(tempbook.getStock()-1);
                    tempbook.setBorrowCount(tempbook.getBorrowCount()+1);
                    Logger.log("借书:ID:"+id);
                      
                    }
                
                else{throw new StockNotEnoughException("库存不足，当前库存为:"+tempbook.getStock());}
                }
     }

    public void  returnBook(String id) throws BookNotFoundException{
         Book tempbook = findBookById(id);
         if(tempbook == null){
                throw new BookNotFoundException("ID为"+id+"的图书不存在");
            }
            else{
                tempbook.setStock(tempbook.getStock()+1);
                Logger.log("还书:ID:"+id);
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


    




    
     
    
    


