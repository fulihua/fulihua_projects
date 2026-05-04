package day23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileByBufferTest {
    public static void main(String[] args) throws IOException{
        File srcFile = new File("E:\\1.mp3");
		File destFile = new File("E:\\copy_1.mp3");

		// 2,明确字节流 输入流和源相关联，输出流和目的关联。
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);

        //3.定义一个缓冲区
        byte[] buf = new byte[1024];

        int len = 0;
        while((len = fis.read(buf))!=-1){
            fos.write(buf,0,len);//将数组中的指定长度的数据写入到输出流中。
        }

        //4.关闭资源。
        fos.close();
        fis.close();
    }
}
