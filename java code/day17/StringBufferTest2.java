package day17;

public class StringBufferTest2 {
    public static void main(String[] args) {
		
		String s1 = "hello";
		String s2 = "java";
		show(s1,s2);
		System.out.println(s1+","+s2);
		System.out.println("-----------------------");
		
		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("java");
		show(sb1,sb2);
		System.out.println(sb1+","+sb2);
	}
	public static void show(String s1, String s2) {
		
		s2.replace('a', 'o');
		s1 = s2;
	}
	public static void show(StringBuffer sb1, StringBuffer sb2) {
		sb1.append(sb2);
		sb1 = sb2;
	}
}
