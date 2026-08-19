package day25;

public class LianTongTest {
    public static void main(String[] args){
        String str = "联通";
        /*
        11000001
		10101010
		11001101
		10101000
        联通的gbk编码二进制正好符合了UTF-8的编码规律。所以记事本在解析这段二进制时，
        就启动了utf-8的码表来解析这个数据，出现乱码。
        */

        byte[] buf = str.getBytes();
        for(byte b:buf){
            System.out.println(Integer.toBinaryString(b&255));
        }
    }
}
