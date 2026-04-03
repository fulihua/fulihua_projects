package day19;
import java.util.Comparator;
import java.util.TreeMap;


public class ComparatorByName extends Object implements Comparator
//这是定义一个名为 ComparatorByName 的类，同时声明了它的父类和实现的接口
 {
    public int compare(Object o1,Object o2)
    {
        //1.因为要比较的是学生对象的姓名。所以向下转型成Student对象。
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        //先比较姓名。
        int temp = s1.getName().compareTo(s2.getName());
        //String 类中有一个 compareTo(String anotherString) 方法，用于按字典顺序比较两个字符串。
        //如果姓名相同，再比较年龄。
        return temp == 0? s1.getAge()-s2.getAge():temp;
    }
}