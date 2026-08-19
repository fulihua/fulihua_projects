package day20;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class GenericDemo5 {
    public static void main(String[] args)
    {
       Set<Student> list = new HashSet<Student>();
		
		list.add(new Student("lisi1",21));
		list.add(new Student("lisi2",22));
		list.add(new Student("lisi3",23));
		
		printList(list);
		
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("lisi11");
		list2.add("lisi22");
		list2.add("lisi33");
		
		printList(list2);
    }
    /**
     * 打印集合中的元素。
     * 
     * 当使用泛型类或者接口时，传递的具体的类型不确定，可以通过通配符(?)表示。
     * 
     */
    private static void printList(Collection<?> list2)//当用了通配符后，就只能用object方法了！！！
    {
        for(Iterator<?> it = list2.iterator(); it.hasNext();)
        {
            System.out.println(it.next().toString());
        }
    }
}



/*
1.问：list和set有什么区别？
答： List 和 Set 的区别
List（列表）：有序集合，元素可以重复，可以通过索引（位置）访问元素。常见实现：ArrayList、LinkedList、Vector。

Set（集）：无序集合（除 TreeSet 等排序实现外），元素不可重复，基于 equals() 和 hashCode() 判断重复。常见实现：HashSet、LinkedHashSet、TreeSet。

区别总结：

特性	List	Set
顺序	保持插入顺序	通常无序（部分实现有序）
重复	允许重复	不允许重复
索引	支持通过索引访问	无索引（除少数实现）


2.问：通配符和class InterImpl<T> implements Inter<T> 中的 <T> 作用相同吗？
答：
一、<T> 是什么？（定义泛型）
想象你要做一个能装东西的盒子。但你不想规定它只能装什么，想让它灵活一点：今天装苹果，明天装书本。

这时你就在盒子上贴一个标签 <T>，意思是：“这里先空着，等用的时候再决定装什么”。

class Box<T> = “这是一个盒子，能装一种东西，具体装什么以后再说”。

Box<Apple> = “这个盒子装苹果”。

Box<Book> = “这个盒子装书”。

<T> 就是“先占个位，以后填类型”。它用来定义一个泛型类或方法。
二、? 是什么？（使用通配符）
假设你写了一个方法，想接收任何类型的盒子，但你不在乎盒子里装的是什么，只是想把盒子里的东西倒出来看一下。

如果用 <T> 写，方法签名会很长：
ava
public static <T> void look(Box<T> box) { ... }
如果你不关心类型，就可以用通配符 ? 简化：

java
public static void look(Box<?> box) { ... }
? 的意思是：“我不知道里面装的是什么，也不在乎，只要是盒子就行”。它用来使用泛型，而不是定义。


三、什么时候用通配符 ?？
你只关心容器本身，不关心里面元素的类型
例如：打印集合中的所有元素，不需要知道元素具体是什么类型。

方法的参数需要接收多种泛型类型，且不需要向容器中添加元素
例如：public void printList(List<?> list)

配合 extends 和 super 实现更灵活的类型限制

? extends T：能接收 T 及其子类，用于读取（get）。

? super T：能接收 T 及其父类，用于写入（add）。

四、<T> 和 ? 的区别（重点）
特性	<T>（类型参数）	?（通配符）
用途	定义泛型（类、接口、方法）	使用泛型（参数、变量）
能否在代码中作为类型使用	能（如 T obj）	不能（? obj 是错的）
能否有多个	能（<T, U>）	不能（? 只代表一个未知类型）
能否有上界/下界	能（<T extends Number>）	能（? extends Number、? super Integer）
典型场景	声明泛型类、泛型方法	方法参数、返回值、变量类型
简单记忆：

定义时用 <T>：我是谁（占位符）。

使用时用 ?>：我不在乎你是谁（未知类型）。

五、关键区别总结
场景	                使用 <T>	              使用 ?
需要向容器中添加元素	 ✅ 可以（参数 T item）	         ❌ 不可以（只能取，不能放）
只需要从容器中读取元素	  ✅ 可以（但需要声明类型参数）	    ✅ 可以（更简洁）
方法参数类型需保持一致性   ✅ 多个参数间可以约束类型相同    ❌ 无法表达“两个参数类型相同”
定义泛型类或接口	      ✅ 必须用 <T>	               ❌ 不能用 ?


总结：一般情况下通配符是只能接收并读取元素，不能写入（除了 null）。



*/