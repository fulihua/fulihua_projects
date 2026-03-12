package day15;


//两个客户到一个银行去存钱，每个客户一次存100，存3次。
//问题：该程序是否有安全问题，如果有，写出分析过程，并定义解决方案。

/*
发现运行结果：
sum=200
sum=200
sum=300
sum=400
sum=500
sum=600

打印错乱，不关心，但是发现数值错误，没有100.
运行了几次发现有对的。
sum=100
sum=300
sum=400
sum=200
sum=500
sum=600

说明多线程的随机性造成了安全问题的发生。
哪的问题啊？
1.既然是多线程的问题，必须问题发生在线程任务内。
2，任务代码中是否有共性数据呢？有的，b对象中的sum.
3,是否有对sum进行多次运算呢？有！

加同步就搞定。

*/

//描述银行。

class Bank
{
    private int sum;
    private Object obj = new Object();
    public void add (int num)
    {
        synchronized(obj)
        {
        sum = sum +num;
        System.out.println("sum="+sum);//每存一次，看到银行金额变化。
        }
    }
}
class Consumer implements Runnable
{
    private Bank b = new Bank();
    public void run()
    {
        for(int x=0;x<3;x++)
        {
            b.add(100);//一次存100，循环3次。
        }
    }

}
/*
这里的implements是什么意思？作用是什么？
答：implements是实现的意思，作用是写出遵守接口的方法。具体遵守什么规定要看interface里面
的代码（interface=规定：必须做那几件事）

为什么这段代码里面没有interface的函数呢？
答：因为Runnable是Java自带的接口，你不需要自己写interface，因为
Java早给你写好了。
Runnable接口里到底有啥？
答：它里面只有一个方法：
public interface Runnable {
    public abstract void run();
}
    所以：你只要implements Runnable,就必须写run()方法！
*/


 class ThreadTest 
 {
    
    public static void main(String[] args)
    {
        Consumer c =new Consumer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}





/*
3月4日  复习
*/
class Bank
{
    private Object obj = new Object();
    private  int sum;
    public void add(int num)
    {
        synchronized(obj)
        {
        sum=sum+num;
        System.out.println("sum="+sum);
        }
    }
}

class Consumer implements Runnable
{
    private Bank b = new Bank();
    public void run()
    {
        for(int x=0;x<3;x++)
        {
            b.add(100);
        }
    }
}


class ThreadTest
{
    public static void main(String[] args)
    {
     Consumer c = new Consumer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}


/*
3月5日 复习
*/

class Bank
{
    private Object obj = new Object();
    private int sum;
    public void add(int num)
    {
        synchronized(obj)
        {
            sum=sum+num;
            System.out.println("sum="+sum);
        }

    }
}
class Consumer implements Runnable()
{
    private Bank b = new Bank;
    public void run()
    {
        for(int x=0;x<3;x++)
        {
            b.add(100);
        }
    }
}
class ThreadTest
{
    public static void main(String[] args)
    {
        Consumer c = new Consumer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}


//3月8日  复习
/*
class Bank
{
    private int sum;
    public int num;
    private Object obj = new object();
    public void add(num)
    {   
        synchronized(obj)
        {
            sum = sum + num;
            System.out.println("sum="+sum);
        }
    }

}

class Consumer implements Runnable
{
    private Bank b = new Bank();
    public void run()
    {
        for(int x =0;x<=3;x++)
        {
            b.add(100);
        }
    }
}
class ThreadTest
{ 
    public static void main(String[] args)
    {
        Consumer con = new Consumer();
        Thread t1 = new Thread(con);
        Thread t2 = new Thread(con);
        t1.start();
        t2.start();
    }

}

*/




/*
让我来总结一下：当我需要在一个新线程中执行任务时：有两种方法：
1.实现Runnable接口，并通过对象.start()的方法调用。

2.继承Thread类，并通过对象.start()的方法调用。


也就是说实现Runnable接口的作用:就是在一个新线程中定义执行任务,然后配合 Thread 才能在新线程中执行该任务。
*/




//更深层的理解：
/*
让我来总结一下：当我需要在一个新线程中执行任务时：有两种方法：
1.实现Runnable接口，并通过对象.start()的方法调用。

2.继承Thread类，并通过对象.start()的方法调用。
不是说一个新线程中执行任务时：有两种方法吗？
你又提到说Thread线程中需要有一个可执行的run()方法，那这两种方法实际上不就是一种方法了吗？


答：你提到的疑问是：“这两种方法实际上不就是一种方法了吗？”——因为它们最终都需要提供一个 run() 方法的实现，
线程启动后都会执行这个 run() 方法。从执行效果来看，它们确实都依靠 run() 方法定义任务，但它们在代码结构和设计思想上有重要区别。


无论哪种方式，最终线程启动后都会调用某个 run() 方法。从底层看，它们确实是“一种机制”——都是通过 Runnable 接口来提供任务代码。



两种方式的本质区别
方式	           如何提供 run() 方法	                                特点
实现 Runnable	单独写一个类实现 Runnable，把该类的对象传给 Thread 构造器。	 任务与线程分离：任务代码独立，可以被多个线程共享，更灵活。
继承 Thread	    直接创建 Thread 的子类，在子类中重写 run() 方法。	        任务与线程耦合：每个线程子类只包含自己的任务代码，无法共享。

两种方法本质都是让线程执行一个 run() 方法，这是 Java 线程模型的核心。

区别在于 run() 方法的来源：是来自外部传入的 Runnable 对象，还是来自 Thread 子类自身的重写。


所以更推荐runnable.



*/