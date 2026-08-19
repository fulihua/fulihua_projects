package day23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTest {
    public static void main(String[] args) throws IOException{
        /*
        练习：复制文件。
        原理：读取一个已有的数据，并将这些读到的数据写入到另一个文件中。
        */
       //1.明确源和目的
       File srcFile = new File("E:\\1.mp3");
       File deesFile = new File("E:\\copy_2.mp3");

       //2.明确字节流，输出流和源相关联，输出流和目的关联。
       FileInputStream fis = new FileInputStream(srcFile);
       FileOutputStream fos = new FileOutputStream(deesFile);

       //3.使用输入流的读取方法读取字节，并将字节写入到目的中。
       int ch = 0;
       while((ch=fis.read())!=-1){
        fos.write(ch);
       }

       //4.关闭资源
       fos.close();
       fis.close();
    }
}


/*
问：
这段代码中，fos.write(ch);这里括号里面的ch是写入的字节数吗？前面写ch=fis.read())那是不是ch每次都是1？以为read不是每次都读一个字节吗？

答：
在代码 `while((ch = fis.read()) != -1) { fos.write(ch); }` 中：

- `fis.read()` 每次从源文件中读取**一个字节**（8位），将其作为 `int` 类型返回（范围 0~255），如果读到文件末尾则返回 -1。
- 变量 `ch` 存储的是**读取到的字节值**（例如字符 `'a'` 的 ASCII 码为 97，则 `ch=97`），而不是“读取的字节数量”。
- `fos.write(ch)` 将该字节写入目标文件。这里 `ch` 会被当作低8位写入（前24位丢弃）。

所以 `ch` **每次的值取决于文件内容**，不是固定的。例如文件第一个字节是 0x01，则 `ch=1`；如果是 `'A'`，则 `ch=65`。你问“是不是 ch 每次都是 1？”：只有当文件内容全是数值 1（即字节 0x01）时才会这样，一般不会是1。

因此，这段代码正确实现了逐字节复制文件。注意：逐字节复制效率较低，通常建议使用缓冲区（`read(byte[])`）提高效率，但原理相同。


问：
所以fos.write(ch)代表的意思是写入每次读取到的一个字节的内容，对吗？

答：
是的，你的理解完全正确。`fos.write(ch)` 就是将每次通过 `fis.read()` 读取到的那个字节（以 `int` 形式存储在 `ch` 中）写入到目标文件中。所以它实现了逐字节复制文件内容。
*/