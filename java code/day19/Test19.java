package day19;

/*
Collection:
    |--List:有序的，带索引的，通过索引就可以精确的操作集合中的元素，元素是可以重复的。、
            List提供了增删改查动作
            增加add(element) add(index,element);
            删除remove(element) remove(index);
            修改set（index，element）;
            查询get(index);
        |--Vector:可以增长的数组结构。同步的。效率非常低。已被ArrayList替代。
        |--ArrayList:是数组结构，长度是可变的（原理是创建新数组+复制数组），查询速度很快，增删较慢，不同步的。
        |--LinkedList:是链表结构，不同步，增删速度很快，查询速度较慢。
                可用于实现堆栈，队列。
                堆栈：先进后出 First in Last Out FILO 手枪弹夹。
                队列：先进先出 First in First Out FIFO 排队买票
        List可以存储重复元素的，如果需求中要求容器中的元素必须保证唯一性。

    |--Set:不包含重复元素的集合，不保证顺序。而且方法和Collection一致。Set集合取出元素的方式只有一种：迭代器。
        |--HashSet:哈希表结构，不同步，保证元素唯一性的方式依赖于：hasCode(),equals()方法。查询速度快。
        |--TreeSet:可以对Set集合中的元素进行排序，使用的是二叉数结构。如何保证元素唯一性的呢？
                使用的对象比较方法的结果是否为0，是0，视为相同元素不存。
                元素的排序比较有两种方式：
                1.元素自身具备自然排序，其实就是实现了Comparable接口重新compareTo方法。
                如果元素自身不具备自然排序，或者具备的自然排序不是所需要的，这时只能用第二种方式。
                2.比较器排序，其实就是在创建TreeSet集合时，在构造函数中指定具体的比较方式。
                    需要定义一个类实现COmparator接口，重写compare方法。
        到此为止：再往集合中存储对象时，通常该对象都需要覆盖hashCode,equals，
        同时实现Comparable接口,建立对象的自然排序。通常还有一个方法也会复写toString();

看集合对象的小技巧：*****
集合分体系。List Set
子类对象的后缀名是所属体系，前缀名是数据结构名称。
List:新出的子类都是以List结尾的，通常都是非同步的。
    |--ArrayList:看到array，就知道数组，查询速度快。
    |--LinkedList:看到link，就知道链表，增删速度快。
Set:
    |--HashSet:看到hash,就知道哈希表，查询速度更快，并想到元素唯一，通过hashCode(),equals方法保证唯一性。
    |--TreeSet:看到tree，就知道二叉树，可以排序，排序想到Comparable-xompareTo Comparator--compare方法。

---------------------------
课上练习要求必须做：
1，去除List的重复元素。
2，堆栈，队列的LinkedList的实现，★★★★★
3，字符串按照长度排序。
4，对学生按照姓名排序。




作业0：
往HashSet中存储自定义的元素，要求刻意存储重复元素。




作业1：
哈希表(ArrayList)中存储了字符串，
1，获取哈希表中的字符串的字典顺序最大值。
2，获取哈希表中字符串的长度最大值。


作业2：
TreeSet中存储了字符串。要求按照字典顺序，从大到小排序。





				
				
				
				
				
			
		
*/
