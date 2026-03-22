package day18;

public class WrapperDemo2 {
    public static void main(String[] args)
    {
        //int i = 4;
        //Integer i =new Integer(4);
        //JDK1.5以后，有了一个包装类的新特性。目的简化书写，自动装箱。
        Integer i = 4;//自动装箱。Integer i = Integer.valuOf(4);
        i = i + 5;//原理：等号右边：将i对象转成基本数据  i.intValue()+5;//自动拆箱。加法运算后，再次装箱。
        //i =   Integer.valueOf(i.intValue()+5);

        Integer a = new Integer(3);
        Integer b = new Integer(3);
        System.out.println(a==b);//false
        System.out.println(a.equals(b));//true

        System.out.println("---------------------");
        Integer x = 128;
        Integer y = 128;
        //在JDK1.5自动装箱时，如果数值在byte范围之内，不会新创建对象空间而是使用原来已有的空间。
        System.out.println(x==y);
        System.out.println(x.equals(y));
    }
}


/*
疑问：
Integer x = 128;
        Integer y = 128;
        //在JDK1.5自动装箱时，如果数值在byte范围之内，不会新创建对象空间而是使用原来已有的空间。
        System.out.println(x==y);
        System.out.println(x.equals(y));
    }这段代码中，==和equals分别判断的是值相同还是地址相同？


答：== 用于比较两个对象的引用（内存地址）是否相同。
对于 Integer x = 128; Integer y = 128;，由于 128 超出了 Integer 缓存范围（-128~127），自动装箱时会创建两个不同的 Integer 对象，因此 x == y 的结果是 false。

equals() 方法在 Integer 类中被重写，用于比较两个 Integer 对象的数值是否相等。
所以 x.equals(y) 的结果是 true。

*/
