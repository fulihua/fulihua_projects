package day22;

import java.io.File;
import java.io.FilenameFilter;

public class FilenameFilterByJava implements FilenameFilter{
    public boolean accept(File dir,String name){
        //System.out.println(dir+":::"+name);
        return name.endsWith(".java");
    }
}


//4月29日  复习

public class FilenameFilterByJava implements FilenameFilter{
    public boolean accept(File dir,String name){
        return name.endsWith(".java");
    }
}

/*
问：这段代码是什么意思？

答：这段代码定义了一个名为 FilenameFilterByJava 的类，它实现了 Java 的 FilenameFilter 接口。FilenameFilter 接口用于文件过滤，其中只有一个 accept(File dir, String name) 方法。

accept 方法的返回值是 boolean：如果返回 true，表示接受该文件；返回 false 表示拒绝。

方法参数：dir 是文件所在的目录，name 是文件的名字（不包括路径）。

方法体：return name.endsWith(".java"); 意思是：如果文件名以 .java 结尾，则返回 true，否则返回 false。


*/