package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException{
        //字节输入流
        //available();
        FileInputStream fis = new FileInputStream("tempfile\\file.txt");

        //System.out.println(fis.available());
        byte[] buf = new byte[fis.available()];//定义了一个刚刚好的数组。注意：如果文件过大，容易溢出。
                                                //建议缓冲区的长度最好还是1024的整数倍。
        fis.read(buf);
        String str = new String(buf);
        System.out.println(str);

        fis.close();
    }
}
