package day20;

public class GenericDemo8 {
    /*
    泛型的限定在api中的使用。上下限的体现。


场景	                        代码示例	                       角色	        通配符
从集合中取出元素放入另一个集合	addAll(Collection<? extends E> src)	src 是生产者	? extends E
把元素放入一个集合	copy(List<? super T> dest, ...)	                dest 是消费者   ? super T
比较器（比较两个元素）	TreeSet(Comparator<? super E> comp)	        comp 是消费者	  ? super E
遍历集合并打印	printAll(Collection<?> coll)	        coll 是生产者（只读）	      ? 或 ? extends Object





总结：
生产者（提供数据）用 extends，消费者（接收数据）用 super。

PECS 一句话速记法
extends → 读（Read）→ 生产者 → ? extends T

super → 写（Write）→ 消费者 → ? super T

PECS 原则：

如果你需要从参数中获取数据（生产者），就用 ? extends T。

如果你需要向参数中提供数据（消费者），就用 ? super T。



问：所以，你的意思是要看? extends或者? super后面那个集合是提供数据的，还是消费数据的吗？
如果是提供数据的就是? extends，若是消费数据的，就是? super，对吗？

答：完全正确！！！
看 ? extends 或 ? super 后面那个集合（或参数）的角色：

如果它是提供数据的（生产者）→ 用 ? extends T

如果它是消费数据的（消费者）→ 用 ? super T
    */
}
