package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyDataToFileTest {
    public static void main(String[] args) throws IOException{
        //需求：将键盘录入的数据存储到文件中。
        /*
        1.键盘录入
        2.目的是文件
        3.这个示例中既要用到输入流，也要用到输出流。
        而且操作的数据都是文本数据，可以使用字符流。
        而且目的是文件可以使用操作文件的字符输出流。
        */

        //键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //目的是文件
        //FileWriter fw = new FileWriter("tempfile\\key.txt");
        //Buffered bufw = new BufferedWriter(fw);
        BufferedWriter bufw = new BufferedWriter(new FileWriter("tempfile\\key.txt"));

        String line = null;
        while((line=bufr.readLine())!=null){
            if("over".equals(line)){
                break;
            }
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        bufw.close();
    }
}
