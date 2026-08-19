package day20;

public class GenericDemo3 {
    public static void main(String[] args)
    {
        Util<String> util = new Util<String>();
        util.show("hehe");
//      util.print(5);
        Util<Integer> util2 = new Util<Integer>();
        Util.print(5);
        util2.show("hehe");
    }
}

class Util<W>
{
    //当方法要操作的类型不确定和类上的泛型不一定一样。这时可以将泛型定义在方法上。
    public <Q> void show(Q q){
        //泛型方法
        System.out.println("show:"+q);
    }
    public static<E> void print(E e)
    {
        //记住：如果方法是静态，还需要使用泛型，那么泛型必须定义在方法上。
        System.out.println("print:"+e);
    }
    public void method(W w)
    {

    }
}


/*
问：//记住：如果方法是静态，还需要使用泛型，那么泛型必须定义在方法上。这句话是什么意思？
答：
这句话的意思是：在 Java 中，静态方法 属于类本身，而不是某个具体的对象。如果静态方法要使用泛型，它不能依赖类上声明的泛型参数（因为类上的泛型参数是在创建对象时才确定的），而必须在方法声明上独立定义自己的泛型参数，格式如下：

java
public static <T> void method(T t) {
    // 静态方法中的泛型 T 是独立于类的
}
这里的 <T> 必须紧跟在 static 之后、返回值之前，表示这个静态方法拥有自己的泛型类型，与类是否泛型无关。这就是“泛型必须定义在方法上”的含义。


总结：结论：静态方法上定义泛型后，它就是一个泛型方法。这与你之前的理解一致。

*/


//4月12日 复习
/**
 class Util<W>
 {
    //当方法要要操作的类型不确定和类上的泛型不一定一样。这时可以将泛型定义在方法上。
    public <Q> void show(Q q)
    //泛型方法
    {
        System.out.println("show:"+q);
    }
    public static<E> void print(E e)
    {
        //记住：如果方法是静态，还需要使用泛型，那么泛型必须定义在方法上。
        System.out.println("print:"+e);
    }
    public void method(W w){}
 }
 */

 /*
 问：//当方法要操作的类型不确定和类上的泛型不一定一样。这时可以将泛型定义在方法上。这句话是什么意思？

 答：这句话的意思是：当你在一个泛型类（如 Util<W>）中定义方法时，如果这个方法需要操作的参数类型（或返回值类型）与类上声明的泛型 W 没有必然关系，
 或者你想让这个方法能够独立地接受任意类型（甚至与 W 不同），那么你可以在方法上单独声明自己的泛型（如 <Q>），而不是依赖类的泛型 W。

 这样做的好处是：

方法的泛型 Q 是在调用时根据传入参数的实际类型来确定的，与类实例化时指定的 W 无关。

增强了方法的灵活性，使得同一个类的不同方法可以处理不同的类型，彼此互不干扰。

class Util<W> {
    // 类上的泛型 W
    private W value;

    // 方法上的泛型 Q，与 W 无关
    public <Q> void show(Q q) {
        System.out.println("show: " + q);
    }
}

public class Test {
    public static void main(String[] args) {
        Util<String> util = new Util<>();  // W 是 String
        util.show(123);    // Q 是 Integer，与 String 不同，完全可以
        util.show("hello"); // Q 是 String
    }
}

与不使用方法泛型的对比
如果不使用方法泛型，而直接使用类的泛型 W：

java
public void show(W w) { ... }

那么 show 方法只能接受与 W 相同类型的参数，灵活性受限。
 */