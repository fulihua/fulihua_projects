package day23;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

public class ByteStreamBufferCopyFileTest {
    public static void main(String[] args)throws IOException{
        //复制文件，通过字节流已有的缓冲区对象。

        File srcFile = new File("tempfile\\file.txt");
        File desFile = new File("tempfile\\bufcopy_file.txt");

        //1.创建好流对象。
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);
        //2.创建缓冲区对象并和指定的流相关联
        BufferedInputStream bufis = new BufferedInputStream(fis);
        BufferedOutputStream bufos = new BufferedOutputStream(fos);

        byte[] buf = new byte[1024];
        int len = 0;
        while((len=bufis.read(buf))!=-1){
            //缓冲区的read方法从缓冲区中读取一个字节。
            bufos.write(buf,0,len);//将一个字节写入到缓冲区中。
            bufos.flush();//刷新缓冲区，将数据刷到目的地。
        }

        bufos.close();//缓冲区的关闭方法内部其实调用的是流的关闭方法。
        bufis.close();
    }
}
