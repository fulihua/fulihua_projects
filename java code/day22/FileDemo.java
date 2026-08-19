package day22;

import java.io.File;

public class FileDemo {
    // private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    //getProperty 是 Java 标准库中 System 类的一个静态方法，用于获取系统的属性值.它属于 java.lang.System 类，不需要额外导入，可以直接使用.
    //例如 System.getProperty("file.separator") 会返回当前操作系统的文件路径分隔符。
    
    public static void  main(String[] args){
        /*
            File类的构造函数。
            如何创建文件对象。
        */
       String pathName = "e:\\\\java_code\\\\day22e\\\\hello.java";
       File f1 = new File(pathName);//将Test22文件封装成File对象。注意：有可以封装不存在文件或者文件夹，变成对象
       System.out.println(f1);


       File f2 = new File("e:\\\\java_code\\\\day22e\\\\hello.java");
       System.out.println(f2);


       //将parent封装成file对象
       File dir = new File("e:\\\\java_code\\\\day22e\\\\hello.java");
       File f3 = new File(dir,"hello.java");
       System.out.println(f3);

       //File f4 = new File("e:"+FILE_SERARATOR+"java_code"+FILE_SERARATOR+"hello.java");
       File f5 = new File("e:"+File.separator+"java_code"+File.separator+"day22e"+File.separator+"hello.java");
    }
}


//4月26日 复习

public class FileDemo{
    //private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    //getProperty 是Java标准库中 System 类的一个静态方法，用于获取系统的属性值，它属于 java.lang.System 类，不需要额外导入，可以直接使用。
    //例如 System.getProperty("file.separator")会返回当前操作系统的文件路径分隔符。

    public static void main(String[] args){
        /*
        File类的构造函数。
        如何创建文件对象。
        */
       String pathName = "e:\\\\java_code\\\\day22e\\\\hello.java";
       File f1 = new File(pathName);//将Test22文件封装成File对象。注意：有可以封装不存在文件或者文件夹，变成对象。
       System.out.println(f1);

       File f2 = new File("e:\\\\java_code\\\\day22e\\\\hello.java");
       System.out.println(f2);

       //将parent封装成file对象
       File dir = new File("e:\\\\java_code\\\\day22e\\\\hello.java");
                           File f3 = new File(dir,"hello.java");
                             System.out.println(f3);
                      
        //File f4 = new File("e:"+FILE_SERARATOR+"java_code"+FILE_SERARATOR+"hello.java");
        File f5 = new File("e:"+File.separator+"jav_code"+File.separator+"day22e"+File.separator+"hello.java");
    }
}


