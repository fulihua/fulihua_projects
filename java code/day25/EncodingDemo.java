package day25;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {
    public static void main(String[] args) throws UnsupportedEncodingException{
        /*
        字符串：String 字节数组：byte[]
        字符串--编码（getBytes())-->字节数组
        字节数组--解码（new String(byte[]))-->字符串

        "你好"：
        GBK编码： -60 -29 -70 -61
		UTF-8编码：-28 -67 -96 -27 -91 -67

        */
       String str = "你好";

       //对字符串编码。-->字节数组。
       byte[] buf1 = str.getBytes("utf-8");

       //   for(byte b:buf1){
       //         System.out.print(b);
        //}

        //对字节数组解码。-->字符串。
        String s1 = new String(buf1,"utf-8");
        System.out.println(s1);
    }
}
