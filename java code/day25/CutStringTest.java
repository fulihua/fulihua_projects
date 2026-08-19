package day25;

import java.io.UnsupportedEncodingException;

public class CutStringTest {
    public static void main(String[] args) throws UnsupportedEncodingException{
        /*
        1.对字符串按照字节数截取（默认码表），"abc你好" 有5个字符，有7个字节。
        按照3个字节截取 abc ，按照四个字节截取 abc和你字的一半，如果出现中文一半舍弃。
        请定义一个功能解决这个问题。
        你好的gbk：-60 -29 -70 -61
        思路：
        1.一个中文gbk两个字节，都是负数。
        2.在截取时，先看最后一位是负数吗？不是，直接截取就可以了。
            如果是，不要直接舍弃，最好在看一下该负数之前连续出现了几个负数。
        3.因为中文两个字节，出现的负数个数是偶数，不需要舍弃的，是奇数，就舍弃最后一个。
        */
       String str = "abc你好cd谢谢";

       str = "abc琲琲cd琲琲";

       byte[] buf = str.getBytes("GBK");
       for(int i =0;i<buf.length;i++){
        String s = cutString(str,i+1);
        System.out.println(str+",截取"+(i+1)+"个结果是:"+s);
			
       }

    }
    public static String cutString(String str,int len) throws UnsupportedEncodingException{
        //1.将字符串编码成字节数组。
        byte[] buf = str.getBytes("GBK");
        int count =0;
        //2,对数组进行遍历，从截取位开始遍历。往回遍历。
        for(int i = len-1;i>=0;i--){
            //判断最后截取位上是否是负数。
            if(buf[i]<0){
                count++;
            }else{
                break;
            }
        }
        //判断奇偶数。
        if(count%2==0){
            return new String(buf,0,len);
        }else{
            return new String(buf,0,len-1);//舍弃最后一个。
        }
    }
    
}
