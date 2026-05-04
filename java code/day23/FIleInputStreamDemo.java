package day23;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FIleInputStreamDemo {
    public static void main(String[] args) throws IOException{
        //2.需求：读取文件中的数据，显示在屏幕上

        File file = new File("tempfile\\file.txt");

        //创建一个字节输入流对象，必须明确数据源，其实就是创建字节读取流和数据源相关联。
        FileInputStream fis = new FileInputStream(file);

        //读取数据。使用read（）；一次读一个字节。
        int ch = 0;
        while((ch=fis.read())!=-1){
            System.out.println("ch="+(char)ch);
        }
        /*
        int ch1 = fis.read();
        System.out.println("ch1="+(char)ch1);
        int ch2 = fis.read();
		System.out.println("ch2="+(char)ch2);
		int ch3 = fis.read();
		System.out.println("ch3="+(char)ch3);
		int ch4 = fis.read();
		System.out.println("ch4="+(char)ch4);
		int ch5 = fis.read();
		System.out.println("ch5="+(char)ch5);
		int ch6 = fis.read();
		System.out.println("ch6="+ch6);
		int ch7 = fis.read();
		System.out.println("ch7="+ch7);
        */
       //关闭资源。
       fis.close();
    }
}

/*
问：
这段代码中，
		//创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
		FileInputStream fis = new FileInputStream(file);这句话是什么意思？字节读取和数据源相关联，是fis是字节读取而后面括号里面的file是数据源，然后通过FileInputStream fis = new FileInputStream(file);这个语句关联起来了，对吗?

答：
你的理解完全正确。`FileInputStream fis = new FileInputStream(file);` 这行代码的作用就是：**创建一个字节输入流对象 `fis`，并将它与数据源文件 `file` 关联起来**。从此以后，通过 `fis` 就可以从该文件中读取数据。其中 `file` 代表数据源（文件路径），`fis` 是读取数据的通道。
所以“字节读取流和数据源相关联”就是指这个关联关系。

*/