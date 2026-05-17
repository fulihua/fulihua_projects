package day24;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo {
    public static void mian(String[] args) throws IOException{
        //需求1：通过流写一篇文章，里面有中文，“你好你好”，indeof('好')；
        //writeCNText();

        //需求2：一篇文章中出现了多少个好字，读取数据，判断好字并计数。
        //思路：读取一个文本，获取内容判断好字。

        readCNText();
        /*
        解决需求2问题：
        使用FileReader.
        */
       System.out.println("------读取字符-----");
       readCNTextByReader();
    }
    public static void readCNTextByReader() throws IOException{
        //创建一个读取字符文件的读取流对象。FileReader.
        FileReader fr = new FileReader("tempfile\\cn.txt");//这个流的底层使用的FileInputStream

//      int ch = fr.read();
//      System.out.println("读取一个字符："+ch);
//      int ch1 = fr.read();//一次读取一个中文，读取多个字节查表转成中文。
//      System.out.println("读取一个字符："+(char)ch1);
        int ch = 0;
        int count = 0;
        while((ch=fr.read())!=-1){
            if(ch=='好'){
                count++;
            }
        }
        System.out.println("count="+count);
        fr.close();
    }
    public static void readCNText() throws IOException{
        FileInputStream fis = new FileInputStream("tempfile\\cn.txt");
        //一次读一个字节，这样对中文是无法判断，怎么解决呢？一个中文默认时两个字节、
        //读取所有的字节，存储起来（字节数组），变成字符串，然后找指定的字符。

//      byte[] buf = new byte[4];
//      int len = 0;
//      while((len=fis.read(buf))!=-1){
//      String str = new String(buf,0,len);
//      System.out.println(str);      
//}
//      int ch = 0;
//      while(ch = fis.read()!=-1){
//          System.out.println(ch);
//          }
        int ch = fis.read();
        System.out.println("读取一个字节："+ch);
        int ch1 = fis.read();
        System.out.println("读取一个字节："+ch1);
        fis.close();
    }

    public static void writeCNText() throws FileNotFoundException,IOException{
        FileOutputStream fos = new FileOutputStream("tempfile\\cn.txt");
        fos.write("你好你好".getBytes());

        fos.close();
    }
}


/*
问：
readCNText() throws IOException这个函数是干啥的？

答：
readCNText() 方法中的代码（包括被注释的部分）是为了演示使用字节流读取包含中文的文本时，直接读取字节无法正确识别中文字符。
它只读取了文件 cn.txt 的前两个字节（每个字节是一个 0~255 的整数），并打印出来。

例如，如果文件内容是 "你好" 且采用 GBK 编码，每个汉字占两个字节，那么前两个字节就是“你”字的两个字节值（如 -60 和 -29），你看到的是数字，而不是汉字。这说明了“一次读一个字节，无法直接得到中文字符”。

所以整个方法的目的是：演示使用 FileInputStream（字节流）读取中文文本的局限性，从而引出后面使用 FileReader（字符流）来正确读取和统计中文字符。


*/

/*
问：
fos.write("你好你好".getBytes());
		这句话必须转成字节数组吗？.getBytes是write下的一个函数吗？

答：
writeCNText() 函数是负责写入数据的。
fos.write("你好你好".getBytes()); 这行代码中，必须将字符串转换成字节数组，因为 FileOutputStream 是字节输出流，它的 write 方法只能接受字节（int 类型单字节）或字节数组（byte[]），不能直接接受字符串。
其中，.getBytes() 是字符串转字节的工具，不属于 write。

所以格式就是：字符串 + .getBytes()，不需要额外参数（除非你要指定编码，如 .getBytes("UTF-8")）
*/

/*
问：
这个函数中FileReader fr = new FileReader("tempfile\\cn.txt");这里的FileReader是啥？为啥不用FileInputStream？

答：
FileInputStream 是字节流，读取的是原始字节。中文在常见编码（如 UTF-8 或 GBK）下占多个字节，如果一次读一个字节，无法得到一个完整的中文字符，难以直接判断是否为“好”字。即使一次读多个字节，也需要处理边界和编码，非常麻烦。

FileReader 是字符流，它内部使用了 FileInputStream 加上解码功能（基于平台默认字符集），可以直接读出一个个字符（中文字符作为一个整体），因此可以直接用 ch == '好' 来比较，非常简单。

使用 FileReader 是处理文本文件统计字符的正确选择。

*/

/*
问：
你不是说创建一个 FileInputStream 对象 fis，用于读取文件 tempfile\cn.txt，这里不就可以读了吗？为啥while((len=fis.read(buf))!=-1){这一行又写了一个read啊？

答：
创建 FileInputStream 对象只是打开了一个通往文件的通道，相当于把书翻到第一页，但还没有开始读内容。真正的读取动作必须通过调用 read() 方法来完成。

new FileInputStream("tempfile\\cn.txt")：建立连接，准备读取。

循环中的 fis.read(buf)：才是实际从文件中读取数据到内存。每次调用 read，就会从文件中读取一部分字节（最多 buf.length 个），然后返回实际读取的字节数。
*/

/*
问：
fileinputstream和fileoutputstream有什么不同？

答：
FileInputStream 和 FileOutputStream 都是 Java 中用于文件读写的字节流，主要区别如下：

特性	FileInputStream	            FileOutputStream
方向	输入流（从文件读取数据到内存）	输出流（从内存写入数据到文件）
核心方法	read()：读取字节	        write()：写入字节
文件存在性	读取的文件必须存在，否则抛出 FileNotFoundException	    如果文件不存在，会自动创建（父目录必须存在）；如果文件已存在，默认覆盖内容（可以设置追加模式）
典型用途	读取文件内容，如图片、音频、文本等	将数据保存到文件，如写入日志、生成文件等
简单理解：FileInputStream 是“从文件里拿数据”，FileOutputStream 是“往文件里放数据”。两者常配合使用实现文件复制。
*/


/*
问：
len = fis.read(buf))这个read不是一次读一个吗？

答：
你记混了 read() 的两个重载方法：

int read()：一次读取一个字节，返回该字节（0~255），读到末尾返回 -1。

int read(byte[] b)：尝试读取最多 b.length 个字节，存入数组 b，返回实际读取的字节数（例如 4、2、0），读到末尾返回 -1。

在你的代码 while((len = fis.read(buf)) != -1) 中，使用的是 read(byte[] buf)，所以它是一次读取多个字节（最多 buf.length 个），而不是一个一个读。len 保存的是本次实际读到的字节数（比如 4、3、2 等）。

因此：

read(buf) 是批量读取，效率高。

len 不是指读取的次数，而是每次读到的字节数量。

然后 new String(buf, 0, len) 将有效字节转换成字符串。

如果你误以为 read(buf) 一次只读一个字节，那就会误解代码逻辑。实际上它是一次读多个字节，所以 len 可能等于 4（如果缓冲区大小是 4）。所以你的理解需要纠正：read(byte[] b) 不是一次读一个字节。


*/