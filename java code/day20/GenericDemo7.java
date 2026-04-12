package day20;
import java.util.ArrayList;
import java.util.Collection;

public class GenericDemo7 {
    public static void main(String[] args)
    {
        /**
         * 通配符？在api中的体现
         * 
         * Collection接口： boolean containsAll(Collection<?> c)
         */
        Collection<String> c1 = new ArrayList<String>();
        c1.add("haha");
		c1.add("hehe");
		
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(4);
		c2.add(5);

        boolean b = c1.containsAll(c2);//了解 containAll源码内判断是否包含的依据。依据是equals方法。
										//public  boolean equals(Object obj) "abc".equals(5);
		System.out.println("b="+b);

    }
}

/**
 * class Collection<E>
 * {
 *      public boolean containsAll(Collection<?> c)
 *      {
 *      }
 * }
 */



/**
 * 不明确类型的情况下，传参就写通配符” —— 错。
通配符不是万能钥匙，它有使用限制（不能写，只能读为 Object）。当类型不明确但需要读写操作时，应该声明类型参数 <T>，或者在通配符上加边界（extends / super）。

一个简单的记忆口诀：

只读不写 → ? 或 ? extends T

只写不读 → ? super T

既要读又要写 → 用 <T>，不用通配符


 * 
 */


//4月12日

/*
public class GenericDemo7
{
    public static void main(String[] args)
    {
        //通配符？在api中的体现
        // Collection接口：bolean containsAll(Collection<?> c)
        Collection<String> c1 = new ArrayList<String>();
        c1.add("haha");
        c1.add("hehe");

        Collection<Integer> c2 = new ArrayList<Integer>();
        c2.add(4);
        c2.add(5);

        boolean b = c1.containsAll(c2);//了解containAll源码内判断是否包含的依据。依据就是equals方法。
                                        //public boolean equals(Obect obj) "abc".equals(5);
        System.out.println("b="+b);
    }
}
*/


/*
不明确类型的情况下，传参就写通配符--错
通配符不是万能钥匙，它有使用限制（不能写，只能读为Object).当类型不明确但需要读写操作时，应该声明类型参数<T>,或者在通配符上加边界(extends/super)


一个简单的记忆口诀：
只读不写：？或者？extends T
只写不读：？super T

既要读又要写:用<T>,不用通配符。
*/