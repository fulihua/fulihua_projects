public class ArrayTest6_day05 {
    public static void main(String[] args)
    {
        int num=60;

        String str_hex=toHex(num);
        System.out.println(str_hex);
    }
    /*
    需求：十进制->十六进制
    &15 >>>4 循环

    遇到问题：
    1，顺序反了。2，去除多余的0.

    解决方式：
    1.每运算出一位，不要打印，先存储，需要容器。
    2.去除零？需要转换的数据会不断的右移，如果右移后剩余的二进制都是0，也就是没有有效位，
    就不需要进行&运算了，也就是不需要再往数组中存储了。

    */
    public static String toHex(int num)
    {
        //1.定义容器，存储的是字符，长度为8。
        char[] chs=new char[8];
        //2.定义一个用于操作数组的索引。
        int index=chs.length;

        while(num!=0)
        {
            int temp=num&15;

            if(temp>9)
                chs[--index]=((char)(temp-10+'A'));
            else
                chs[--index]=((char)(temp+'0'));
            num=num>>>4;

        }
        System.out.println("index="+index);
        return "0x"+toString(chs,index);
    }

    //定义一个功能，将字符数组转成字符串。
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




