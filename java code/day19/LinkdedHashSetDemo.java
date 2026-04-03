package day19;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkdedHashSetDemo {
    public static void main(String[] args)
    {
        //提高唯一性元素的查询效率，还想有序，可使用HashSet的子类LinkedHadhSet.

        Set set = new LinkedHashSet<>();

        set.add("abc");
        set.add("hahaha");
        set.add("java");
        set.add("itcast");

        for(Iterator it = set.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }
    }
}
