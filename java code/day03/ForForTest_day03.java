package day03;

public class ForForTest_day03 {
    public static void main(String[] args)
    {
        /*
		需求：在屏幕上显示以下图形。
		*****
		****
		***
		**
		*
		思路：
		1，看起图形，发现是由5行的组成。
		2，每一行都有多个星。
		3，有点意思，多行，循环就可以搞定。每到一行，里面有多个星。
		循环内，还需要循环负责每一行的星的个数。
		4，外循环控制行数，内循环控制每一个行的个数。
        */

        /*
        步骤：
        1.for循环的嵌套。
        int z=5;
        for(int x=1;x<=5;x++)
        {
            for(int y=1;y<=z;y++)
            {
                System.out.println("*");
            }
            z--;
            System.out.println();
        }
        */

        for(int x=1;x<=5;x++)
        {
            for(int y=x;y<=5;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-----------------------");

        /*
		
		*
		**
		***
		****
		*****
		
		*/

        for(int x=1;x<=5;x++)
        {
            for(int y=1;y<=x;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }


        /*
		需求：要求在屏幕上显示下列内容。
		54321
		5432
		543
		54
		5


		1*1=1 
		1*2=2 2*2=4
		1*3=3 2*3=6 3*3=9


		*/

    }
}
