package day20;

import java.util.LinkedList;

public class GenericDemo2 {
    public static void main(String[] args)
    {
//      Tool t = new Tool();
//      t.setObject(6);
//      String s = (String)t.getObject();
//      System.out.println(s);

        Tool<String> t = new Tool<String>();
//      t.setObject(6);//只要类型错误，编译就失败。避免了运行时的类型转换异常。
        String s = t.getObject();//省去了强转的麻烦。
        System.out.println(s);


        Queue<String> queue = new Queue<String>();
        queue.myAdd("abcd1");
		queue.myAdd("abcd2");
		queue.myAdd("abcd3");
        while(!queue.isNull())
        {
            String string = queue.myGet();
            System.out.println(string);
        }
    }
}
//jdk1.5有了新技术，泛型，改成如下这样：
//类中操作的对象确定不？不确定，用Object,需要转型，运行容易出异常。不喜欢。
//在定义时，就将不确定的对象的类型，定义成参数。由使用该类的调用者来传递对象类型。
class Tool<Q>//将泛型定义在类上，泛型类。
{
    private Q object;
    public Q getObject(){
        return object;
    }
    public void setObject(Q object)
    {
        this.object = object;
    }
}
class Queue<E>{
	//封装了一个链表数据结构。
	private LinkedList<E> link;
	/*
	 * 队列初始化时，对链表对象初始化。
	 */
	Queue(){
		link = new LinkedList<E>();
	}
	
	/**
	 * 队列的添加元素功能。
	 */
	public void myAdd(E obj){
		//内部使用的就是链表的方法。
		link.addFirst(obj);
	}
	
	/**
	 * 队列的获取方法。
	 */
	public E myGet(){
		return link.removeLast();
	}
	
	/**
	 * 判断队列中元素是否空，没有元素就为true。
	 */
	public boolean isNull(){
		return link.isEmpty();
	}
}



/*
//定义一个工具对对象进行操作，比如设置和获取。可以对任意对象进行操作。对共性类型Object操作。
//定义Object就可以了。但用的时候，因为提升为了Oject，想要使用特有内容，需要向下转型。容易引发ClassCastException:
clss Tool{
    private Object object;
     
    public Object getObject()
    {
        return object;
    }
    public void setObject(Object object)
    {
        this.object = object;
    }
}
*/


//4月11日 复习
/*
import java.util.LinkedList;
public class GenericDemo2
{
    public static void main(String[] args)
    {
    Tool<String> t = new Tool<String>();
    // t.setObject(6);//只要类型错误，编译就失败。避免了运行时的类型转换异常。
    String s = t.getObject();//省去了强转的麻烦。
    System.out.println(s);

    Queue<String> queue = new Queue<String>();
    queue.myAdd("abcd1");
    queue.myAdd("abcd2");
	queue.myAdd("abcd3");
    while(!queue.isNull())
        {
            String string = queue.myGet();
            System.out.println(string);
        }
    }
}
//jdk1.5有了新技术，泛型，改成如下这样：
//类中操作的对象确定不？不确定，用Object，需要转型，运行容易出异常，不喜欢。
//在定义时，就将不确定的对象的类型，定义成参数。由使用该类的调用者来传递对象类型。
class Tool<Q>//将泛型定义在类上，泛型类。
{
    private Q object;
    public Q getObject(){
        return object;
    }
    public void setObject(Q object)
    {
        this.object = object;
    }
}
class Queue<E>{
    //封装了一个链表数据结构。
    private LinkedList<E> link;
    //队列初始化时，对链表对象初始化。
    Queue(){
        link = new LinkedList<E>();
    }
     //队列的添加元素功能
     public void myAdd(E obj)
     {
        //内部使用的就是链表的方法。
        link.addFirst(obj);
        //使用 addFirst 是为了确保“先进先出”（FIFO）的顺序。
        如果只用普通的 add（默认在尾部添加），那么配合 removeLast 也能实现队列，
        但 addFirst 更清晰地表达了“从头部入队”的设计意图。
        //问:那我使用了addFirst后，添加下一个元素时，用不用写addsecond?
        答：不需要写 addSecond。LinkedList 类中只有 addFirst（在头部添加）和 addLast（在尾部添加），没有 addSecond。
        每当你添加一个新元素，只需要根据需要选择 addFirst 或 addLast 即可，它们每次都会在指定的端点插入新元素。
        //注意：如果你想保证每次添加到元素都在首部。那就每添加一个元素，就调用一次 addFirst！！！addLast同理！！！
     }
    //队列的获取方法。
    public E myGet(){
        return link.removeLast();
        //removeLast() 的作用就是删除并返回链表中的最后一个元素。
    }
        //判断队列中元素是否为空，没有元素就true。
        public boolean isNull(){
            return link.isEmpty();
        }
}
*/

/*
//定义一个工具对对象进行操作，比如设置和获取。可以对任意对象进行操作。对共性类型Object操作。
//定义Object就可以了。但用的时候，因为提升为了Oject，想要使用特有内容，需要向下转型。容易引发ClassCastException:
clss Tool{
    private Object object;
     
    public Object getObject()
    {
        return object;
    }
    public void setObject(Object object)
    {
        this.object = object;
    }
}
*/
