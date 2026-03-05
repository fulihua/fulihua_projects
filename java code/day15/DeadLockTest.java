package day15;

class Test implements Runnable
{
    private boolean flag;
    Test(boolean flag)
    {
        this.flag = flag;

    }
    public void run()
    {
        if(flag)
        {
            while(true)
            {
               synchronized(MyLock.LOCKA)
               {
                System.out.println(Thread.currentThread().getName()+"...if.....locka");
                synchronized(MyLock.LOCKB)
               {
                System.out.println(Thread.currentThread().getName()+"...if.....lockb");
                
               }
            }
        }
    }
    else
    {
        while(true)
        {
            synchronized(MyLock.LOCKB)
            {
                System.out.println(Thread.currentThread().getName()+"...else.....lockb");
                 synchronized(MyLock.LOCKA)
            {
                System.out.println(Thread.currentThread().getName()+"...else.....locka");


            }
        }
    }
}
    }
}
//定义一个用于存储锁对象类。
class MyLock
{
    public static final Object LOCKA = new Object();
    public static final Object LOCKB = new Object();

}

class DeadLockTest
{
    public static void main(String[] args)
    {
        //创建两个线程任务。
        Test t1 = new Test(true);
        Test t2 = new Test(false);

        Thread t11 = new Thread(t1);
        Thread t22 = new Thread(t2);
        t11.start();
        t22.start();
    }
}


/*
疑问：
1：为什么加上while（true）就一定能锁住？
答：不是一定可以锁住，而是锁住的概率很大。因为while（true）
其实就是一直在循环，可能几次锁不住，但是只要它一直在循环，那么锁住
的概率就会增大很多。只要某次循环中出现了“线程1持有A等B，线程2持有B等A”
的时序，就会卡死（死锁）。while(true) 不是“保证”死锁，而是让死锁更容易
复现，通过无限循环反复争夺锁，增加死锁概率！
*/


/*
3月5日  复习
*/

class Test implements Runnable
{
    private boolean flag;
    Test(boolean flag)
    {
        this.flag = flag;
    }
    public void Run()
    {
        if(flag)
        {
            while(true)
            {
               synchronized(MyLock.locka)
               {
                System.out.println(Thread.currentThread().getName()+"if...locka");

               } 
               synchronized(MyLock.lockb)
               {
                System.out.println(Thread.currentThread().getName()+"if...lockb");
                
               } 
            }
        }
        else
        {
            while(true)
            {
              synchronized(MyLock.lockb)
               {
                    System.out.println(Thread.currentThread().getName()+"if...lockb");
                    synchronized(MyLock.locka)
                    {
                    System.out.println(Thread.currentThread().getName()+"if...locka");
                   
                    }
               } 
               
            }
        }
    }
}
class MyLock
{
    public static final Object locka = new Object();
    public static final Object lockb = new Object();
    
}
class DeadLockTest
{
    public static void main(String[] args)
    {
        Test t1 = new Test(true);
        Test t2 = new Test(false);
        
        Thread t11 = new Thread(t1);//记住这个括号里面要写东西！！！
        Thread t22 = new Thread(t2);
        t11.start();
        t22.start();
        
    }
}

/*
死锁的示例中，为什么synchronized中必须用嵌套呢？
嵌套：一个线程在持有锁的同时请求另一个锁，这是死锁的必要条件。

分开：线程每次只持有一个锁，用完就释放，不会产生死锁。


要演示死锁，必须让两个线程同时持有对方需要的锁，这要求每个线程在获得第一把锁后，
不释放它就去请求第二把锁。嵌套结构天然满足这一要求，而分开的两个同步块则会让线程
释放锁后再去拿下一个，不会死锁！！！


*/


















                   
                