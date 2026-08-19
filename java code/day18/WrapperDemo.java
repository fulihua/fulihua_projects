package day18;

public class WrapperDemo {
    public static void main(String[] args)
    {
        /**
         * 场景：通过文本框获取用户输入的数字数据，可是得到的都是字符串。如果想要对字符串中的数字进行运算，必须要将字符串转成数字。
         * Java中提供了相应的解决的对象。基本数据类型对象包装类：Java将基本数据类型值封装成了对象。
         * 封装成对象有什么好处？因为可以提供更多的操作基本数值的功能。 byte Byte short Short int Integer long
         * Long float Float double Double boolean Boolean char Character
         *  
         */

        //学习一下Integer.
        /*
        *基本数据类型对象包装类特点：1.用于在基本数据和字符串之间进行转换。***** int parseInt(string); 
        byte parseByte(string);boolean parseBoolean(string); 其中parse为解析的意思。
        总结规律：xxx parseXxx(string);
        注意：只有Character没有解析方法。
        */

        //System.out.println(Integer.MAX_WALUE);
        //System.out.println(Integer.toBinartString(-6));//将十进制转成二进制
        //System.out.println(Integer.toHexString(-6));//将十进制转成十六进制
        //System.out.println(Integer.toOctalString(-6));//将十进制转成八进制

        //1.字符串----->基本数值。 基本数值（字符串）；演示Integer int (string);
        System.out.println(Integer.parseInt("123")+2);//NumberFormatException;
        System.out.println(Integer.parseInt("a1",16));//可以将其他进制转成十进制。
        //2.基本数值----->字符串呢？
        // 方法一：34+"" 方法名二：String.valueOf(34);方法三：Integer.toString(int);

        //3.基本数值----->包装对象
        方法一:Integer i = new Integer(4);
        方法二:Integer ii = new Integer("4");
        //注意：方法一和方法二是一样的！！！
        方法三:Integer iii = Integer.valuOf(4);


        //包装对象----->基本数值
        int num = i.intValue();

    }
}


/*
疑问：
1.int parseInt(string);和Integer.parseInt有什么区别？


答：方法声明（定义方法） → int parseInt(String s) → 放在类里面。

方法调用（使用已有的方法） → Integer.parseInt("123") → 放在需要转换的代码里。

两者是不同层面的东西，一个是在“造方法”，一个是在“用方法”。

2.class MyClass {
    public int parseInt(String s) {
        return Integer.parseInt(s); // 内部可以调用包装类的方法
    }
}这个代码中，为什么类名是MyClass 却要写 Integer.parseInt(s);不应该写 MyClass.parseInt(s);吗？

答：
Integer.parseInt(s) 调用的是 Integer 类的方法；
MyClass.parseInt(s) 调用的是 MyClass 类的方法，但 MyClass 没有定义这样的静态方法，所以会编译错误。

3.不是说基本数值到字符串使用String.valueOf(34);吗？那这个又是啥东西？Integer iii = Integer.valueOf(4);


答：为什么你会觉得它们像？
因为它们都叫 valueOf，但是属于不同的类，作用也不同：

String.valueOf(基本类型)：把基本类型转成字符串。

Integer.valueOf(基本类型)：把基本类型转成 Integer 对象。

总结：

基本数值 → 字符串：用 String.valueOf(数值)

基本数值 → 包装类对象：用 Integer.valueOf(数值)


*/
