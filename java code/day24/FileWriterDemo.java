package day24;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void mian(String[] args) throws IOException{
        //演示FileWriter 用于操作文件的便捷类。
        FileWriter fw = new FileWriter("tempfile\\fw.txt");

        fw.write("你好谢谢再见");//这些文字都要先编码。都写入到了流的缓冲区中。

        fw.flush();

        fw.close();

        /*
        flush()和close()的区别？
        答：
        flush():将流中的缓冲区缓冲的数据刷新到目的地中，刷新后，流还可以继续使用。

        close():关闭资源，但在关闭前会将缓冲区中的数据先刷新到目的地，否则丢失数据，然后再关闭流，流不可以使用。

        如果写入数据多，一定要一边写一边刷新，最后一次可以不刷新，由close完成刷新并关闭。
        */
    }
}

//public void close(){
//flush();
//}
