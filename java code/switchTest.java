public class switchTest {
   public static void main(String[] args)
   {
    //需求1：根据用户的给定的数值，显示该数值对应的星期。如：2，星期二。
    int week=9;
    switch(week)
    {
        case 1:
            System.out.println(week+"对应的是星期一");
            break;
        case 2:
            System.out.println(week+"对应的是星期二");
            break;
        case 3:
            System.out.println(week+"对应的是星期三");
            break;
        case 4:
            System.out.println(week+"对应的是星期四");
            break;
        case 5:
            System.out.println(week+"对应的是星期五");
            break;
        case 6:
            System.out.println(week+"对应的是星期六");
            break;
        case 7:
            System.out.println(week+"对应的是星期七");
            break;
        default:
            System.out.println(week+"没有对应的星期");
            break;
    }
    System.out.println("Hello World!");
    /*
    swtich和If的区别？
     
    If可以用于判断数值，也可以判断区间，
    只要运算结果为Boolean类型，都可以进行判断。

    Switch用于对固定的几个值，进行判断。判断的值的类型有限。
    */



   } 
}
