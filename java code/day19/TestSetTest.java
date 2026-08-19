package day19;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestSetTest {
    public static void main(String[] args)
    {
        /*
        练习：要对字符串进行长度（由短到长）排序。
        思路：
        1.字符串之所以可以排序，因为是已经实现Comparable接口重新compareto方法。
        建立了字符串的自然排序。
        2.但是自然排序不是需求中所需要的，咋办？
        只能使用比较器。需要自定义一个比较器。

        */
       Set set = new TreeSet<>(Collections.reverseOrder(new ComparatorByLength()));

       set.add("abc");
		set.add("haha");
		set.add("xixi");
		set.add("z");
		set.add("hiahia");

        for(Iterator it = set.iterator();it.hasNext();)
        {
            System.out.println(it.next());
        }
    }
}



/*
问：ComparatorByLength()这个方法中不是需要两个参数吗？为什么从没有传入两个参数？

答：因为ComparatorByLength()方法实现了compare方法，需要compare方法会自动比较两个数的大小、

问：Collections.reverseOrder(...) 的作用

答：ollections.reverseOrder(Comparator cmp) 接收一个比较器，返回一个新的比较器，其比较顺序与原比较器相反（即降序）。
这里原本 ComparatorByLength 实现的是升序（短 → 长），经过 reverseOrder 包装后就变成了降序（长 → 短）。

所以整个 TreeSet 的排序规则是：字符串按长度从长到短排序，长度相同时按字典序降序（因为 s1.compareTo(s2) 是升序，反转后变成降序）。


总之：Collections.reverseOrder(Comparator cmp) 的作用是：将一个比较器（排序规则）反转，变成相反的排序规则。
*/