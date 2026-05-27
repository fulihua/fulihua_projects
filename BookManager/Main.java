package BookManager;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> array = FileHelper.loadBooks("bookmanager.dat");
        while(true){
        System.out.println("1.添加图书");
        System.out.println("2.查看所有图书");
        System.out.println("3.删除图书");
        System.out.println("4.修改图书信息");
        System.out.println("5.查询图书");
        System.out.println("6.借书");
        System.out.println("7.还书");
        System.out.println("0.退出");
        
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 0){
            FileHelper.saveBooks(array,"bookmanager.dat");
            break;}
        if(choice == 1){
            System.out.println("请输入按顺序输入：书名，作者，价格，库存。");
            String bookname,writername,id;
            double price;
            int stock;
            bookname = sc.nextLine();
            writername = sc.nextLine();
            price = sc.nextDouble();
            stock = sc.nextInt();
            id = UUID.randomUUID().toString();
            Book b = new Book(id,bookname, writername, price, stock);
            array.add(b);
            System.out.println("添加成功!ID是"+id);
        }
        else if(choice == 2){
            if(array.isEmpty()==true){
                System.out.println("暂无图书");}
                else{
                     System.out.println("ID    "+"|"+"书名     "+"|"+"作者     "+"|"+"价格     "+"|"+"库存     ");
                    for(Book b:array){
                       System.out.println(b.getId()+"      "+b.getTitle()+"      "+b.getWritename()+"      "+b.getPrice()+"      "+b.getStock());

                    }
                }
            }
        else if(choice == 3){
            Book goalbook3 = null;
            System.out.println("请输入要输出图书的ID:");
            String id3 = sc.nextLine();
            goalbook3 = findBookById(array, id3);
            if(goalbook3 == null){
                System.out.println("没有找到对应ID的图书");}
            else{
                        ShowBookInfo(goalbook3);
                        System.out.println("确定要将此图书删除吗？(Yes/NO)");
                        String choice3 = sc.nextLine();
                        if(choice3.equals("Yes")){array.remove( goalbook3);
                        System.out.println("删除成功！");}
                        else{System.out.println("操作取消");}
                       
            }           
            }

        
        else if(choice == 4){
            Book goalbook4 = null;
            System.out.println("请输入要修改图书的ID");
            String id4 = sc.nextLine();
            goalbook4 = findBookById(array, id4);
            if(goalbook4 == null){
                 System.out.println("没有找到对应ID的图书");}
            else{
                ShowBookInfo(goalbook4);
                System.out.println("请选择要修改的字段：");
                System.out.println("1. 书名"); 
                System.out.println("2. 作者");
                System.out.println("3. 价格");   
                System.out.println("4. 库存" );
                System.out.println("5. 全部修改");  
                System.out.println("0. 取消");   
                int choice4 = sc.nextInt();
                sc.nextLine();
                switch (choice4) {
                    case 1:
                        System.out.println("请输入新书名:");
                        String newbookname = sc.nextLine();
                        goalbook4.setTitle(newbookname);
                         System.out.println("修改成功！");
                        break;
                    case 2:
                        System.out.println("请输入新作者:");
                        String newwritername = sc.nextLine();
                        goalbook4.setWritername(newwritername);
                         System.out.println("修改成功！");
                        break;
                     case 3:
                        System.out.println("请输入新价格:");
                        double newprice = sc.nextDouble();
                        goalbook4.setPrice(newprice);
                         System.out.println("修改成功！");
                        break;
                     case 4:
                        System.out.println("请输入新库存:");
                        int newstock = sc.nextInt();
                        goalbook4.setStock(newstock);
                         System.out.println("修改成功！");
                        break;
                     case 5:
                        System.out.println("请依次输入新作者、新作者、新价格、新库存:");
                        String newbookname4 = sc.nextLine();
                         goalbook4.setTitle(newbookname4);
                        String newwritername4 = sc.nextLine();
                        goalbook4.setWritername(newwritername4);
                        double newprice4 = sc.nextDouble();
                         goalbook4.setPrice(newprice4);
                        int newstock4 = sc.nextInt();
                        goalbook4.setStock(newstock4);
                        System.out.println("修改成功！");
                        break;
                    default:
                        break;
                }                   
                                         
            }



        }
        else if(choice == 5){
                System.out.println("请输入关键字:");
                ArrayList<Book> temporary = new ArrayList<Book>();
                String keywords = sc.nextLine().trim().toLowerCase();
                for(Book b5:array){
                    if(  b5.getTitle().toLowerCase().contains(keywords)|| b5.getWritename().toLowerCase().contains(keywords))
                    {
                        temporary.add(b5);
                    }
                }
                if(temporary.isEmpty() == true){
                    System.out.println("未找到对应的图书");
                }
                else{
                    for(Book temp: temporary)
                    {   
                        ShowBookInfo(temp);
                    }
                    
                }
        }
        else if(choice == 6){
            System.out.println("请输入将借图书的ID");
            String id6 = sc.nextLine().trim();
             Book b6 = findBookById(array, id6);
             if(b6 == null){
                System.out.println("未找到对应图书");
             }
             else{
                if(b6.getStock()>0){
                    b6.setStock(b6.getStock()-1);
                        System.out.println("借书成功！"+"当前库存为"+b6.getStock());
                    }
                
                else{System.out.println("库存不足，无法借出");}
                }
             
        }
        else if(choice == 7){
            System.out.println("请输入将归还图书的ID");
            String id7 = sc.nextLine().trim();
            Book b7 = findBookById(array, id7);
            if(b7 == null){
                System.out.println("未找到对应图书");
            }
            else{
                b7.setStock(b7.getStock()+1);
                System.out.println("还书成功！");
            }
        }
            else{
                System.out.println("无效选项"); 
            }
        }

        
        
        }
    private static Book findBookById(ArrayList<Book> list,String id){
        for(Book b1:list){
                if(b1.getId().equals(id)){
                         return b1;
                    }
        }
        return null;
    }
    private static void ShowBookInfo(Book b){
         System.out.println(b.getId()+"      "+b.getTitle()+"      "+b.getWritename()+"      "+b.getPrice()+"      "+b.getStock());
    }
}
            
        
    
