package day18;
import java.util.ArrayList;//导入动态数组类，用于存储数据。
import java.util.Iterator;//导入迭代器接口，用于遍历集合。
import java.util.List;//导入List接口，是ArrayList的父接口。

import cn.itcast.domain.Student;//导入自定义的Student类，用于创建学生对象。

public class ListDemo {
    public static  void main(String[] args)
    {
    /**
     * 使用List，解决，插入元素的问题。因为add方法追加。
     * List接口的特有方法，全部是围绕索引来定义的。
     * 
     * List获取元素的方式有两种：一种是迭代，一种是遍历+get
     * 
     * List接口是支持对元素进行增删改查动作的。
     */
    List list = new ArrayList<>();

    //1.添加元素。
        list.add(new Student("wangcai1",21));
		list.add(new Student("wangcai2",22));
		list.add(new Student("wangcai3",23));
        
    //2.插入元素。
//  list.add(1,new Student("xiaoqiang",25));

    //3.删除元素。
//  list.remove(2);//IndexOutOfBoundsException

    //4.修改元素。
    list.set(1,new Student("xiaoming",11));
//		Object obj = list.get(1);
//		System.out.println(obj);
    for(int i = 0;i<list.size();i++)
    {
        System.out.println("get("+i+"):"+list.get(i));
    }
//      for(Iterator it = list.iterator();it.hasNext();)
//{
    //  Student stu = (Student) it.next();
    // System.out.println(stu);
//}


    }
}
/*
疑问：迭代和遍历有什么区别？

答：遍历：是“访问所有元素“的行为总称。

    迭代：是遍历的一种具体方法，必须通过迭代器来实现。

    总结：遍历是对集合元素逐个访问的行为，迭代是使用迭代器实现遍历的一种方法，
    迭代属于遍历的一种具体手段。
*/