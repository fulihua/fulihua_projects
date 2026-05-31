package BookManager;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args){
        FileHelper helper = FileHelper.getInstance();
        ArrayList<Book> books = helper.loadBooks("bookmanager.dat");
        File file = new File("bookmanager.dat");
        if(file.exists()){System.out.println("数据文件存在，大小："+file.length()+"字节");}
        else{System.out.println("数据文件不存在，将创建新文件");}
        BookService bookService = new BookService(books);
        ConsoleUI ui = new ConsoleUI(bookService);
        ui.start();


    }
}
            
        
    
