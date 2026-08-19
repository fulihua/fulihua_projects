import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.itcast.domain.Person;
import cn.itcast.domain.Student;
import cn.itcast.domain.Worker;

public class GenericDemo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Student> list = new HashSet<Student>();
		
		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi3",23));
		
		printList(list);
		
		List<Worker> list2 = new ArrayList<Worker>();
		
		list2.add(new Worker("lisi11",21));
		list2.add(new Worker("lisi22",22));
		list2.add(new Worker("lisi33",23));
		
		printList(list2);

		
	}
    /*
    打印集合中的元素：
    当使用泛型类或者接口时，传递的具体的类型不确定，可以通配符(?)来表示。
    如果想要对被打印的集合中的元素类型进行限制，只在指定的一些类型，进行打印。
    使用泛型的限定。

    只需要打印学生和工人的集合，找的学生和工人的共性类型Person.
    ? extends Person:接收Person类型或者Person的子类型。

    总结：
    ? super E:接收E类型或者E的父类型。下限。
    ? extends E:接收E类型或者E的子类型。上限。

    */
   private static void printList(Collection<? ectends Person>list2)
   {
    for(Iterator<? extends Person> it = list2.iterator();it.hasNext();)
    {
        Person p = it.next();
        System.out.println(p.getName());
    }
   }
}
//4月12日

/*
打印集合中的元素：
当使用泛型类或者接口时，传递的具体的类型不确定，可以通配符(?)来表示。
如果想要对被打印的集合中的元素类型进行限制，只在指定的一些类型，进行打印。
使用泛型的限定。

只需要打印学生和工人的集合，找到学生和工人的共性类型Person
? extends Person:接收Person类型或者Person的子类型。

总结：
? super E:接收E类型或者E的付类型。下限。
？ extends E:接收E类型或者E的子类型。上限。

*/
private static void printList(Collection<? ectends Person>list2)
{
    for(Iterator<? extends Person> it = list2.iterator();it.hasNext();)
    {
        Person p = it.next();
        System.out.println(p.getName());
    }
}