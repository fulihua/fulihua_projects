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