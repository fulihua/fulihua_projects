public class ArrayTest5_day05 {
    public static void main(String[] args)
    {
        int num=60;

        String str_hex=toHex(num);
        System.out.println("十六进制"+str_hex);
        
    }
    /*
    需求：十进制-->十六进制。
    &15 >>>4 循环

    遇到问题：
    1，顺序反了。2，去除多余的0.

    解决方式：
    1，每运算出一位，不要打印，先存储。需要容器。
    */
   public static String toHex(int num)
   {
    //1.定义容器。存储的是字符，长度为8，一个整数最多8个16进制位。
    char[] chs=new char[8];
    //2,定义一个用于操作的索引。
    int index =chs.length-1;

    for(int x=0;x<8;x++)//十六进制中，每4个二进制位等于1个十六进制位。
    {//为什么要循环8次？因为循环一次处理4位二进制位，处理完全部的32位二进制需要8次循环。
        int temp=num&15;
        if(temp>9)
            chs[index]=((char)(temp-10+'A'));
        else
            chs[index]=((char)(temp+'0'));
        index--;//使其一开始就是存储的正确的顺序
        num=num>>>4;
    }   
        String result=toString(chs);//String 是字符串类型
        return "0x"+result;

        /*
        在java中，
        int是整数类型；
        char是字符类型；
        String是字符串类型；
        Boolean是布尔类型；
        */
    }
    /*
    //4,遍历数组。
    for(int x=0;x<chs.length;x++)
    {
        System.out.print(chs[x]+",");
    }
        return "0x"+toString(chs);
   }
    */
    

   //定义一个功能，将字符数组转成字符串。
    public static String toString(char[] arr)
    {
        String temp="";
        for(int x=0;x<8;x++)
        {
            temp=temp+arr[x];

        }
        return temp;
    }
}
   

/*
一个整数最多有8个16进制位；
一个整数最多有32个2进制位；

右移多少位，取决于：
二进制：基数为 2 = 2¹
八进制：基数为 8 = 2³
十六进制：基数为 16 = 2⁴

*/