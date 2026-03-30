package day19;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import day18.Student;

public class ArrayListTest {
    public static void main(String[] args)
    {
        List list = new ArrayList();
        //		list.add("abc1");
//		list.add("abc2");
//		list.add("abc1");
//		list.add("abc2");
//		list.add("abc1");
//		list.add("abc2");
		
		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi1",21));
        getSingleElement(list);//去除重复元素。
        System.out.println(list);

    }

    /*
    案例：去除List集合中的重复元素。

    思路：
    1.先创建一个临时容器，用于存储唯一性的元素。
    2.遍历原容器，将遍历到的元素到临时容器中去判断，是否存在。
    3.如果存在，不存储到临时容器，如果不存在，存储到临时容器中。
    4.遍历结束后，临时容器中存储的就是唯一性的元素。
    5.如果需要将这些唯一性的元素保留到原容器中，只要将原容器清空，将临时容器中的元素添加到原容器中即可。

    */
   public static void getSingleElement(List list)
   {
    //1.创建一个临时容器。
    List temp = new ArrayList();
    
    //2.遍历原容器。
    for(Iterator it = list.iterator();it.hasNext();)
    {
        Object obj = it.next();

        //对遍历的每一个元素都到临时容器中去判断是否包含。
        if(!temp.contains(obj))
        {//如果不存在
            temp.add(obj);//添加到临时容器。
        }
    }
   
   //唯一性的元素已经被记录到临时容器中。
   //清空原容器中的元素。
   list.clear();
   //把临时容器中的元素添加到原容器中。
   list.addAll(temp);
}
}

/*
问：Iterator it = list.iterator()这句话是什么意思？


答：这句话的意思是获取list集合的迭代器对象，并赋值给变量it.
拆解说明：

-  list.iterator() ：调用List集合的 iterator() 方法，返回一个实现了 Iterator 接口的对象，这个对象可以用来遍历 list 中的元素。

-  Iterator it = ... ：声明一个 Iterator 类型的变量 it ，并把刚才获取到的迭代器对象赋值给它。
 
迭代器的作用
 
拿到这个迭代器 it 后，就可以用它的方法来遍历集合：
 
-  it.hasNext() ：判断集合中是否还有下一个元素。

-  it.next() ：取出集合中的下一个元素。
*/