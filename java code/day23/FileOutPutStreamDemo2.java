package day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutPutStreamDemo2 {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) throws Exception{
        //需求：将数据续写到已有文件中。
        //FileOutputStream(File file,boolean append) 续写
        //在下一行写入新的数据。

        File file = new File("tempfile\\file.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        String str = LINE_SEPARATOR+"itcast";
        fos.write(str.getBytes());

        fos.close();
    }
}


/*
问：
这段代码中，   File file = new File("tempfile\\file.txt");这里是什么意思？是"tempfile目录下的file.txt文件吗？

答：
是的，`File file = new File("tempfile\\file.txt");` 表示在当前工作目录（通常是项目根目录）下的 `tempfile` 文件夹中，
定位到 `file.txt` 文件。`\\` 是 Java 字符串中表示单个反斜杠的方式（因为反斜杠需要转义），在 Windows 系统中作为路径分隔符。
所以这行代码就是创建一个指向 `tempfile\file.txt` 的 `File` 对象，代表该文件。
*/