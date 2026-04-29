package day22;
import java.io.File;
public class FileMethodDemo3 {
    public static void main(String[] args){
        //需求：对给定的目录获取内部的内容
        File dir = new File("e:\\java_code");
        //健壮性判断：1、必须是存在的2.必须是目录，否则容易引发返回数组为null，出现NullPointerException
        String[] names = dir.list();//获取的是目录下的当前的文件以及文件夹代的名称。
    //  System.out.println(names);
        for(String name:names){
    //  System.out.println(names);
        }

        File[] files = dir.listFiles();//获取目录下当前文件以及文件对象。
        for(File file :files){
        System.out.println(file.lastModified());
        }
    }
}


//4月26日  复习

public class FileMethodDemo3 {
    public static void main(String[] args){
        //需求：对给定的目录获取内部的内容
        File dir = new File("x:\\java_code");
        //健壮性判断：1.必须是存在的2.必须是目录，否则容易引发返回数组为null，出现NullPointerException
        String[] names = dir.list();//获取的是目录下的当前文件以及文件夹带的名称。
    //  System.out.println(names);
        for(String name:names){
    //  System.out.println(names);
        }

        File[] files = dir.listFiles();//获取目录下当前文件以及文件对象。
        for(File file:files){
            System.out.prinltn(file.lastModified());
        }
    }
}


/*
问：
这段代码中，其中健壮性的判断中，为啥必须是目录？还有String[] names = dir.list();和File[] files = dir.listFiles()有啥区别？

答：
. 为什么必须确保是目录？
dir.list() 和 dir.listFiles() 方法只能对目录调用。如果 dir 代表的是一个文件，或者路径不存在，那么调用这两个方法会返回 null。如果不加判断就直接遍历 null，就会抛出 NullPointerException，导致程序崩溃。

因此，健壮性判断要求：

必须存在：dir.exists() 为 true

必须是目录：dir.isDirectory() 为 true



2. list() 和 listFiles() 的区别
方法	    返回类型	    内容	                                用途
dir.list()	String[]	目录下的文件名和子目录名（只有名称，不含路径）	当你只需要名字时使用，例如打印文件名列表
dir.listFiles()	File[]	目录下的文件和子目录的 File 对象	        当你需要操作文件属性（如大小、修改时间、删除、创建等）时使用，因为 File 对象提供很多方法

*/