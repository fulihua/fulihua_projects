package day20;

public class GenericDemo4 {
    public static void main(String[] args)
    {
        new InterImpl<String>().show("hehe");
    }
}


interface Inter<E>
{
    void show(E e);
}

/*
class InterImpl implements Iner<String>{
    public void show(String e){}
}
*/
//当我也不知道要传什么类型的参数时，这样写：
class InterImpl<T> implements Inter<T>{
    public void show(T e){

    }
}


//4月12日 复习

public class GenericDemo4{
    public static void main(String[] args)
    {
        new InterImpl<String>().show("hehe");
    }
}
interface Inter<E>
{
    void show(E e);
}

/*
class InterImpl implements Inter<String>
//普通类 InterImpl 实现了泛型接口 Inter，并传入了具体类型 String。

{
    public void show(String e){}
}
*/
//当我也不知道传什么类型的参数时，这样写：
/*
class InterImpl<T> implements Inter<T>{
    public void show(T e){
    }
}
*/



/**
 * 
 * 1.总结：
 * 
 * 系统梳理一下 Java 中泛型的不同使用场景，包括泛型类、泛型接口、泛型方法，以及类型通配符。
 * 
 * 
 * 
 * 
 * 
 * 一、泛型类（Generic Class）
格式
java
class 类名<T> {
    private T 成员变量;
    public T 方法名(T 参数) { ... }
}
作用
在定义类时，声明一个或多个类型参数（如 <T>），类内部的成员变量、方法参数、返回值都可以使用这个类型参数。

当创建对象时，需要指定具体的类型（如 InterImpl<String>），此时类内部所有用到 T 的地方都会被替换为 String。


二、泛型接口（Generic Interface）
格式
java
interface 接口名<T> {
    void 方法名(T t);
}
作用
类似于泛型类，在定义接口时声明类型参数，实现类需要指定具体类型或继续保留泛型。


三、泛型方法（Generic Method）
格式
java
public <Q> void show(Q q) { ... }
注意：<Q> 必须放在返回值之前（void 之前）。

作用
在方法级别声明自己的类型参数，该参数仅在此方法内有效，与类的泛型参数无关（可以不同名，也可以同名但互不影响）。

调用方法时，根据传入的参数实际类型自动推断 Q 的具体类型。



四、类型通配符（Type Wildcard）
格式
无界通配符：?

上界通配符：? extends T

下界通配符：? super T

作用
用在使用泛型的地方（如方法参数、变量声明），表示未知类型，用于增强灵活性。

例如：public void printList(List<?> list) 可以接受任何类型的 List





五、总结表格
种类	    声明位置	示例	                作用
泛型类	    类名后	   class Box<T>	        定义类时使用类型参数，整个类共享
泛型接口	接口名后	interface List<T>	 定义接口时使用类型参数
泛型方法	方法返回值前  public <Q> void show(Q q)	方法独立使用类型参数，与类无关
通配符	    变量/参数类型中	 List<?>	        表示未知类型，用于灵活接收


六、容易混淆的点
类上的 <T> 和 方法上的 <Q> 可以同名，但建议不同名以避免误解。例如：

java
class Util<T> {
    public <T> void print(T t) { } // 这里的 T 覆盖了类的 T，不推荐
}
泛型方法不一定非要在泛型类中，普通类也可以定义泛型方法。

通配符 ? 不能用于定义类或接口，只能用于使用场景。





2.问：泛型类和泛型接口有什么区别？

答：对比项	 泛型类	                                    泛型接口
定义	    class ClassName<T> { ... }	            interface InterfaceName<T> { ... }
能否实例化	可以创建对象（new ClassName<String>()）	    不能直接实例化，需要由类实现
目的	    描述一类具有相同行为但可操作不同数据类型的对象	定义一组方法，这些方法可以使用类型参数，由实现类提供具体逻辑
实现/继承	可以继承其他泛型类或实现泛型接口	          可以被泛型类或非泛型类实现
类型参数的使用	可用于成员变量、方法参数、返回值、局部变量等	只能用于抽象方法、默认方法、静态方法（静态方法中有限制）
常见例子	ArrayList<T>, HashMap<K,V>	                List<T>, Comparable<T>, Comparator<T>



核心总结
泛型类：侧重于数据结构的封装，持有一个或多个类型参数，用于操作内部数据。

泛型接口：侧重于定义一组通用操作，由不同的实现类来具体化类型参数，实现多态。

两者可以结合使用：一个泛型类可以实现一个泛型接口，此时类型参数可以保持一致或更具体。
 */