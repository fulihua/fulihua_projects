package day02;
public class OperateDemo3 
{
    public static void main(String[] args)
    {
        /*
        比较运算符。运算完的结果要么true，要么false。

        */
       System.out.println(3!=4);
       /*
       逻辑运算符。用来连接boo lean型表达式的。
       &:与
       |:或
       ^:异或
       !:非

       &&:短路与 || 短路或
       */
      int x =7;
      //x>2 & x<5
      //x<2 | x>5
      /*
      &:两边都为true，结果是true。否则为false。
        两边只要有一个为false。结果必然是false。

      */
      true & true = true;
      true & false = false;
      false & true = false;
      false & false = false;

      /*
      |: 两边都为false，结果为false。否则为true。
         两边只要有一个true，结果必然为true。

      */
     true | true = true;
     true | false = true;
     false | true = true;
     false | false = false;
     /*
     ^:异或
       两边相同为false。两边不同为true；

     */
    true ^ true = false;
    true ^ false = true;
    false ^ true = true;
    false ^ false = false;

    !ture = false;

    int y = 1;
    y>3 & y<6
    y>3 && y<6

    /*
    &和&&的区别：
    &：两边都参与运算。
    &&：当左边为false，右边不参与运算。

    |和||的区别：
    |：两边都参与运算。
    ||：当左边为true，右边不参与运算。
    */




    }    
}
