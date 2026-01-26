package day03;

public class DoWhileDemo_day03 {
    public static void main(String[] args)
    {
        /*
        do
        {
            执行语句；
        }while（条件表达式）;
        */
       int x=3;
       while(x<3)
       {
        System.out.println("x="+x);
        x++;
       }

       //do while 无论条件是否满足，循环体至少执行一次。

       int y=3;
       do 
       {
            System.out.println("y="+y);
            y++;
       }
       while(y<3);//至少显示一次！
    }
}
