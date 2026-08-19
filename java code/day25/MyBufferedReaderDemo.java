package day25;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException{
        //验证自定义的缓冲区
        MyBufferedReader myBufr = new MyBufferedReader(new FileReader("tempfile\\1.txt"));

        String line = null;
         
        while ((line = myBufr.readLine())!=null) {
            System.out.println(line);
            
        }
        myBufr.close();
    }
}
