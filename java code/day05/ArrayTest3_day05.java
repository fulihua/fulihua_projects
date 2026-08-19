package day05;
/*
//需求1：定义功能，将{34,12,67}数组中的元素转成字符串"[34,12,67]"
明确1：结果？字符串
明确2：参数？数组

思路：
简单的方式就是利用了字符串和任何数据相加都是相连接。
*/

public class ArrayTest3_day05 {
    public static void main(String[] args)
    {
        int[] arr={34,12,56,90};
        String str =toString(arr);
        System.out.println(str);
    }
    public static String toString(int[] arr)
    {
        //1.定义字符串变量。
        String temp = "[";
        //2.遍历数组，将每一个数组的元素和字符串相连接。
        for(int x=0;x<arr.length;x++)
        {
            //判断，不是最后一个元素，后面接逗号，若是，最后不接逗号。
            if(x!=arr.length-1)
                temp=temp+arr[x]+",";
            else
                temp=temp+arr[x]+"]";
        }
        //3.将连接后的字符串返回
        return temp;
    }
}
