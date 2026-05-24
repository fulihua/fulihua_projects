package day25;

import java.io.IOException;
import java.io.InputStream;


public class ReadKeyDemo {
    public static void main(String[] args) throws IOException{
        /*
        思路：
        1.将数据存储到的文件，没有问题
        2.怎么获取数据来源呢？键盘录入怎么弄呢？
        键盘录入是输入，系统中应该具备的一部分。
        在System类找到了标准输入流 属性 in
        System.in 对应的类型是InputStream 字节输入流
        */
       //获取了键盘录入的输入流对象。可以不用关闭。
       InputStream in = System.in;

//		System.out.println((int)'\r');//13
//		System.out.println((int)'\n');//10
		
//		int ch = in.read();
//		System.out.println(ch);
//		int ch1 = in.read();
//		System.out.println(ch1);
//		int ch2 = in.read();
//		System.out.println(ch2);
//		int ch3 = in.read();
//		System.out.println(ch3);
		
		
		
    }
}
