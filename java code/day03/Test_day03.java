package day03;
public class Test_day03 {
    public static void main(String[] args)
    {
        /*
        需求2：根据用户给定月份数据，显示该月份在哪个季节。
        3,4,5 春季
        6,7,8 夏季
        9,10,11 秋季
        12,1,2 冬季
        思路：
        1.咋获取数据呢？关我什么事，我只要关注变量。
        2.对这个数据进行判断。




        步骤：
            1.定义变量
            2.定义If语句判断
            填代码：
            if(x==3||x==4|x==5)
            System.out.println(x+"是春天")；
            else if(x==6||x==7||x==8)
            System.out.println(x+"是夏天")；
            else if(x==9||x==10||x==11)
            System.out.println(x+"是秋天")；
            else if(x==12||x==1||x==2)
            System.out.println(x+"是冬天")；
            esle
            System.out.println(x+"没有对应的季节")；


            if(x>12||x<1)
                System.out.println(x+"没有对应的季节")；
            else if(x>=3&&x<=5)
                System.out.println(x+"是春天")；
            else if(x>=6&&x<=8)
                System.out.println(x+"是夏天")；
            else if(x>=9&&x<=11)
                System.out.println(x+"是秋天")；
            else 
                System.out.pirntln(x+"是冬天")；
        */
    


        /*
        //需求3：对给定的整数26，获取其十六进制的表现形式。
        思路：
        1.啥是十六进制，数据的一种表现形式，好处在于可以使表现形式更短。
            原理：将二进制中4位为一个十六进制位；
        2.原理就是对给定的整数进行二进制的每4位获取。
        3.咋获取每4位呢？其实就是获取四位中的1，可以通过&位运算的方式完成。
        4.而且想要获取下四位，可以通过对原数据进行无符号右移的方式。


        步骤：
        1、定义变量记录该整数。
        2.对该变量进行位运算，既然是获取四位。就&四个1，二进制四个1就是十进制的15.
        3.对原数据进行无符号右移四位。
        */

        int num=26;
        //&15.获取最低四位。
        int n1=num&15;//等等，它也没有先将26转换为二进制啊？解释：计算机在内存中存储和处理的所有数字，本身就是二进制形式。
        System.out.println("n1="+(char)(n1-10+'a'));//等等，这一行代码是什么意思？解释：如果提取出的数字 
                // n1 小于10， 它本身就是十六进制数字（0-9）；如果 n1 在10到15之间，就需要被映射为字母（a-f）
        //对num进行右移
        num=num>>>4;
        //在进行&15
        int n2=num&15;
        System.out.println("n2="+n2);



        /*
        //需求4：三个数，想知道最大的是哪个？
        int a=3,b=4,c=5;
        int tempMax=a>b?a:b;
        int max=tempMax>c?tempMax:c;

        */

        /*
        需求：根据用户的给定月份数据，显示该月份在哪个季节。
        3,4,5 春季
        6,7,8 夏季
        9,10,11 秋季
        12,1,2 冬季
        用Switch完成。

        switch(x)
        {
            case 3:
            case 4:
            case 5:
                System.out.println(x+"是春天"):
                break;
            case 6:
            case 7:
            case 8:
                System.out.println(x+"是夏天");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println(x+"是秋天");
                break;
            case 12:
            case 1:
            case 2:
                System.out.println(x+"是冬天”);
                break；
            default:
                System.out.pirntln(x+"没有对应的季节")；
                break;
        }

        */


        /* 
        需求：要求在屏幕上显示下列内容。
        大圈套小圈的思想，for嵌套循环。
        54321
        5432
        543
        54
        5
        */
        System.out.println("--------------------------");
        for(int x=1;x<=5;x++)
        {
            for(int y=5;y>=x;y--)
            {
                System.out.print(y);
            }
            System.out.println();
        }



/*
//九九乘法表
1*1=1 
		1*2=2 2*2=4
		1*3=3 2*3=6 3*3=9
*/
 System.out.println("---------------------");
 for(int x=1;x<=9;x++)
 {
    for(int y=1;y<=x;y++)
    {
        System.out.print(y+"*"+x+"="+y*x+"\t");// \t :制表符   \n
    }
    System.out.println();



 }
}
}