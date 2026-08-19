package day18;
import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args)
    {
//      Collection coll = new ArrayList();//目前演示Collection的方法，不关系子类对象的类。
//      注意：这里是向上转型！！！什么是向上转型：当你用父类型的引用（Collection coll）指向子类型的对象（new ArrayList())时，就叫向上转型。
//      collectionDemo(coll);
        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        collectionDemo2(c1,c2);


    }
    //演示Collection中带all方法。
    public static void collectionDemo2(Collection c1,Collection c2)
    {
        //1.给两个集合添加元素。
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");



          c2.add("abc1");
          c2.add("abc4");
          c2.add("abc5");
          

          //添加所有c2的元素到c1中。
          // c1.addAll(c2);

          //boolean b = c1.containsAll(c2);
          //System.out.println("b="+b);    //true
//注意：c1.containsAll(c2);判断集合中是否包含另一个集合的所有元素。

          
          //boolean b = c1.contains(c2);
          //System.out.println("b="+b);    //false
//注意：c1.contains(c2);这个方法的含义是：判断c1这个集合里，是否直接存储了c2这个集合对象本身。而不是判断c1是否包含c2里的所有元素。


//             删除c1中所有和c2相同的元素。
//              c1.removeAll(c2);

//              保留了c1中和c2相同的元素。
                c1.retainAll(c2);

                //打印
                System.out.println("c1="+c1);
    }
    //演示Collection中常见的一般方法。
    public static void collectionDemo(Collection coll)
    {
        //1.往集合中添加对象元素，add(Object);
        coll.add("itcast1");
        coll.add("itcast2");
        coll.add("itcast3");


        //2.删除。
        //coll.remove("itcast2");

        //3.判断是否包含。
        System.out.println(coll.contains("itcast11"));

        //4.清除。
        coll.clear();
        //把集合打印一下。
        System.out.println(coll);//[itcast1,itcast2,itcast3]

    }
}



/*
疑问：怎么判断是向上转型还是向下转型？


答：/*
    public class Test
    {
        public static void main(String[] args)
        {
            //1.向上转型：父接口 指向 子类对象
            Collection coll = new ArrayList();

            //2.向下转型：强制转回子类类型
            ArrayList list = (ArrayList)coll;
        }
    }
*/
*/