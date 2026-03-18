package day17;

public class StingTest2_3 {
    public static void main(String[] args)
    {
        /*
		 * 
		 * 
		 * 案例三： "itcast_sh"要求，将该字符串按照长度由长到短打印出来。 itcast_sh itcast_s tcast_sh
		 */

        String str = "itcast";
        printStringByLength(str);
    }

    public static void printStringByLength(String str)
    {
        //1.通过分析，发现是for嵌套循环。
        for(int i= 0;i<str.length();i++)
        {
            for(int start = 0,end = str.length()-1;end <= str.length();start++,end++)
            {
                //根据start,end截取字符串。
                String temp = str.substring(start,end);
                System.out.println(temp);
            }
        }
    }

}


/*
解释：

外层循环中：外层循环变量 x：从0到 length-1。
当前要处理的子串长度 = str.length() - x。
当 x=0 时，长度 = 原长度；x=1 时，长度 = 原长度-1；……最后 x=length-1 时，长度 = 1。
也就是说的“控制行数”



内层循环中：针对当前固定的长度 L = str.length() - x，需要找到所有起始位置可能的子串。
起始索引 y 可以从0开始，最大到 str.length() - L（因为结束索引 z = y + L 不能超过字符串长度）。
这里用 z 表示结束索引，初始值 z = L，然后每次循环 y 和 z 都自增1，这样 z - y 始终等于 L，保证子串长度不变。
循环条件 z <= str.length() 确保结束索引不越界。


z 自增是为了和 y 一起向右移动，保持窗口大小固定，从而取出当前长度的所有子串！！！

外层循环负责让长度递减，内层循环负责取出当前长度的所有可能子串。

--------------------------------------------------


为什么说外层循环控住行数？

答：x 的取值范围：从 0 到 str.length()-1，共 length 种取值。

当前要处理的子串长度：L = str.length() - x。

当 x=0 时，L = 字符串长度，即最长的一行（只有整个字符串一个子串）。

当 x=1 时，L = 字符串长度-1，即第二长的所有子串。

以此类推，当 x = length-1 时，L = 1，即所有单个字符的子串。

每一轮外层循环，内层循环负责输出所有长度为 L 的子串。如果我们把每组长度相同的子串输出在同一行，那么外层循环的每一次迭代就对应输出一行。


--------------------------------------------------------




z的作用是保证每一次循环截取的字符串长度都一样。


*/