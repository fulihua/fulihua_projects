package BookManager;

import java.util.ArrayList;
import java.io.*;

    public class FileHelper {
        private static FileHelper instance;
        private FileHelper(){}
    public static FileHelper getInstance(){
            if(instance == null){
                 instance = new FileHelper();
            }
            return instance;
        }
    public void saveBooks(ArrayList<Book> books,String filename){
       try(FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos))
        { oos.writeObject(books);}
       catch(IOException e){
            e.printStackTrace();
       }
    }
    @SuppressWarnings("unchecked")
    public ArrayList<Book> loadBooks(String filename){
        try(FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis)){
            return (ArrayList<Book>) ois.readObject();
        }catch (FileNotFoundException e){
            return new ArrayList<>();
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

    

    }
}
