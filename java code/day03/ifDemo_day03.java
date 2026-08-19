package day03;

public class ifDemo_day03 {
    public static void main(String[] args)
    {
        //1.if格式一。
        int x=1;
        if(x>1)
        {
            System.out.println("yes");

        }
        System.out.println("over");

        //2,if格式二：
        /*
        if(条件表达式)
        {
            执行语句；
        }
        else//否则。
        {
            执行语句；
        }
        */
        int b = 1,c;
		if(b>1)
		{
			c = 100;
		}
		else
		{
			c = 200;
		}
        //和三元运算符很像。  理解为三元运算符是If else的简写格式。
        //区别？不是所有的if else 都能简化的。为什么呢》因为三元运算符运算完必须有结果！

        /*
        格式三：
        if(条件表达式)
        {
            执行语句；
        }
        else if(条件表达式)
        {
            执行语句：
        }
            ……
        else
        {
            执行语句：    
        }

        */


        
		int i = 3;

		if(i > 1){
			System.out.println("a");
		}
		else if(i > 2)
		{
			System.out.println("b");
		}
		else if(i > 3)
		{
			System.out.println("c");
		}
		else
		{
			System.out.println("d");
		}
    }
}
