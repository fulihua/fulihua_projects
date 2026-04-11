package day20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import day20.ComparatorByLength;

public class CollectionsDemo {
    public static void main(String[] args)
    {
        /**
         * Collections:集合框架中的用于操作集合对象 工具类。
         * 都是静态的工具方法。
         * 1.获取Collection最值。
         * 2.对List集合排序，也可以二分查找。
         * 3.对排序逆序。
         * 4.可以将非同步的集合转成同步的集合。
         * Xxx synchronizedXxx(Xxx) List synchronizedList(List)
         */

        System.out.println("-----获取最值-----");
        Collection<String> c = new ArrayList<String>();
        c.add("haha");
        c.add("zz");
        c.add("xixii");
		c.add("abc");
        String max = Collections.max(c,new ComparatorByLength());

        System.out.println("max="+max);
        System.out.println("-----排序-----");
        List<String> list = new ArrayList<String>();
        list.add("hahaha");
		list.add("abc");
		list.add("xiix");
		list.add("z");
		list.add("java");
        Collections.sort(list,Collections.reverseOrder());//逆转排序
        System.out.println(list);
        System.out.println(list);
		
		
		System.out.println("------------------------");
		System.out.println("------------------------");
    }
}




//4月11日 复习
/*
Collections:集合框架中的用于操作集合对象 工具类。
都是静态的工具方法。
1.获取colle最值
2.对list集合排序，也可以二分查找
3.对排序逆序
Collections.sort(要排序的List对象, Collections.reverseOrder());
4.可以将非同步的集合转成同步的集合。
Xxx<类型> 变量名 = Collections.synchronizedXxx(原Xxx对象);
*/

/*
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo{
    public static void main(String[] args)
    {
        System.out.println("---获取最值---");
        Collection<String> c = new ArrayList<String>();
        c.add("haha");
        c.add("zz");
        c.add("xixii");
		c.add("abc");
        String max = Collections.max(c,new ComparatorByLength());

        System.out.println("max="+max);
        System.out.println("---排序---");
        List<String> list = new ArrayList<String>();
        list.add("hahaha");
		list.add("abc");
		list.add("xiix");
		list.add("z");
		list.add("java");
        Collections.sort(list,Collections.reverseOrder());//逆转排序
        System.out.println(list);
        System.out.println(list);
		
        System.out.println("------------------------");
		System.out.println("------------------------");
    }
}
*/


/*
String max = Collections.max(c,new ComparatorByLength());
这一句话是什么意思啊？

答：这句话的含义是：从集合 c 中，根据 ComparatorByLength 这个比较器所定义的规则（通常是比较字符串的长度），
找出“最大”的那个元素，并将其赋值给字符串变量 max。


注意：其中，Collections.max() 是 Collections 类中的一个静态方法，用于找出集合中的最大值！！！
*/