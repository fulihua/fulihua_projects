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
使用等待唤醒机制。
wait(),notify(),notifyAll();

对于等待都需要判断，定义条件。


要求3，对代码进行重构。
	将name，sex私有化，资源类提供对其访问的方法。

要求4，将程序改成JDK1.5的Lock Condition接口。
Lock替换了 同步函数或者同步代码块。

Condition替代了 监视器方法，将监视器方法从锁上分离出来，单独封装成Condition对象。
*/
import java.util.concurrent.locks.*;

//描述资源。
class Resource
{
    private String name;
    private String sex;
    //定义标记.
    private boolean flag = false;

    //先创建锁对象。
    private final Lock lock = new ReentrantLock();
    //通过锁对象获取监视器对象。
    private Condition con = lock.newCondition();

    //赋值功能。set负责给name和sex赋值，同时控制同步，并且保证生产者和消费者之间的协调！
    public void set(String name,String sex)
    {
        lock.lock();
        try{if(flag)
            try{con.wait();}catch(InterruptedException e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        con.signal();}//这里为什么不是signalAll?注意不要与多生产多消费问题搞混了，这是单生成单消费，只唤醒对方就可以了。
        finally{lock.unlock();

        }
        
    }

    //输出值。out负责输出name和sex，同时也保证同步和协调!
    public synchronized void out()
    {
        lock.lock();
        try{if(!flag)
            try{con.wait();}catch(InterruptedException e){}
        System.out.println(name+"-------"+sex);
        flag = false;
        con.signal();}
        finally{
            lock.unlock();
        }
        
    }

}
//赋值线程任务 决定生产什么数据
class Input implements Runnable
{
    private Resource r;
    Input(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while(true)
        {
            if(x==0)
            {
                r.set("张飞","男");
            }
            else{
                r.set("rose","女女女");
            }
            x=(x+1)%2;
        }
    }
}

//获取线程任务 负责消费数据（打印出来）。

   
class Output implements Runnable
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
            r.out();
        }
    }

}

class ThreadTest2_4
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
    set和input的区别：
    打个比方：

Resource 是一个共享邮箱。

set 方法是“往邮箱里放信”这个动作，它要检查邮箱是不是空的（有信就不能放），放进去后通知收信人。

Input 是写信的人，他决定写什么内容（是情书还是账单），然后执行“放信”这个动作（调用 set）。
    */




//3月12日  复习
/* 
import java.util.concurrent.locks.lock;
import java.util.concurrent.locks.ReentrantLock;
class Resource
{
	private String name;
	private String sex;
	//定义标记，
	private boolean flag = false;
    private final Lock lock = new ReentrantLock();
    private Condition con = lock.newConditon();

	//赋值功能。
	public void set(String name,String sex)
	{   
        lock.lock();
        try{
            if(flag)
			try{con.await();}catch(InterruptedException e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		con.signal();
        }finally{
            lock.unlock();
        }
		

	}

	//获取值。
	public void out()
	{
        lock.lock();
        try{
            if(!flag)
			try{con.await();}catch(InterruptedException e){}
		System.out.println(name+"------"+sex);
		flag = false;
		con.signal();
        }finally{
            lock.unlock();
        }
		
	}

}
//赋值线程任务
class Input implements Runnable
{
	private Resource r;
	Input(Resource r)//任务一初始化就必须有要处理的资源。
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x==0)
			{
				r.set("张飞","男");
			}
			else
			{
				r.set("rose","女女女女");
			}
			x = (x+1)%2;//实现切换。
		}
	}
}
//获取值线程任务
class Output implements Runnable
{
	private Resource r ;
	Output(Resource r)
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

class ThreadTest2_4
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

*/
/* 
improt java.util.concurrent.locks.*

class Resource
{
    private String name;
    private String sex;
    private boolean flag = false;
    private final Lock lock = new ReentrantLock();
    private Condition con = lock.newConditon();
    public void set(String name,String sex)
    {
        lock.lock();
        try{ if(flag)
            try{con.await();}catch(InterruptedException e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        con.signal();}
        finally{lock.unlock();}
       
    }
    public void out()
    {
        lock.lock();
        try{if(!flag)
            try{con.await();}catch(InterruptedException e){}
        System.out.println(name+"-------"+sex);
        flag = false;
        con.signal();}
        finally{lock.unlock();}
        
    }

}
class Input implements Runnable
{
    private Resource r;
    Input(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while(true)
        {
            if(x==0)
            {
                r.set("张飞","男");
            }
            else{
                r.set("rose","女女女");
            }
            x=(x+1)%2;
        }
    }
}  
class Output implements Runnable
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
            r.out();
        }
    }

}

class ThreadTest2_3
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

    




*/