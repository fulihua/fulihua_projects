package day19;
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args)
    {
        /**
         * 面试题：用LinkedList模拟一个堆栈或者队列数据结构。
         * 创建一个堆栈或者队列数据结构对象，该对象中使用LinkedList来完成的
         * 
         * 
         * 作业：自定义堆栈结构。
         */

        //创建一个队列对象。
        Queue queue = new Queue();
        //往队列中添加元素。
        
        queue.myAdd("itcast1");
        queue.myAdd("itcast2");
        queue.myAdd("itcast3");
        queue.myAdd("itcast4");

        while(!queue.isNull())
        {
            System.out.println(queue.myGet());
        }
    }
}

/*
定义一个队列数据结构，Queue

*/
class Queue{
    //封装了一个链表数据结构。
    private LinkedList link;//意思为“我这个类里，有一个私有的、名叫 link 的、用来存放数据的 LinkedList 容器”。
    /**
     * 队列初始化时，对链表对象初始化；
     */
    Queue()
    {
        link = new LinkedList();
    }

    /**
     * 队列的添加元素功能。
     */
    public void myAdd(Object obj)
    {
        //内部使用的就是链表的方法。
        link.addFirst(obj);
    }

    /**
     * 队列的获取方法。
     */
    public Object myGet()
    {
        return link.removeLast();
    }

    /**
     * 判断队列中元素是否为空，没有元素就位true。
     */
    public boolean isNull()
    {
        return link.isEmpty();
    }
}




/**
 * 疑问：对链表对象初始化；为什么要写link = new LinkedList();？



 *答：link = new LinkedList(); 的作用是在队列对象被创建时，就为内部的链表成员分配内存并初始化一个真实的 LinkedList 对象，
 确保后续对 link 的操作（如 add、remove 等）都是在有效的对象上进行，不会出现空指针异常。 

 追问：既然内部的链表成员需要分配内存并初始化一个真实的 LinkedList 对象，那为什么又要private LinkedList link;呢？

 答：声明 private LinkedList link;
就像你在建房子之前，先在图纸上画了一个“房间”的位置，并注明“这里要放一个链表”。这个房间还没有实际建起来，只是预留了一个位置。

初始化 link = new LinkedList();
就像你在施工时，真正把那个房间建好了，可以放东西了。

如果没有声明，编译器根本不知道这个类里会有 link 这个变量；
如果没有初始化，这个 link 就只是一个空地址（null），任何试图用 link 做事情（比如 link.add()）都会直接报错崩溃。

两者缺一不可。


继续追问：那如果我没有私有化这个LinkedList link;那在构造函数中是不是就不用写初始化了？


答：不是的。 无论成员变量是 private、public 还是 protected，它都只是一个引用，默认值为 null。如果不通过 new 创建对象，任何对这个变量的操作（如 link.add()）都会抛出 NullPointerException。

私有化（private）控制的是外部能否直接访问这个变量，而初始化是确保变量指向一个真实的对象，两者没有直接关系。即使在构造函数中不写 link = new LinkedList();，你也必须在某个时刻为它赋值，否则它就是空引用，无法使用。


 */



/**
 * 问：你提到说当多个元素依次插入时，先插入的会被后插入的“挤”到后面。所以LinkedList是个堆栈结构吗?这段代码中利用了LinkedList的哪些功能和特性呢？
 * 
 * 
 * 答：LinkedList 本身是一个双向链表，既可以模拟堆栈（后进先出），也可以模拟队列（先进先出），具体行为取决于使用哪些方法。
 * 意思就是LinkedList 本身既不是堆栈结构也不是队列结构，但是可以通过写方法来使它呈现（或者输出）堆栈或者队列的方式！！！
 * 
 * 1. 使用了 LinkedList 的哪些方法？
addFirst(Object obj)
removeLast()
isEmpty()


2.LinkedList 作为双向链表的特性
双端高效操作：addFirst 和 removeLast 的时间复杂度都是 O(1)，非常适合实现队列。

动态扩容：链表不需要预先分配固定容量，可以无限增长（受内存限制）。

允许存储任意对象：因为方法参数是 Object 类型，所以可以存储任何 Java 对象。



3. LinkedList 本身不是堆栈，但可以模拟堆栈
如果我们只用 addFirst 和 removeFirst，就会得到后进先出（LIFO）的堆栈行为。而这里用 addFirst 配合 removeLast，则得到了队列行为。
所以 LinkedList 是一个灵活的数据结构，既可以作栈也可以作队列，取决于方法组合。


 */

