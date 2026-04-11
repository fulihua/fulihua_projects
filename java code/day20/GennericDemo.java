package day20;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GennericDemo {
    public static void main(String[] args)
    {
        /*
        为了让集合使用更安全。
        问题：什么类型的元素都可以存储。导致取出时，如果出现强转就会引发运行时 ClassCastException.
        能不能在创建集合时，就明确容器中的元素的类型，如同数组一样。
        目的是为了更安全。
        JDK1.5以后，出现了解决方案，使用容器时，必须明确容器中元素的类型。
        这种机制：称之为：泛型。
        体现<数据类型>，不是很难理解，<>也是括号，往括号里面写东西其实就是在传递参数。
        泛型：
        1.安全机制
        2.将运行时期的ClassCastException,转移到了编译时期变成了编译失败。
        3.泛型技术，是给编译器使用的技术。
        4.避免了强转到麻烦。
        */
       //int[] arr = new int[];
       //创建集合时，直接在集合上明确要存储的元素的类型。
       List<String> list = new ArrayList<String>();

       list.add("abc");
       list.add("zzz");
//      list.add(6);//只要不是指定的类型对象，编译器检查会报错。这样将运行的问题转移到编译时期。

        for(Iterator<String> it = list.iterator(); it.hasNext();)
        {
            //Oject object = (Object) it.next();
            //System.out.println(object.toString());
            //想要打印字符串的长度。
            String str = it.next();
            System.out.println(str.length());
        }

    }
}


//4月11日

/*
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GennericDemo
{
    public static void main(String[] args)
    {
       //创建集合时，直接在集合上明确要存储的元素的类型。
       List<String> list = new ArrayList<String>();

       list.add("abc");
       list.add("zzz");
//      list.add(6);//只要不是指定的类型对象，编译器检查会报错。这样将运行的问题转移到编译时期。

        for(Iterator<String> it = list.iterator();it.hasNext();)
        {
            //Object object = (Object) it.next;
            //System.out.println(object.toString());
            //想要打印字符串的长度。
            String str = it.next();
            System.out.println(str.length());
            }
    }
}
*/



/*
        为了让集合使用更安全。
        问题:什么类型的元素都可以存储。导致取出时，如果出现强转就会引发运行时 ClassCastException.
        能不能在创建集合时，就明确容器中的元素的类型，如同数组一样。
        目的是为了更安全。
        JDK1.5以后，出现了解决方案，使用容器时，必须明确容器中元素的类型。
        这种机制：称之为：泛型。
        体现<数据类型>，不是很难理解，<>也是括号，往括号里面写东西其实就是在传递参数。
        泛型：
        1.安全机制
        2.将运行时期的ClassCastException,转移到了编译时期变成了编译失败。
        3.泛型技术，是给编译器使用的技术。
        4.避免了强转的麻烦。
        */