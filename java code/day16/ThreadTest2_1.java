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