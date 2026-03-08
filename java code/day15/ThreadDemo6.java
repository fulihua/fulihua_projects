package day15;

 //饿汉式。  多线程并发没有问题。为什么?因为虽然有共性变量，但是没有对共性变量进行多次操作。
 class Single{
    private static final Single s =new Single();
        private Single(){}
            public static Single getInstance()
            {
                return s;
            }
        
    }
 /*
 private Single(){} 是私有构造方法.它的作用是禁止外部通过 new Single() 来创建该类的实例。
 外部只能通过 public static Single getInstance() 获取这个唯一的实例。
 */
//懒汉式。
class Single
{
    private static Single s =null;
    
    private Single(){}
    public static Single getInstance()
    {
        if(s==null)
        {
            synchronized(Single.class)//注意：这里是static，应该用类名.class
            {
                if(s==null)
                    s = new Single();
            }
        }
        return s;

    }
}
/*
解释一下这个代码块的意思：
起初，我们定义了s=null，假设有线程0,1,2，共3个线程。
当线程0通过时，因为s==null，所以通过外层的If语句进入内部，获得锁，（此时线程1和2都符合外部If语句
的条件，也都进入到了内部，但由于线程0获得了锁，所以他们无法进入）s==null成立，将s改为
new Single（此时线程0终于把锁释放，线程1获得了锁，而在内部判断If语句时，由于线程0早已把s改为new Single();
所以线程1不能通过If条件语句），因此把其他隔绝在外，只能通过一个线程。
*/

/*
3月5日  复习
*/
//饿汉式
class Single
{
    private static final Sigle s = new Single();
    private Single(){}
    
        public staic Single getInstance()//这里我把Instance和interface搞混了！interface的作用才是在接口中定义方法！
                                        //而instance只是一个变量名！
        {
            return s;
        }
    

}

//懒汉式
class Single
{
    private  static Single s =null;
    s=null;
    private Single(){}
    
        public static Single getInstance()
        {
            if(s==null)
            {
                synchronized(Single.class)
                {
                    if(s==null)
                    s=new Single();
            
                }
            
            }
            return s;
        }
        }
    





//3月8日  复习

/*
//饿汉式
class Single
{
        private static final Single s = new Single();
        private Single(){}
        public static Single getInstance()
        {
            return s;
        }
}

//懒汉式
class Single
{
        private static Single s = null;
        private Single(){}
        public static Single getInstance()
        {
            if(s == null)
            {
                synchronized(Single.class)
                {
                    if(s==null)
                    s=new Single();
                }
            }
            return s;
        }
}
*/


