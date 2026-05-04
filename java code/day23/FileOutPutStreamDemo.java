package day23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamDemo {
    public static void main(String[] args) throws IOException
    {
        //需求：将数据写入到文件中。
        //创建临时目录
        File dir = new File("tempfile");
        if(!dir.exists()){
            dir.mkdir();
        }

        //创建存储数据的文件。
        File file = new File(dir,"file.txt");
        
        //创建一个用于操作文件的字节输出流对象，一创建就必须明确数据存储目的地。
        //输出流目的是文件，会自动创建，如果文件存在，则覆盖。
        FileOutputStream fos = new FileOutputStream(file);

        //调用父类中的write方法。
        byte[] data = "abcde".getBytes();
        fos.write(data);

        //关闭流资源。
        fos.close();
            
        
    }
}


/*
问：
我可以把dir理解为"tempfile"的别名吗？

答：
可以近似这么理解：**`dir` 就像是一个指向 `"tempfile"` 这个路径的“遥控器”**。
当你写 `new File(dir, "file.txt")` 时，相当于告诉 Java：“在我之前用 `dir` 遥控器指向的那个文件夹里，创建 `file.txt` 文件”。
所以 `dir` 和 `"tempfile"` 在这里可以看作指向同一个文件夹的两种表达方式。用 `dir` 的好处是，如果以后你想改成其他文件夹，只需要改一处（`dir` 的定义），而不用到处改字符串。
所以你说“别名”不完全准确，但理解成“代指那个文件夹”是没问题的。
*/

/*
问：
这段代码是什么意思？

答；
代码分步解释
创建临时目录
File dir = new File("tempfile");：创建一个代表 tempfile 目录的 File 对象（不一定会立即在磁盘上创建）。
if(!dir.exists()){ dir.mkdir(); }：如果该目录不存在，则创建它。

创建文件对象
File file = new File(dir, "file.txt");：在 dir 目录下创建一个代表 file.txt 文件的 File 对象（仍仅在内存中，未实际创建）。

创建文件输出流
FileOutputStream fos = new FileOutputStream(file);

这一步会真正在磁盘上创建文件（如果文件不存在），如果文件已存在则覆盖原内容。

由于操作的是文件系统，可能抛出 FileNotFoundException（例如路径错误、无权限等），但 FileNotFoundException 是 IOException 的子类。

写入数据
byte[] data = "abcde".getBytes();：将字符串转换为字节数组。
fos.write(data);：将字节数组写入文件。

关闭流
fos.close();：释放系统资源。
*/

/*
问：
什么时候抛出 IOException？这一个问题中，我还是没有听懂什么时候抛出 IOException？我可以理解为当我碰到除语法错误之外的错误吗？比如，你提到的权限问题啊等等

答：
你理解得很接近了。**`IOException` 可以理解为：当你操作文件、网络等输入输出时，由于“外部原因”导致失败，而不是你的代码语法错误。** 例如：

- 文件被其他程序占用，无法写入；
- 磁盘已满，写不进去；
- 没有权限访问那个文件夹；
- 文件明明不存在，你却要读取它；
- 网络突然断了……

这些情况都不是你写错了代码（语法正确），而是运行时环境出了问题。Java 就会抛出 `IOException`。  
而语法错误（比如少个分号、拼错变量名）会直接导致**编译失败**，根本不会运行，所以不会抛出异常。  
所以，**“除了语法错误之外的、与外部资源交互时发生的错误”** 基本就是 `IOException` 的范畴。
*/