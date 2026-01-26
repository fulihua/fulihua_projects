package day02;
public class OperateDemo_day02 {
    public static void main (String[] args)
    {
        /*
        + - * / %(取余数)
        */
       int x = 2810;
       System.out.println(x/1000);
       System.out.println(2%-5);//取余运算的规则：在Java中，取余运算的结果，其符号永远与被除数（第一个数）相同。
                                //当被除数（第一个数)的绝对值小于除数的绝对值时，余数就等于被除数本身。

       /* 
       ++:自增。对原有的数据进行+1

       int a=3;
       a++;//++a;//a=a+1; ++运算单独存在时，放左放右是没有区别的。
       System.out.println("a="+a);
       */


       int a=3,b;
       //b= ++a;
       b=a++;
       System.out.println("a="+a+",b="+b);
       System.out.println("5+5="+(5+5));


    }
}
