package day23;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //演示第二个读取方法，read(byte[]);

        File file = new File("tempfile\\file.txt");

        //创建一个字节输入流对象，必须明确数据源，其实就是创建字节读取流和数据源相关联。
        FileInputStream fis = new FileInputStream(file);

        //创建一个字节数组
        byte[] buf = new byte[1024];//长度可以定义成1024的整数倍。

        int len =0;
        while((len = fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        /*
        int len1 = fis.read(buf);
        System.out.println(len1+":"+new String(buf,0,len1));
        int len2 = fis.read(buf);
        System.out.println(len2+":"+new String(buf,0,len2));
        int len3 = fis.read(buf);
		System.out.println(len3+":"+new String(buf,0,len3));
		int len4 = fis.read(buf);
		System.out.println(len4);
        */

        fis.close();
    }
}
