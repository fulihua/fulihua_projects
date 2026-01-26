package day03;
public class OperateTest_day03 {
    public static void main(String[] args)
    {
        //需求1，最有效率运算2乘以8.通过位移运算。
        System.out.println(2<<3);

        //需求2，对两个整数变量的值进行互换（不需要第三方变量）
        int a=3,b=7;
        /*
        a=b;a=7;
        b=a;b=7;
        错误。
        */

        /*
        //通过第三方变量的形式进行置换。
        int temp=a;
        a=b;
        b=temp;
        */
       /*
       //通过和的形式。有个弊端：两个数据较大，可能会超出int范围。
       a=a+b;//a=3+7;
       b=a-b;//b=3+7-7;b=3;
       a=a-b;//a=3+7-3;a=7;
       */

       //技巧。异或。
       a=a^b;//a=3^7;
       b=a^b;//b=3^7^7;//怎么运算的呢？先将3和7分别转成二进制，然后对应每一位进行异或运算。
       a=a^b;//a=a^7^3;//与自身异或结果为0。

       System.out.println("a="+a+",b="+b);

       //需求3：对给定的整数26，获取其十六进制的表现实行。

       //需求4：三个数，想知道最大的是哪个？

       int x=4,y=8,z=2;

       System.out.println("max=");
        
    }
    
}
