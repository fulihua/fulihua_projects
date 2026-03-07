package day15;

/* E:\Java_Code day15>javac ThreadDemo11.java
ThreadDeno11.java:22: 错误：找不到符号
private Lock lock = new ReentrantLock<>;
符号：类 Lock
位置:类 Resource
ThreadDeno11.java:22: 错误：找不到符号
private Lock lock  new ReentrantLock<>;
符号：类 Lock
位置:类 Resource
2个错误

这个报错表示：
需要有全类名！后续做法：简化类名书写。
*/



/*
在 Java 中，简化类名书写的主要方式是使用 import 语句，
这样在代码中就可以直接使用类的简单名称，而不必每次都写完整的包名（全限定名）。

1. 导入单个类
import 包名.类名;

2. 导入整个包下的所有类（按需导入）
import 包名.*;

3. 静态导入（简化静态成员访问）
import static 包名.类名.静态成员;
*/


/*import java.util.concurrent.locks.*;
这样写是为了方便，在开发过程中应该写两个，这是什么意思？

答：在 Java 中，import 语句用来简化类名的书写。有两种写法：

通配符导入：import java.util.concurrent.locks.*;
这表示导入该包下的所有类，写起来方便，但可能导入许多不需要的类，降低代码可读性，有时还会引起命名冲突。

精确导入：import java.util.concurrent.locks.Lock; 和 import java.util.concurrent.locks.ReentrantLock;
（开发过程中，应该写这两个）只导入你用到的具体类，代码更清晰，团队协作时也更规范。



其中需要分清：
java.util.concurrent.locks：包路径

Lock：该包下的一个接口

ReentrantLock：该包下的一个类

*/

import java.util.concurrent.locks.*;
//更精确的写法：import java.util.concurrent.locks.Lock; 和 import java.util.concurrent.locks.ReentrantLock;
//import 语句必须位于文件顶部，package 语句之后（如果有的话）。

class Resource2
{
    private String name;
    private int count = 1;

    //定义一个锁对象。
    private final Lock lock = new ReentrantLock();
    //获取锁上的Condition对象，为了解决本方唤醒对方的问题。可以一个锁创建两个监视器对象。

    private Condition produce = lock.newCondition();//这里建立新对象不用再new了，Condition中已经new好了！
    private Condition consume = lock.newCondition();
    //定义标记。
    private boolean flag = false;

    //1，提供设置的方法。
    public void set(String name)
    {
        //获取锁。
        lock.lock();

        //为什么获取锁要用lock.lock?
        /*
        答：在 Java 中，synchronized 关键字是隐式锁，进入同步代码块时自动获取锁，
        退出时自动释放，你不需要手动操作。而 Lock 接口（如 ReentrantLock）是显式锁，
        它提供了比 synchronized 更灵活的锁操作，但灵活性也带来了责任：你必须手动调用 lock() 来获取锁，并在使用完毕后手动调用 unlock() 释放锁
        （通常放在 finally 块中保证一定释放）。
        */
       try{
        while(flag) 
            try{produce.await();}catch(InterruptedException e){}
        //wait() 的 try-catch 是必需的，因为它会抛出受检异常。
        //这段代码的意思就是如果flag为true，那么就让生产者等待。

        //给成员变量赋值并加上编号。
        this.name= name + count;
        //编号自增
        count++;
        //打印生产了哪个商品。
        System.out.println(Thread.currentThread().getName()+"....生产者..."+this.name);

        //将标记改为true。
        flag = true;
        //唤醒消费者。
        consume.signal();
        }finally{
        lock.unlock();//一定要执行。
        }
    }
    public void out()
        {
        lock.lock();
        try{
        while(!flag)
            try{consume.await();}catch(InterruptedException e){}
        System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
        //将标记改为false
        flag = false;
        //唤醒生产者。
        produce.signal();
        }
    finally{
        lock.unlock();
        }
    
        }


}

//2,描述生产者。
class Producer implements Runnable
{
    private Resource2 r;
    //生产者一初始化就要有资源，需要将资源传递到构造函数中。
    Producer(Resource2 r)//如何区分构造函数和普通函数呢？                                             
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.set("面包");
        }
    }
}

//3，描述消费者。
class Consumer implements Runnable
{
    private Resource2 r;
    //消费者一初始化就要有资源，需要将资源传递到构造函数中。
    Consumer(Resource2 r)

    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.out();
        }
    }
}

class ThreadDemo10
{
    public static void main(String[] args)
    {
        //1.创建资源对象。
        Resource2 r = new Resource2();
        //2，创建线程任务。
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //3，创建线程。
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }

}



/*
jdk1.5以后提供多生产多消费的解决方案。

在java.util.concurrent.locks 软件包中提供相应的解决方案
    Lock接口：比同步更厉害，有更多操作。lock():获取锁 unlock():释放锁；
            提供了一个更加面对对象的锁，在该锁中提供了更多的显示的锁操作。
            替代同步。

升级到jdk1.5，先把同步改成lock。

已经将旧锁替换成新锁，那么锁上的监视器方法（wait，notify，notifyAll)也应该替换成新锁的监视器方法。
而jdk1.5中将这些原有的监视器方法封装到了一个Condition对象中。
想要获取监视器方法，需要先获取Condition对象。

Condition对象的出现其实就是替代了Object中的监视器方法。
await();
signal();
signalAll();

将所有的监视器方法替换成了Condition.
功能和ThreadDemo10.java老程序的功能一样，仅仅是用新的对象。改了写法而已。
但是问题依旧：效率还是低。

希望本方可以唤醒对方中的一个。
老程序中可以通过两个锁嵌套完成，但是容易引发死锁。

新程序中，就可以解决这个问题，只用一个锁，
可以在一个锁上加上多个监视器对象。
*/