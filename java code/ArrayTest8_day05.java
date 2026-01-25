public class ArrayTest8_day05 {
    public static void main(String[] args)
    {
        int num=60;
        String str_bin=toBinary(num);
        String str_oct=toOctal(num);
        String str_hex=toHex(num);
        System.out.println("bin:"+str_bin);
        System.out.println("oct:"+str_oct);
        System.out.println("hex:"+str_hex);
        //java已经提供的功能。
        System.out.println(Integer.toBinaryString(60));
        System.out.println(Integer.toOctalString(60));
        System.out.println(Integer.toHexString(60));
    }


    /*
    十进制-->十六进制。
    */
    public static String toHex(int num)
    {
        return  "0x"+trans(num,15,4);
    }
     /*
    十进制-->二进制。
    */
    public static String toBinary(int num)
    {
        return  "0x"+trans(num,1,1);
    }
     /*
    十进制-->八进制。
    */
    public static String toOctal(int num)
    {
        return  "0x"+trans(num,7,3);
    }

    //用于进制转换。
    public static String trans(int num,int base,int offset)
    {
        if(num==0)
        {
            return "0";
        }
        //1,建立表。
         char [] chs={'0','1','2','3',
                     '4','5','6','7','8','9',
                     'A','B','C','D','E','F' };
    //2.创建临时容器。
    char [] arr=new char[32];
    //3.创建操作临时容器的角标。
    int index=arr.length;
    //4,通过循环对num进行& >>等运算。
    while(num!=0)
    {
        int temp=num&base;
        arr[--index]=chs[temp];//这里temp一定为1-15之间的整数，temp为多少就对应chs数组中的第几位数字。
        num=num>>>offset;
    }
    return toString(arr,index);
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
