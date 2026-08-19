package day20;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GenericTest {
    public static void main(String[] args)
    {
        //创建一个唯一性元素的集合要求排序。set -- treeset//按照长度排序，需要比较器。匿名内部类完成。
        Set<String> set = new TreeSet<String>(new Comparator<String>(){
            public int compare(String o1,String o2)
            {
                int temp = o1.length()-o2.length();
                return temp==0?o1.compareTo(o2):temp;
                
            } 
        });
        //添加元素。
        set.add("abcde");
        set.add("java");
        set.add("hello");

        for(Iterator<String> it = set.iterator();it.hasNext();)
            {
                String string = it.next();
                System.out.println(string);
            } 

    }
}




/*
问：“创建一个唯一性元素的集合要求排序。set -- treeset//按照长度排序，需要比较器。匿名内部类完成。”这段注解是什么意思？

答：
创建一个唯一性元素的集合要求排序”：需要存储不重复的元素，并且希望这些元素能按照一定的顺序排列。在 Java 中，Set 接口保证元素唯一性，而 TreeSet 实现类不仅能保证唯一性，还能对元素进行排序。

“set -- treeset”：指明使用 TreeSet 来实现这个集合。

“按照长度排序，需要比较器”：TreeSet 默认按照元素的自然顺序（对于 String 就是字典序）排序。但这里需要按照字符串的长度排序，自然顺序不满足需求，因此必须提供一个自定义的比较器（Comparator）来定义“按长度比较”的规则。

“匿名内部类完成”：在创建 TreeSet 对象时，直接通过 new Comparator<String>(){...} 创建了一个没有名字的内部类实例，并在其中实现了 compare 方法。这种写法避免了单独定义一个类，代码更简洁。

简单来说，这句话解释了为什么使用 TreeSet（需要排序且唯一）、为什么要传入比较器（默认排序不是按长度），以及如何传入（使用匿名内部类）。
*/




/*
问： return temp==0?o1.compareTo(o2):temp;
答：
直接返回 temp：此时 temp == 0，返回 0。TreeSet 会认为这两个元素相同（因为比较结果为零），只能存入其中一个，且不按字典序排列。

返回 o1.compareTo(o2)：因为长度相等但内容不同，o1.compareTo(o2) 返回非零值（正或负），所以两个字符串都能存入，并且按照字典序排列。

因此，这段代码的目的是：先按长度排序，长度相同再按字典序排序，并且允许长度相同但内容不同的元素同时存在。如果只返回 temp，长度相同的内容不同的元素会被视为重复而无法同时存储。

其中，compareTo方法是 Java 中 String 类自带的方法（它实现了 Comparable 接口）。该方法专门用于按字典顺序比较两个字符串，返回值规则如下：
返回负数：当前字符串小于参数字符串；

返回 0：两者相等；

返回正数：当前字符串大于参数字符串。


*/


//4月12日  复习

public class GenericTest{
    public static void main(Stirng[] args)
    {
        //创建一个唯一性元素的集合要求排序。set--treeset//按照长度排序，需要比较器，匿名内部类完成。
        Set<String> set = new TreeSet<String>(new Comparator<String>(){
            public int compare(String o1,String o2)
            {
                int temp = o1.length()-o2.length();
                return temp==0?o1.compareTo(o2):temp;
            }
        });
        //添加元素。
        set.add("abcde");
        set.add("java");
        set.add("hello");

        for(Iterator<String> it = set.iterator();it.hasNext();)
        {
            String string = it.next();
            System.out.println(string);
        }
    }
}
/*
问：创建一个唯一性元素的集合要求排序。set -- treeset//按照长度排序，需要比较器。匿名内部类完成。”这段注解是什么意思？
答：创建一个唯一性元素的集合要求排序：需要存储不重复的元素，并且希望这些元素能按照一定的顺序排列。在Java中。set接口保证元素唯一性，而treeset实现类不仅能保证唯一性，还能对元素进行排序。

“set -- treeset”：指明使用treeset来实现这个集合。

按照长度排序，需要比较器：treeset默认按照元素的自然顺序（对于string就是字典序）排序。但这里需要按照字符串的长度排序，自然顺序不满足需求，因此必须提供一个自定义的比较器（Comparator)来定义“按长度比较”的规则。

“匿名内部类完成”：在创建treeset对象时，直接通过new comparator<String>(){}创建了一个没有名字的内部类实例，并在其中实现了 compare 方法。这种写法避免了单独定义一个类，代码更简洁。

简单来说，这句话解释了为什么使用treeset(需要排序且唯一)，为什么要传入比较器(默认排序不是按长度)，以及如何传入（使用匿名内部类）。
*/