   class Ticket implements Runnable
{
	private int tickets = 100;
	private Object obj = new Object();
	boolean flag = true;
	public void run()
	{
		
			while(true){
				synchronized(obj){
					if(tickets>0){
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+"...obj..."+tickets--);//打印线程名称。
					}
				}
			}
    }
}


 class Ticket implements Runnable
{
	private int tickets = 100;
	private Object obj = new Object();
	boolean flag = true;
	public synchronized void run()//多加了synchronized
	{
		
			while(true){
				synchronized(obj){
					if(tickets>0){
						try{Thread.sleep(10);}catch(InterruptedException e){}
						System.out.println(Thread.currentThread().getName()+"...obj..."+tickets--);//打印线程名称。
					}
				}
			}
    }
}
/*
这段代码和上面的代码的区别就是多加了一个synchronized函数，
但是下面这个代码块却行不通，为什么？因为这个代码块中（详见ThreadDemo4.java的代码）
是多个线程共享一个数据，那么同一时刻就只有一个线程进入代码块。而while（true）是无限循环，
并且循环体完全被synchronized包裹，由于这个循环是无限的，而且循环内没有释放锁的操作，所以
这个线程将一直持有锁，并永远不会释放（实际上这有一个线程在工作）。这就和单线程一样了！
*/


/*
总结：使用sychronized时，只同步操作共享数据的代码！！！
*/

/*
3月5日 复习

synchronized 的作用是：当多个线程访问同一个对象的同步代码块或方法时，
对于同一个锁对象，同一时刻只能有一个线程持有该锁并执行，其他线程必须等待锁释放后才能继续。

总结：使用synchronized时，只同步操作共享数据吗的代码！！！
*/

//3月8日  复习
/*
总结：使用synchronized时，只同步操作共享数据的代码！！！

synchronized的作用是：当多个线程访问同一个对象的同步代码块或方法时，
对于同一个锁对象，同一时刻只能有一个线程持有该锁并执行，其他线程必须等待锁释放后才能继续。
*/