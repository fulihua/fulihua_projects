package day03;
public class WhileTest_day03 
{
  public static void main(String[] args)
  {
    /*
    while语句练习：
    需求1：显示1-10.

    int x = 1;
    while(x<11)
    {
      System.out.println(x);
      x++;   
    }
    */

    /*
    需求2；运算1-10的和。
    思路：
    1+2+3+4……
     3+3
       6+4
    每次重复的都是和+下一个数。
    和是确定的吗？不确定。需要变量。
    下一个数是确定的吗？不确定，需要变量。
    和+下一个数在重复，说明需要执行多次，用循环。
    下一个数，是有规律的。自增。
    
    步骤：
    1.定义变量。一个记录和，一个记录下一个数。
    2.需要循环结构。
    3.循环中需要进行和+下一个数的运算。并让下一个数自增。
    */
   //1.定义变量。一个记录和，一个记录下一个数。
   int i=1;
   int sum=0;
   //2.需要循环结构。
   while(i<=10)
   {
    //3.循环中需要进行+下一个数的运算。并让下一个数自增。
    sum=sum+i;
    i++;
   }
   System.out.println("sum="+sum);





  }  
}
