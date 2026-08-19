package day20;

import java.util.Comparator;

public class ComparatorByLength implements Comparator<String>{
    public int compare(String o1,String o2)
    {
        int temp = o1.length()-o2.length();

        return temp == 0?o1.compareTo(o2):temp;
    }
}


//4月11日 复习
/*
import java.util.Comparator;

public class ComparatorByLength implements Comparator<String>{
    public int compare(String o1,String o2)
    {
        int temp = o1.length()-o2.length();

        return temp == 0?01.compareTo(o2):temp;
    }
}
*/
/*

问：return temp == 0?01.compareTo(o2):temp;在行代码是什么意思？

temp == 0：判断两个字符串的长度是否相等。

如果 相等（temp == 0 为真），则执行 o1.compareTo(o2)，即按字典顺序比较两个字符串（返回负数、0 或正数）。

如果 不相等（temp != 0），则直接返回 temp（即长度差的正或负），表示按长度排序，长度小的排在前面（升序）。
*/