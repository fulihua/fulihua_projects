package day19;
import java.util.LinkedList;



public class LinkedListDemo {
    public static void main(String[] args)
    {
        /**
         * LinkdedList做个了解。
         * 
         * 特点：围绕头和尾展开定义的。First Last.
         * addFirst();
         * addLast();
         * 
         * getFirst();获取头部元素
         * getLast();
         * 
         * removeFirst();获取头部元素，并删除头部元素。
         * removeLast();
         */

        LinkedList link = new LinkedList();

        link.addFirst("abc1");
        link.addFirst("abc2");
        link.addFirst("abc3");
        

//      System.out.println(link.getFirst());
//      System.out.println(link.getFirst());

//      System.out.println(link.removeFirst());
//      System.out.println(link.removeFirst());
//      System.out.println(link.removeFirst());
//      System.out.println(link.removeFirst());  报错！

/*
注意：这里的removeFirst返回的是删除的这个元素，而不是删掉这个元素后剩下的元素！！！

*/
        while(!link.isEmpty())
        {
            System.out.println(link.removeLast());
        }

    }
}
