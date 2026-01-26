package day03;

public class ContinueDemo_day03 {
    public static void main (String[] args)
    {
        /*
        continue：只作用于循环结构。
        
        结束本次循环，继续下次循环。

        */
       for(int x=0;x<10;x++)
       {
        if(x%2==0)
            continue;
        System.out.println("x="+x);
       }
       outer:for(int x=0;x<3;x++)
       {
            inner:for(int y=0;y<4;y++)
            {
                System.out.println("x="+x);
                continue outer;//加标签：continue outer 可以控制外层循环

                //标签让 continue 有了"超能力"——可以跨越多层循环，精确控制要影响的是哪一层。
                //outer和inner其实等同于两个嵌套的for循环的内外层。不是不用两个 for 循环来写，而是用了标签后可以让 continue 有更大的控制范围。
                /* 
                当执行到 continue outer; 时：

                1.立即停止当前内层循环的所有执行

                2.跳过外层循环当前迭代的剩余代码

直              3.接跳到外层循环的下一次迭代
 */

            }
       }
    }
}
