package day22;

import java.io.File;
import java.io.FileFilter;

/*
过滤文件夹的过滤器。
*/
public class FileFilterByDir {
    public boolean accept(File pathname){
        return pathname.isDirectory();
    }
}


//4月26日 复习

public class FileFilterByDir implements FileFilter{
    public boolean accept(File pathname){
        return pathname.isDirectory();
    }
}

/*
问：
FileFilter 接口都有啥？
答：
FileFilter接口是什么？
FileFilter 之所以叫“文件过滤器”，是因为它定义了单个函数式方法 accept()。listFiles() 方法在遍历目录时，会调用 accept() 拿到过滤结果，决定该文件对象是否加入返回的数组中。

函数式接口：它仅包含一个抽象方法 boolean accept(File pathname)。因为只有一个方法，因此可以被视为一个函数式接口，可以使用Lambda表达式实现。

结合 listFiles() 使用：FileFilter 的最主要搭档是 File 类的 listFiles(FileFilter) 方法。例如：File[] files = directory.listFiles(new MyFileFilter())。


*/