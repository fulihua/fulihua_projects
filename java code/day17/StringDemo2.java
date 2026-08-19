package day17;

public class StringDemo2 {
       /**
	 * @param args
	 */
	public static void main(String[] args) { 
       
		/*
		 * "abcde"
		 * 
		 * 1，字符串是一个对象，那么它的方法必然时围绕操作这个对象的数据而定义的。
		 * 2，你认为字符串中有哪些功能呢？
		 * 	2.1 有多少个字符?
		 * 		int length()
		 * 
		 * 	2.2 字符的位置。
		 * 		int indexOf(ch,fromIndex);
		 * 
		 * 	2.3 获取指定位置上的字符。
		 * 		char charAt(int)
		 * 
		 *  2.4 获取部分字符串。
		 *  	String substring(int start,int end);
		 *  
		 * 
		 * 
		 */
        String str = "abada";
//      System.out.println("length="+str.length());
        int len = str.length();
        System.out.println("len="+len);

        //-----a字母出现的位置-----
        int index = str.indexOf('a');//获取的是a字符第一次出现的位置。
        System.out.println("index="+index);
        //-----第二个a字母出现的位置-----

        int index1 = str.indexOf('a',index+1);
        System.out.println("index1="+index1);
        //-----第三个a字母出现的位置-----
        int index2 = str.indexOf('a',index1+1);
        System.out.println("index2="+index2);

        str =  "sdfghjkl;wertyuiop[sdfghjkla;";
        int index3 = str.lastIndexOf('m');//如果要找的字符不存在，-1
        System.out.println("index3="+index3);

        //-----获取指定位置上字符-----
        str = "itcast";
        char ch = str.charAt(3);//不存在角标会发生StringIndexOutOfBOundsException
        System.out.println("ch="+ch);

        //-----获取部分字符串-----
        String s = str.substring(2,4);//包含头，不包含尾。
        System.out.println("s="+s);
    }
}

/*
    //问：为什么 2.4 获取部分字符串。
		 *  	String substring(int start,int end);
		 *  这里的start和end都是int呢？为什么不是char？
         * 
    答：因为 substring 方法的参数 start 和 end 表示的是字符的位置索引，而不是字符本身。
*/

