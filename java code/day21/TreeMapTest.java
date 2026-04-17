package day21;

import java.util.Map;
import java.util.TreeMap;

import day18.Student;
import day19.ComparatorByName;
import day21.*;

public class TreeMapTest {
    public static void main(String[] args)
    {
        /*
        练习二：学生对象（姓名，年龄）都有自己的归属地，既然有对应关系。将学生对象和归属地存储到map集合中。
        注意：同姓名同年龄视为重复的键。按照学生的年龄进行从小到大的排序。TreeMap.
        
        如果要对学生按照姓名排序呢？
        */
       //1.创建TreeMap集合对象。
       Map<Student,String> map = new TreeMap<Student,String>(new ComparatorByName());
      // 2,添加元素。
		map.put(new Student("lisi", 28), "上海");
		map.put(new Student("wangwu", 22), "北京");
		map.put(new Student("zhaoliu", 24), "成都");
		map.put(new Student("zhouqi", 25), "广州");
		map.put(new Student("wangwu", 22), "南京");

        //3.取出所有的元素 entrySet()
        for(Map.Entry<Student,String> me:map.entrySet()){
            Student key = me.getKey();
            String value = me.getValue();

            System.out.println(key+"::"+value);
        }
    }
}


/*
在 Map.Entry<Student, String> 中，getKey() 和 getValue() 的区别很简单：

getKey()：获取当前键值对中的键（这里是 Student 对象）。

getValue()：获取当前键值对中的值（这里是 String 对象）。

两者的类型不同，含义不同。一个代表映射的“索引”，一个代表“数据”。在遍历 Map 时，需要分别取出键和值进行后续操作。
*/