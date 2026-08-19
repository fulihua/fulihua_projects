package day20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class GenericTest2 {
    public static void main(String[] args)
    {
        /**
         * 案例：获取集合中元素的最大值。
         * 
         * 思路：1.定义变量记录每次比较后较大的值，初始化元素中任意一个。
         * 2.遍历容器
         * 3.在遍历中和变量中记录的元素进行比较。并将较大的值记录到变量中。
         * 4.遍历结束，变量中记录的就是最大值。
         */


        Collection<Student> c1 = new ArrayList<Student>();
        c1.add(new Student("xioaming1",30));
        c1.add(new Student("xiaoming1", 30));
		c1.add(new Student("xiaoming2", 36));
		c1.add(new Student("xiaoming3", 22));
//      c1.add(new Dog());

        Student stu = getMax(c1);
        System.out.println(stu);

       Collection<String> c2 = new ArrayList<String>();
		c2.add("abcd");
		c2.add("java");
		c2.add("z");
		c2.add("nba");
        String s = getMax(c2);
        System.out.println("s="+s);

        Collection<Dog> c3 = new ArrayList<Dog>();
//      getMax(c3);//已经做了限定，说明传递的集合中的元素类型必须是Comparable的子类。否则编译失败。


    }
public static <T extends Comparable<? super T>> T getMax(Collection<? extends T> c,Comparator<? super T> comp)
{
    if(comp == null)
    {
        return getMax(c);
    }

    Iterator<? extends T> it = c.iterator();

    T max = it.next();
    while(it.hasNext())
    {
        T temp = it.next();
        if(comp.compare(temp,max)>0)
        {
            max = temp;
        }
    }
    return max;
}

//升级版。要操作的元素的类型确定不？不确定，使用泛型限定。getMax方法接收的集合中的元素无论是什么类型，必须具备自然排序，必须是Compareble的子类。
public static <T extends Comparable<? super T>> T getMax(Collection<? extends T> c)
{
    Iterator<? extends T> it = c.iterator();
		
		T max = it.next();
		
		while(it.hasNext()){
			
			T temp = it.next();
			
			if(temp.compareTo(max)>0){
				max = temp;
			}
		}
		
		return max;
	}

    /*
	//不加泛型时，无法明确集合中的元素时什么类型，为了便于操作用Object
	public static Object getMax(Collection c1) {

		// 1,定义变量，记录集合中任意一个元素，Collection集合取出元素的方式只有迭代器。
		Iterator it = c1.iterator();
		Object max = it.next();

		// 2,遍历容器。
		while (it.hasNext()) {
			Object o = it.next();
			Comparable temp = (Comparable)o;
			
			if (temp.compareTo(max) > 0) {
				max = temp;
			}
		}
		return max;
	}
*/
	/*
	 * //这个功能虽然实现，但是有局限性，因为这个功能只能对存储了Student对象的集合进行最大值的获取。 public static Student
	 * getMax(Collection<Student> c1) {
	 * 
	 * //1,定义变量，记录集合中任意一个元素，Collection集合取出元素的方式只有迭代器。 Iterator<Student> it =
	 * c1.iterator(); Student max = it.next();
	 * 
	 * //2,遍历容器。 while(it.hasNext()){ Student temp = it.next();
	 * 
	 * if(temp.compareTo(max) > 0){ max = temp; } } return max; }
	 */

}
class Dog{}


//4月12日 复习


class GenericTest2 {
    public static void main(String[] args)
{
	/*
案例：获取集合中元素的最大值。

思路：1.定义变量记录每次比较后较大的值，初始化元素中任意一个。
2.遍历容器
3.在遍历中和变量中记录的元素进行比较，并将较大的值记录到变量中。
4.遍历结束，变量中记录的就是最大值。
*/

Collection<Student> c1 = new ArrayList<Student>();
        c1.add(new Student("xioaming1",30));
        c1.add(new Student("xiaoming1", 30));
		c1.add(new Student("xiaoming2", 36));
		c1.add(new Student("xiaoming3", 22));
//      c1.add(new Dog());

        Student stu = getMax(c1);
        System.out.println(stu);

       Collection<String> c2 = new ArrayList<String>();
		c2.add("abcd");
		c2.add("java");
		c2.add("z");
		c2.add("nba");
        String s = getMax(c2);
        System.out.println("s="+s);

        Collection<Dog> c3 = new ArrayList<Dog>();
//      getMax(c3);//已经做了限定，说明传递的集合中的元素类型必须是Comparable的子类。否则编译失败。

}
public static <T extends Comparable<? super T>> T getMax(Collection<?extends T> c,Comparator<? super T> comp)
{
	if(comp == null)
	{
		return getMax(c);
	}
	Iterator<? extends T> it = c.iterator();

	T max = it.next();
	while(it.hasNext())
	{
		T temp = it.next();
		if(comp.compare(temp,max)>0)
		{
			max = temp;
		}
	}
	return max;
}

//升级版。要操作的元素的类型确定不？不确定，使用泛型限定。getMax方法接收的集合中的元素无论是什么类型，必须具备自然排序，必须是Compareble的子类。
public static <T extends Comparable<? super T>> T getMax(Collection<? extends T> c)
{
	Iterator<? extends T> it = c.iterator();

	T max = it.next();

	while(it.hasNext()){
		T temp = it.next();
		
		if(temp.compareTo(max)>0){
			max = temp;
		}
	}
	return max;
}
}

/*
	 * //这个功能虽然实现，但是有局限性，因为这个功能只能对存储了Student对象的集合进行最大值的获取。 public static Student
	 * getMax(Collection<Student> c1) {
	 * 
	 * //1,定义变量，记录集合中任意一个元素，Collection集合取出元素的方式只有迭代器。 Iterator<Student> it =
	 * c1.iterator(); Student max = it.next();
	 * 
	 * //2,遍历容器。 while(it.hasNext()){ Student temp = it.next();
	 * 
	 * if(temp.compareTo(max) > 0){ max = temp; } } return max; }
	 */




/**
 * 
 * 问;extends Comparable<? super T>为啥要继承comparable？还有这个Collection<? extends T> c,Comparator<? super T> comp)
{为啥要实现compartor?

答：T extends Comparable<? super T>：保证无比较器时可用自然顺序。

Collection<? extends T>：允许传入子类型集合，灵活且安全。

Comparator<? super T>：允许传入父类型比较器，增强通用性。


问：Comparable实现什么功能？

答：Comparable 赋予对象可比较的能力，使其具有默认的排序顺序。


问：你的意思是：Comparable 接口要看传进来的是什么类，才会使用对应的自然排序，对吗？比如说传入string就是按字典序，对吗？

答：自然排序 = 类自带的、默认的排序方式。Comparable 接口的 compareTo 方法的具体实现取决于实现该接口的类。不同的类会根据自己的内部数据定义不同的自然排序规则：

String 类：按字典序（基于字符的 Unicode 值）比较。

Integer 类：按数值大小升序比较。

Date 类：按时间先后比较。

因此，当你使用 Collections.sort(list) 或 TreeSet 时，Java 会自动调用元素类自带的 compareTo 方法，从而采用该类的自然排序。如果元素类没有实现 Comparable，则无法直接使用这些方法，需要提供 Comparator
 */








 