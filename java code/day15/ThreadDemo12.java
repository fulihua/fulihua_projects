package day15;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer{
    final Lock lock = new ReentrantLock();//锁
    final Condition notFull = lock.newCondition();//生产
    final Condition notEmpty = lock.newCondition();//消费

    final Object[] items = new Object[100];//存储商品的容器。
    int putpter/*生产者使用的角标 */,takeptr/*消费者使用的角标 */,count/*计数器 */;

    /*生产者使用的方法，往数组中存储商品 */
    public void put(Object x) throws InterruptedException
    {
        lock.lock();
        try{
            while(count == items.length) //判断计数器是否已到数组长度。满了。
             notFull.await();//生产就等待。

             items[putpter] = x; //按照角标将商品存储到数组中

             if(++putpter == items.length) //如果存储的角标到了数组的长度，就将角标归零。
            putpter = 0;
            ++count;//计数器自增。
            notEmpty.signal();//唤醒一个消费者
        }
        finally{
            lock.unlock();
        }
        }

        public Object take() throws InterruptedException{
            lock.lock();
            try{
                while(count == 0) //如果计数器为0，说明没有商品，消费者等待。
                notEmpty.await();
                Object x = items[takeptr];//从数组中通过消费者角标获取商品。

                if(++takeptr == items.length)//如果消费的角标等于了数组的长度，将角标归零。
                takeptr = 0;
                --count;//计数器自减。
                notFull.signal();//唤醒生产者。
                return x;
            }finally{
                lock.unlock();
            }
        }
    }
    


    /*
    items[putpter] = x这行代码是什么意思？
    
    答：x是put 方法的参数 Object x，它代表生产者生产出来的商品对象。items[putptr] = x 的意思是
    将这个商品对象存放到数组 items 的 putptr 索引位置上。


    那为什么putptr是从0开始计数的？代码中也没有说putptr从0开始啊？

    答：putptr 才是从 0 开始自动管理的索引。代码中虽然没有显式写“从0开始”，
    但 Java 中整型变量的默认初始值就是 0，因此 putptr 自然从 0 开始。
    */

/*
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Conditon;
import java.util.condurrent.locks.ReentrantLock;


class BoundedBrffer
{
    final Lock lock = new ReentrantLock();
    final Conditon notFull = lock.newCondition();
    final Conditon notEmpty = locl.newConditon();

    final Object[] items = new Object[100];
    int putpter,takeptr,count;
    public void put(Object x) throws InterruptedException
    {
        lock.lock();
        try
        {
            while (count == items.length)
            {notFull.await();}
            
            items[putpter]= x;
            if(++puter == items.length)
            putpter = 0;
            ++count;
            notEmpty.signal();
        }
        finally{
        lock.unlock();}
    }
}

public Object take() throws InterruptedException {
lock.lock();
try{
    while(count == 0)
    {
        notEmpty.await();
        Object x = items[takeptr];
        if(++takeptr == items.length)
        takeptr = 0;
        --count;
        notFull.singnal();
         return x;
            }finally{
                lock.unlock();
            }
    }

}
*/
   