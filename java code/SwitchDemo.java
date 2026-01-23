public class SwitchDemo {
    public static void main(String[] args)
    {
        /*
        switch(表达式)
        {
        case 取值1:
            执行语句：
            break;
        case 取值2:
            执行语句：
            break；
        ……
        default：
            执行语句：
            break；
    
        }
        */


        int x=5;
        /*
        switch语句特点：
        1.答案的书写没有顺序。
        2.匹配的答案被执行，一直执行到break结束或者执行到switch语句结束。
        */
       switch(x){
        case 5:
            System.out.println("a");
            //break;
        default:
            System.out.println("c");
            //break;
        case 3:
            System.out.println("b");
            //break;
       }
       System.out.println("Hello World");
    }
}
