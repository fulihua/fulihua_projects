package day05;
public class ArrayTest7_day05 {
    public static void main(String[] args)
    {
        int num=26;
        String str_hex=toHex(num);
        System.out.println("hex:"+str_hex);
    }
    /*
    需求：十进制-->十六进制，终结版。
    思路：
    十进制转出十六进制的每一位都是十六进制元素中的某一个。
    十六进制的元素有很多固定个数，而且还有对应的编号。
    所以可以使用传说中的查表法！

    */

    public static String toHex(int num)
    {
        //1,建立表。
        char [] chs={'0','1','2','3',
                     '4','5','6','7','8','9',
                     'A','B','C','D','E','F' };
    //2.创建临时容器。
    char [] arr=new char[8];
    //3.创建操作临时容器的角标。
    int index=arr.length;
    //4,通过循环对num进行& >>等运算。
    while(num!=0)
    {
        int temp=num&15;
        arr[--index]=chs[temp];//这里temp一定为1-15之间的整数，temp为多少就对应chs数组中的第几位数字。
        num=num>>>4;
    }
    return "0x"+toString(arr,index);
    }
    public static String toString(char[] arr,int index)
    {
        String temp="";
        for(int x=index;x<arr.length;x++)
        {
            temp=temp+arr[x];
    
        }
    return temp;
}
}
