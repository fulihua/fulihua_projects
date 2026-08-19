package day17;

public class StringDemo {
    public static void main(String[] args)
    {
        //定义一个字符串。
        String str = "abcd";
//      str = "haha";
        System.out.println("str="+str);
        
        
        System.out.println("-----多个引用指向同一个字符串-----");
        String s1 = "itcast";
        String s2 = "itcast";
        System.out.println(s1==s2);

        System.out.println("-----两个内容相同,创建方式不同的字符串，面试题-----");
        String s3 = "abc";
        String s4 = new String("abc");


        //s3和s4有什么不同呢？
        /*
            s3创建，在内存中只有一个对象。

            s4创建，在内存中有两个对象。
        */
       System.out.println(s3==s4);//false
//      因为String复写了equals方法。
//      建立字符串自己的判断相同的依据。通过字符串对象中的内容来判断的。
        System.out.println(s3.equals(s4));//true
    }
}





/*
知识要点：

一、String 是什么？
String 是 Java 中用来表示字符串的类（例如 "hello"、"abc"）。

字符串在 Java 中是不可变的（immutable）——一旦创建，它的内容就不能被改变。每次修改字符串（比如拼接、替换）都会产生一个新的 String 对象。

二、创建 String 对象的两种方式
1. 直接赋值（字面量）
String s1 = "hello";
这种方式会先去字符串常量池中查找是否有内容为 "hello" 的对象。

如果有，就直接把引用指向它（复用）；如果没有，就在常量池中创建一个新的 "hello" 对象。

常量池是为了节省内存，避免重复创建相同内容的字符串。

2.使用new关键字
String s2 = new String("hello");
不管常量池中有没有 "hello"，都会在堆内存中创建一个全新的 String 对象。

这个新对象有自己的内存地址，与常量池中的对象（如果有）是相互独立的。

三、==&equals的区别


    == 操作符：

对于基本数据类型（如 int, char, boolean 等），比较的是数值本身（即内容）。
对于引用类型（如对象、数组、字符串等），比较的是内存地址（即两个变量是否指向堆中的同一个对象）。

    equals 方法：

它是 Object 类中定义的方法，默认实现也是比较地址（与 == 对引用类型的效果一样）。
但是，很多类（如 String、Integer、Date 等）重写了 equals 方法，使其比较的是对象的内容（即字段值是否相等）。



也就是在String中，==比较的是地址，而equals比较的是内容。
*/