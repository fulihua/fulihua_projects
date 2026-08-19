package day22;

import java.io.File;
import java.io.FileFilter;

import day22.*;
public class FileMethodDemo5 {
    public static void main(String[] args){
        File dir = new File("E:\\java_code\\day06");

        File[] files = dir.listFiles(new FileFilterByDir());
            
        for(File file:files){
            System.out.println(file);
        }
    }
}


/*
问：
那什么时候输出文件名呢？

答：
在你的代码中，输出文件名发生在 for 循环内部，当执行 System.out.println(file) 时，会打印每个 File 对象所代表的文件路径（通常包含文件名）。
而 FileFilter 或 FilenameFilter 的 accept 方法只负责过滤（返回 true 或 false 决定是否包含该文件），并不负责输出。
因此，过滤决定哪些文件被放入 files 数组，然后遍历数组时输出文件名。

问：
那这个代码里面也没写当返回值为true时，就打印啊？

答：
你的观察很细致。确实，在你的代码中没有显式写出“如果 accept 返回 true 就打印”这样的语句，因为：

过滤逻辑（根据 accept 返回值决定是否包含该文件）是 listFiles 方法内部自动完成的。它遍历目录中的每个文件，调用过滤器的 accept 方法，只有返回 true 的文件才会被加入到返回的 Files[] 数组中。

打印逻辑（输出文件名）是你自己写的 for 循环：遍历 listFiles 返回的数组，逐个打印。由于数组已经只包含被接受的文件，你直接打印即可，无需再判断。

问：
File[] files = dir.listFiles(new FileFilterByDir()) 也就是这句话，当返回值为true的文件会被添加到files数组里面吗？

答：
完全正确！
*/



//4月29日  复习
public class FileMethodDemo5{
    public static void main(String[] args){
        File dir = new File("E:\\java_code\\day06");
        File[] files = dir.listFiles(new FileFilterByDir());

        for(File file:files){
            System.out.println(file);
        }
    }
}


/*
问：FileFileliter和FilenameFileliter有啥区别？

答：你问的应该是 FileFilter 和 FilenameFilter 的区别（拼写近似）。两者都是 Java 中用于文件过滤的接口，主要区别在于：

接口	       accept 方法参数	            过滤依据	                                            典型用途
FileFilter	    accept(File pathname)	可以基于文件的完整信息（如是否是目录、大小、最后修改时间等）	需要判断文件属性（非仅文件名）时使用
FilenameFilter	accept(File dir, String name)	仅基于文件名本身的字符串	            只需要根据文件名（如扩展名、包含特定字符）进行过滤

总结
FileFilter 功能更强，可以基于文件对象的任何属性。

FilenameFilter 仅基于文件名，更轻量。

如果只需要过滤文件名（如扩展名），用 FilenameFilter 更简单；如果需要判断文件类型（如只取目录）或其他属性，用 FileFilter。两者不能互换，因为参数不同，但功能上有重叠。



*/