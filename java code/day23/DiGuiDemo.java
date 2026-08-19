package day23;

import java.util.Iterator;

public class DiGuiDemo {
    public static void main(String[] args){
        /*
        递归：其实就是功能的重复使用，但是每次该功能被调用参数都变化（使用了上一次运算的结果）。
        1.函数自身调用自身。
        2.一定要定义条件，否则，StackOverflowError，栈溢出。
        3.注意：递归次数太多容易溢出。
        */
       int sum = getSum(80);
       System.out.println("sum="+sum);
    }
    public static int getSum(int num){
        if(num==1)
        {
                return 1;
        }
        return num+getSum(num-1);
    }
}
