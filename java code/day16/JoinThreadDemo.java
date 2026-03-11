package day16;

class Demo implments Runnable
{
    public void run()
    {
        for(int x=1;x<40;x++)
        {
            System.out.println(Thread.currentThread().getName()+"------>"+x);
            Thread.yield();//线程临时暂停。将执行权释放，让其他线程有机会获取执行权。
        }
    }
    
}

class JoinThreadDemo
{
    public static void main(String[] args)
    {
        Demo d =new Demo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);

        t1.start();
        t2.start();
        try{t1.jion();}catch(InterruptedException e){}//用于临时加入一个运算的线程。让该线程运算完，程序才会继续执行。
        /*主线程执行到这里，知道t1要加入执行，主线程释放了执行权和
        执行资格并处于冻结状态，什么时候恢复呢？等t1线程执行完。
        */
       /*
       注意：
       这里的释放了执行权和执行资格并不是说释放后直接给了t1，而是释放后t1和t2都可能拿到（他们两个在争夺执行权），而什么时候主线程开始执行呢？
       是当t1执行完后，才开始执行。（不管t1在t2后面执行还是前面执行，主线程都在t1执行完后，执行）
       
       */

        for(int x = 1;x<50;x++)
        {
            System.out.pritln("main------>"+x);
        }
        System.out.println("over");
    }

}