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
        ArrayList<Book> books = FileHelper.loadBooks("bookmanager.dat");
        BookService bookService = new BookService(books);
        ConsoleUI ui = new ConsoleUI(bookService);
        ui.start();


    }
}
            
        
    
