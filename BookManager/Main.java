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
        ArrayList<Book> array = new ArrayList<Book>();
        while(true){
        System.out.println("1.添加图书");
        System.out.println("2.查看所有图书");
        System.out.println("0.退出");
        
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 0){break;}
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
            else{
                System.out.println("无效选项"); 
            }
        }
        
        
        }
        
       

            }
            
        
    
