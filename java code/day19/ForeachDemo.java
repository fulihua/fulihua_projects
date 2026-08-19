package day19;
import java.util.ArrayList;
import java.util.List;

public class ForeachDemo {
    public static void main(String[] args)
    {
        /*
        foreach:其实就是增强for循环。
        格式：
        for（元素的数据类型 变量：collection集合or数组）{}
        用于遍历collection和数组，通常只能遍历元素，不要在遍历的过程中做对集合元素的操作。

        和老式的for循环有什么区别？
        注意：新for循环必须有被遍历的目标，目标只能是collection或者是数组。
        建议：遍历数组时，如果仅为遍历，可以使用增强for如果要对数组的元素进行操作，使用老式for循环可以通过角标操作。

        */
       List list = new ArrayList<>();
       list.add("itcast1");
       list.add("itcast2");
       list.add("itcast3");
       list.add("itcast4");

//      for(Iterator it = list.iterator();it.hasNext();)
//          {Object obj = it.next();
//          System.out.println(obj);
//          }
        for(Object obj:list){//简化。
            System.out.println(obj);
        }
    }
}
