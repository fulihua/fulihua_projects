package day21;

import java.util.Random;

public class MathDemo {
    public static void main(String[] args){
        /*
        Math数序运算，方法都是静态的。
        Math.PI
        */
       // Math.abs(-4);

       double d1 = Math.ceil(-12.34);//获取参数右边的整数  //11 12 floor 12.34  ceil 13 14 15
       double d2 = Math.floor(12.34);//获取参数左边的整数
       double d3 = Math.round(12.34);//四舍五入。
//      System.out.println("d1="+d1);//13
//		System.out.println("d2="+d2);//12
//		System.out.println("d3="+d3);

//      System.out.prinltn(Math.pow(10.3));

        Random r = new Random();
        for(int x= 0;x<10;x++){
//          int d = (int)(Math.random()*6+1);
//          double d = Math.ceil(Math.random()*6);

            int num = r.nextInt(6)+1;
            System.out.println(num);
        }
    }
}



/*
问：
Random r = new Random();
		for(int x=0; x<10; x++){
//			int d = (int)(Math.random()*6 + 1);
//			double d = Math.ceil(Math.random()*6);这个代码中int d = (int)(Math.random()*6 + 1);
这一行是什么意思？为啥要*6？

答：
int d = (int)(Math.random()*6 + 1); 这行代码用于生成 1 到 6 之间的随机整数。

Math.random() 返回一个 [0.0, 1.0) 的随机浮点数（包含 0，不包含 1）。

乘以 6 后，范围变为 [0.0, 6.0)。

加 1 后，范围变为 [1.0, 7.0)。

强制转换为 int 会舍弃小数部分，所以最终结果可能为 1, 2, 3, 4, 5, 6，每个数字概率大致相等。

因此，*6 是为了将随机数的范围放大到长度为 6 的区间，从而配合偏移量 +1 得到目标范围。


*/