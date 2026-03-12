package day16;

/*
需求：
资源有姓名和性别。
两个线程，
	一个负责给姓名和性别赋值，
	一个负责获取姓名和性别的值。

参阅ThreadTest2.java文件

要求1，运行一下，解决程序的 "妖"的问题。
	分析过程：
	加入同步，必须保证同一个锁，解决妖的问题。

要求2，实现正确数据的间隔输出 如 
张飞--男
rose--女女女
张飞--男 
rose--女女女

要求3，对代码进行重构。
	将name，sex私有化，资源类提供对其访问的方法。

要求4，将程序改成JDK1.5的Lock Condition接口。

*/



//描述资源。
class Resource
{
    String name;
    String sex;
}
//赋值线程任务
class Input implements Runnable
{
    private Resource r;
 //   private Object obj = new Object();
    Input(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;//x是啥作用啊？后面实现切换。
        while(true)//这里的目的就是让他一直循环！
        {           
            synchronized(r)
            {
                if(x == 0)
                {
                    r.name = "张飞";
                    r.sex = "男";
                }
                else{
                    r.name = "rose";
                    r.sex = "女女女";
                }
            }
            x = (x+1)%2;//实现切换。
        }
    }
}
//获取值线程任务
class Output implements Runnable
{
    private Resource r;//为啥out和in里面都要定义，那怎么保证里面的r都是一样的呢？this.r=r;
 //   private Object obj = new Object();
    Output(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            synchronized(r)
            {
                System.out.println(r.name+"..."+r.sex);//这里和上面if,else的任务其实是一起的，所以需要共享数据同步。
            }
    
            
        }
    }
}
class ThreadTest2
{
    public static void main(String[] args)
    {
        Resource r = new Resource();
        Input in = new Input(r);
        Output out = new Output(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}



/*
//同步前都要加判断吗？

答：如果只是保护共享数据不被多个线程同时修改（比如两个
线程对同一个计数器做递增操作），那么直接用 synchronized 包裹代码即可，
不需要任何额外的条件判断

当线程需要满足特定条件才能继续执行，否则应该等待时，就需要在同步块内判断条件。
最常见的例子就是生产者-消费者模式。


总结：

纯互斥访问（如计数器、状态更新）→ 不需要条件判断。

线程协作（如等待资源、信号通知）→ 必须加判断（通常用 while 循环）
*/



//3月12日  复习
class Resource
{
    String name;
    String sex;
}

class Input implements Runnable
{
    private Resource r;
    Input(resource r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while(true)
        {
            synchronized(r)
            {
                if(x==0)
                {   r.name = "张飞";
                    r.sex = "男";
                }
                else
                {
                    r.name = "rose";
                    r.sex = "女";
                }
            }
              x=(x+1)%2;
        }
    }
}


class Output implements runnable
{
    private Resource r;
    Output(Resource r)
    {
        this.r = r;
    }
   public void run()
    {
         while(true)
    {
        synchronized(r)
        {
            System.out.println(r.name +"..."+r.sex);
        }
        
    }
    }
   
}

class ThreadTest2_1
{
    public static void main(String[] args)
    {
        Resource r = new Resource();
        Input in =new Input(r);
        Output out = new Output(r);
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }

}

/*
为什么要加synchronized(r)同步？

通过在 synchronized(r) 代码块中操作，相当于给 r 对象加锁。同一时刻只能有一个线程持有 r 的锁，从而保证了：

Input 对 r 的修改是原子性的（两个赋值操作不会被其他线程打断）。

Output 读取到的数据是最新、完整的（因为进入同步块会强制刷新内存）。


*/

//为什么 Thread t1 = new Thread(r);
//       Thread t2 = new Thread(r);不能这样写?而要写成这样呢？
 //       Thread t1 = new Thread(in);
//		Thread t2 = new Thread(out);
//答：只有那些提供了 run() 方法的具体实现的对象，才能被 Thread 接受并作为线程的任务来执行。
//所以线程中一定需要传入一个提供了run方法的函数!!!


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


/*
补充注意：
Input函数中的这段代码：

                if(x == 0)
                {
                    r.name = "张飞";
                    r.sex = "男";
                }
                else{
                    r.name = "rose";
                    r.sex = "女女女";
                }

和Output函数中的这段代码：
                System.out.println(r.name +"..."+r.sex);
其实是一起的，只不过分开执行了而已，他们之间的数据还是要共享的，不然就会出现这样的错误：
线程交叉执行：例如 Input 执行到一半（刚把 name 改成“张飞”，还没来得及改 sex），此时 Output 线程抢到 CPU 并执行打印，就会输出“张飞.....null”或“张飞.....女”等错误数据。
所以要加一个同步保证数据的一致，还值得注意的是：synchronized（）括号里面的都是r,说明：
通过在 synchronized(r) 代码块中操作，相当于给 r 对象加锁。同一时刻只能有一个线程持有 r 的锁，从而保证了线程的安全！！！

*/