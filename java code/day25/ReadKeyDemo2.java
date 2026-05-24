package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadKeyDemo2 {
    public static void main(String[] args) throws IOException{
        //读取的数据更多
        /*
        读取一个字节先不要操作，将其存储起来，转成一个字符串。、

        能不能一次就读取一行字符串呢？readLine();
        可是readLine()是BufferedReader方法
        BufferedReader使用时必须接收字符流对象
        键盘录入是字节流。要是将字节流转出字符流是不是就可以了？怎么转呢？
        字节流--桥梁InputStreamReader-->字符流

        */
       //读取键盘录入的字节输入流
       //InputStream in = System.in;
       //通过桥梁，将字节输入流转成字符输入流。
       //InputStreamReader isr = new InputStreamReader(in);
       //对字符流进行效率提高，而且使用缓冲区对象的特有方法readLine();
       //BufferedReader bufr = new BufferedReader(isr);

       //记住：以后但凡提到了键盘录入就写这句，一行一行的读取，除非要对读取每一份字节操作。
       BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

       String line = null;
       while((line=bufr.readLine())!=null){//键盘录入记住定义结束标记。强制结束。

        if("over".equals(line)){
            break;
        }
        System.out.println(line);

       }
    }
}
