package day21;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {
    public static void main(String[] args)
    {
        Map<String,String> map = new HashMap<String,String>();

        map.put("星期一","Monday");
        map.put("星期日","Sunday");

        System.out.println("------keySet方法的获取------");
//      System.out.println(map.get("星期一"));
//      怎么获取到所有的键呢？应该是set，因为map集合中键需要0保证唯一性。
//      找到一个方法  Set<k>  keySet();获取map集合中的键的set集合。
        Set<String> keySet = map.keySet();
        for(Iterator<String> it=keySet.iterator();it.hasNext();)
        {
            String key = it.next();
            String value = map.get(key);//通过键获取对应的值。
            System.out.println(key+"::"+value);
        }
        //使用foreach循环，进行遍历。
        for(String key:keySet){
            System.out.println(key+"::::::"+map.get(key));
        }

        System.out.println("------entrySet方法获取------");

        /*
        Set entrySet():将map集合中映射关系存储到了Set集合中。
        映射关系：其实就是指键和值的对应关系。其实就是夫妻的结婚证。
        映射关系是什么类型的呢？Map,Entry
        */

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        //遍历Set中的映射关系对象。
        while(it.hasNext()){
            Map.Entry<String,String> me = it.next();//取到了映射关系对象。
            //获取键。
            String key = me.getKey();
            //获取值。
            String value = me.getValue();
            System.out.println(key+"------"+value);
        }
        /*
            总结：map集合没有迭代器，取出元素的方式：将map集合转成单列集合，再使用单列集合的迭代器就可以了。
            map集合也不能直接被foreach循环遍历。

        */
       for(Map.Entry<String,String> me:map.entrySet()){
        String key = me.getKey();
        //获取值。
        String key = me.getValue();
        System.out.println(key+"-----"+value);
       }

       System.out.println("------获取所有值的方法 values()------");
       /*
       获取所有的值，因为值不需要保证唯一性。所以返回类型是Collecton.
       姓名--归属地，对应关系，获取所有的归属地。values();
       */
      //所有的英文星期。
      Collection<String> values =  map.values();
      for(String value:values){
        System.out.println("value:"+value);
      }

    }
}



/*
1.问： for (Iterator<String> it= keySet.iterator(); it.hasNext() ;){
String key = it.next();
string value = map.get(key);
这里进行了迭代器的迭代，那不应该每次迭代都要用keySet();方法吗？为什么迭代时没有写呢？


答：Set<String> keySet = map.keySet();这行代码一次性地获取了 map 中所有键的集合，存储在 keySet 变量中。
这个 keySet 是一个 Set 对象，它包含了当前所有键的引用。
当你创建迭代器时：
Iterator<String> it = keySet.iterator();
是基于 keySet 这个具体的集合对象来创建迭代器的。迭代器的作用就是遍历这个集合中的元素，所以不需要在循环内再调用 keySet()。
如果每次迭代都调用 map.keySet()，那会重复创建新的 Set 对象（尽管内容可能相同），浪费内存和性能，而且你还需要重新获取迭代器。

正确做法：只调用一次 keySet()，然后用同一个集合对象进行遍历。


2.问： foreach 循环怎么用？
答：foreach 循环（增强 for 循环）的语法是：

for (元素类型 变量名 : 数组或集合) {
    // 循环体
}
其中：括号里面的 数组或集合指的是：需要在哪个集合或者数组中进行迭代，我就写哪个数组或集合。

括号里的元素类型 变量名 是指：我需要迭代的集合或者数组中的元素类型和变量名。


在 for (元素类型 变量名 : 数组或集合) 中：

元素类型：指的是数组或集合中存储的元素的类型（例如 String、Integer、自定义类等）。

变量名：是你自己定义的变量名，在每次循环中，这个变量会被赋值为当前遍历到的元素。

foreach 循环的右边就是要遍历的那个数组或集合对象。你想遍历哪个数组或集合，就把那个数组或集合的变量名（或直接返回它的方法调用）写在 : 的右边。


3.问：
不是说map集合里面没有迭代器吗?那为什么还可以用foreach方法？还说：将map集合转成单列集合再使用单列集合的迭代器就可以。
这句话有什么意思啊？

答：1. 为什么 Map 本身不能用 foreach？
Map 接口没有继承 Iterable，所以不能直接使用 foreach 循环（foreach 只适用于数组或实现了 Iterable 的类）。
因此，for(Map.Entry<String, String> me : map) 这样的写法是错误的，编译器会报错。

2. 那为什么你的代码中写了 for(Map.Entry<String, String> me : map.entrySet()) 却能运行？
因为 map.entrySet() 返回的是 Set<Map.Entry<K,V>>，而 Set 接口继承了 Collection，Collection 又继承了 Iterable。
所以 entrySet() 返回的集合可以使用 foreach 循环（foreach 底层正是通过迭代器实现的）。

同理，map.keySet() 返回 Set<K>，map.values() 返回 Collection<V>，它们也都可以使用 foreach。

3.将 map 集合转成单列集合再使用单列集合的迭代器”是什么意思？
这句话的意思就是：

单列集合 = Set 或 Collection（比如 keySet()、entrySet() 返回的集合）。

这些单列集合本身有迭代器（因为继承自 Iterable），所以你可以通过它们来遍历 Map 中的键、值或键值对。

具体做法：先调用 map.keySet() 或 map.entrySet() 获得一个 Set，然后对这个 Set 使用迭代器（或者 foreach，它本质上也是迭代器）。

所以，“Map 没有迭代器”指的是 Map 接口本身不提供 iterator() 方法，但我们可以通过它提供的视图集合（keySet、entrySet 等）来间接获得迭代器，从而遍历 Map 中的数据。


4.问：那用这个方法System.out.println(map.get("星期一"));和用keyset方法获取有什么区别呢？

答：map.get("星期一") 和 keySet 方法的作用完全不同：

map.get("星期一")：直接通过指定的键（例如 "星期一"）获取对应的值。如果你知道确切的键，想快速得到它的值，就用这个方法。它返回的是值，而不是集合。

keySet 方法：返回 Map 中所有键的集合（Set<K>）。它本身不获取值，而是给你一个可以遍历的集合，让你能够迭代所有键，然后通过 map.get(key) 逐个获取对应的值。这通常用于你不知道具体有哪些键，或者需要处理所有键值对的情况。

简单区别：

直接 get(键)：定向查找，一次只拿一个值。

keySet()：获取所有键的集合，用于遍历全部。


5.问：用迭代器迭代时，不需要在 Iterator 声明外面再加一层花括号？

答：

在循环体中执行 it.next()，这才是真正的一次迭代，取出一个元素。

1. Iterator<...> it = entrySet.iterator();
这行代码是创建迭代器对象 it，并让它指向集合 entrySet 的第一个元素之前的位置（可以理解为一个“光标”在第一个元素的前面）。

这个操作只做一次，并不进行任何迭代，也不移动光标。
2. while(it.hasNext())
每次循环开始时，检查 it.hasNext() 是否为 true（即光标后面还有元素吗？）。

如果为 true，则进入循环体；如果为 false，则退出循环。
3. Map.Entry<...> me = it.next();
这行代码做了两件事：

将光标向后移动一个位置，指向下一个元素。
返回该元素（赋值给 me）。
这才是真正的一次迭代。

总结
it = entrySet.iterator()：只执行一次，创建迭代器。

while(it.hasNext())：每次循环开始时执行，判断是否还有元素。

it.next()：每次循环内部执行一次，取出一个元素并移动光标。

不是“while执行一次也迭代一次”，而是 while 循环每执行一轮，就会在循环体内调用一次 it.next() 进行一次迭代。

*/