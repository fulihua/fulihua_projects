package day03;

public class ForDemo_day03 {
    {

		/*
		for(初始化表达式；循环条件表达式；循环后的操作表达式)
		{
			执行语句；(循环体)
		}

		*/
		for(int x = 1; x<3; x++)
		{
			System.out.println("x="+x);
		}
		//System.out.println("x......"+x);

		//和while的区别。
		int y = 1;
		while(y<3)
		{
			System.out.println("y="+y);
			y++;
		}
		System.out.println("y....."+y);


		//最简单的无限循环，
		//while(true){}   for(; ;){}

		
	}
}

