package day16;


//演示停止线程
class Demo implements Runnable
{
    private boolean flag = true;
    public synchronized void run()
    {
        while(flag)
        {try
            {
              wait();  
            
            }
        catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().toString()+"......"+e.toString());
            changeFlag();
        }
        System.out.println(Thread.currentThread().getName()+"------>");

    }
}

//对标记的修改方法
public void changeFlag()
{
    flag = false;
}
}


class StopThreadDemo{
    public static void main(String[] args)
    {
        Demo d = new Demo();

        Thread t1 = new Thread(d,"旺财");
        Thread t2 = new Thread(d,"小强");
        t1.start();
        //将t2标记为后台线程守护线程。
        //t2.setDemon(true);
        t2.start();

        int x =0;
        while(true)
        {
            if(++x==50)
            {
//              d.changeFlag();改变线程任务代码的标记，让其他线程也结束。
//              对t1线程对象进行中断状态的清除，强制让其恢复到运行状态。
                t1.interrupt();
 //              对t2线程对象进行中断状态的清除，强制让其恢复到运行状态。 
                 t2.interrupt();

                 break;//跳出主循环，主线程可以结束。
            }
            System.out.println("main--->"+x);
        }
        System.out.println("over");
    }
}



//3月12日  复习
class Demo2 implements Runnable
{
    private boolean flag = true;
    public synchronized void run()
    {
        while(true)
        {
            try{
                wait();
            }
            catch(InterruptedException e)
            {
                System.out.println(Thread.currentThread().toString()+"......"+e.toString());//tostring的作用是什么？
                changeFlag();
            }
            System.out.println(Thread.currentThread().getName()+"------>");

        }
    }
    public void changeFlag()
    {
        flag = false;
    }
}

class StopThreaddDemo
{
    public static void main(String[] args)
    {
        Demo d = new Demo();
        Thread t1 = new Thread(d,"旺财");
        Thread t2 = new Thread(d,"小强");
        t1.start();
        t2.start();
        
        int x =0;
        while(true)
        {
            if(++x==50)
            {
//              d.changeFlag();改变线程任务代码的标记，让其他线程也结束。
//              对t1线程对象进行中断状态的清除，强制让其恢复到运行状态。
                t1.interrupt();
 //              对t2线程对象进行中断状态的清除，强制让其恢复到运行状态。 
                 t2.interrupt();

                 break;
            }
            System.out.println("main--->"+x);
        }
        System.out.println("over");
    }
}


/*
toString() 的作用是将对象转换成字符串形式。
在这里，e.toString() 返回异常 e 的详细描述信息（包括异常类型和错误消息），
以便打印出来查看异常内容
*/





/*
class Demo implements Runnable
{
    private boolean flag = true;
    public synchronized void run()
    {
        while(flag)
        {try
            {
              wait();  
            
            }
        catch (InterruptedException e)
        {
            System.out.println(Thread.currentThread().toString()+"......"+e.toString());
            changeFlag();
        }
        System.out.println(Thread.currentThread().getName()+"------>");

    }
}
     public void changeFlag()
    {
        flag = false;
    }
}


class StopThreadDemo
{
    public static void main(String[] args)
    {
        Demo d = new Demo();
        Thread t1 = new Thread(d,"旺财");
        Thread t2 = new Thread(d,"小强");
        t1.start();
        t2.start();

        int x = 0;
        while(true)
        {
        if(++x == 50)
        {
            t1.interrupt();
            t2.interrupt();

            break;
        }
            System.out.println("main----->");
        }
            System.out.println("over");
    }

}
    
*/