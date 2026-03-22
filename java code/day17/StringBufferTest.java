package day17;

public class StringBufferTest {
    public static void main(String[] args)
    {
        /*
		 * int[] arr = {34,12,89,68};
		 * 将一个int[]中元素转成字符串  格式 [34,12,89,68]
		 */

        int[] arr = {34,12,89,68};
        String str = toString_2(arr);
        System.out.println(str);
    }

    /*缓冲区的应用：无论多少数据，什么类型都不重要，只要最终变成字符串就可以StringBuffer这个容器 */
    public static String toString_2(int[] arr)
    {
        //1.创建缓冲区。
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for(int i = 0;i<arr.length;i++)
        {   if(i!=arr.length-1)
        {sb.append(arr[i]+",");}
        else{
            sb.append(arr[i]+"]");
        }
        }
        return sb.toString();
    }


    public static Sting toString(int[] arr)
    {
        //用字符串连接。
        String str = "[";
        for(int i = 0;i<arr.length;i++)
        {   if(i!=arr.length-1)
        { str+=arr[i]+",";}
        else{
            str+=arr[i]+"]";
        }
    }
    return str;
}
}




/*
注意：
tostring_2 方法中的toString是 Java 类库提供的方法,和这段代码中的toString函数无关！！！

Java 类库提供的 StringBuffer 类方法中的toString函数：

转换	String toString()	将 StringBuffer 中当前的内容转换为一个不可变的 String 对象。
*/



//3月22日  复习

public class StringBufferTest
{
    public static void main(String[] args)
    {
       /*
		 * int[] arr = {34,12,89,68};
		 * 将一个int[]中元素转成字符串  格式 [34,12,89,68]
		 */  

       int [] arr = {34,12,89,68};
       String str = toString_2(arr);
       System.out.println(str);

    }

    public static Sting toString_2(int[] arr)
    {
        StringBuffer sb = new StringBuffer();

        sb.append("[");
        for(int i = 0;i<arr.length;i++)
        {
            if(i!=arr.length-1)
            {
                    sb.append(arr[i]+",");
            }
            else{
                sb.append(arr[i]+"]");
            }

        }
        return sb.toString();
    }

    public static String toString(int[] arr)
    {
        String str = "[";
        for(int i = 0;i<arr.length;i++)
        {
            if(i!=arr.length - 1)
            {
                str+=arr[i]+",";
            }
            else
            {
                str+=arr[i]+"]";
            }
        }
        return str;
    }
}