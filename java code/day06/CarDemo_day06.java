package day06;

public class CarDemo_day06 {
    
    /*
    将面向对象使用落实到代码上。

    描述小汽车。
    分析：
        事物的属性：
            颜色。
            轮胎个数。
        事物的行为（功能）：
            运行。
    发现：事物其实就是由属性和行为组成的。
    可以简单理解：属性就是数值，其实就是变量：行为就是功能，就是函数。
    小汽车：
        {
            颜色；
            轮胎个数；
            运行()
            {
            
            }
        }


        通过计算机语言Java来描述这个事物。
        Java描述事物是通过类来完成的。
        class Car
        {
            String color;
            int nunber;
            
            void run()
            {
                System.out.println(color+"::"+number);            
            }
        }


    */


        
        class   Car//类的真正意义就是在描述事物。属性和行为统称为事物中的成员。
                    //成员分两种：成员属性（在代码中的体现:成员变量）和成员行为（代码体现：就是函数）
        {
            //事物的属性。
            String color;
            int number; //color和number都是成员变量：在类中定义的变量；

            //事物的行为。
            void run()
            {
                System.out.println(color+"::"+number);
            }
            //主函数没有定义，是可以定义的，就看该类需不需要独立运行。而该类不需要独立运行，所有没有写。
        }
        

        //把写好的代码测试一下。需要一个可以独立运行类。
        class CarDemo
        {

            public static void main(String[] args)
            {
                //测试：Car类中的run方法。
                //1,创建Car的对象。给对象起个名字。
                Car c =new Car();//c是类类型的变量。c指向了一个具体的Car类型的对象。
                //2.通过已有的对象调用该对象的功能。格式：对象，对象成员；
                //其中的c就是一个局部变量：在方法中定义的变量。
                //3.可以对该对象的属性赋值。
                c.color = "red";
                c.number = 4;
                c.run();

                Car c1=new Car();
                c1.color = "black";
                c1.number=3;
                c1.run();
                /*
                画图小练习。
		        Car c = new Car();
		        Car c1 = new Car();
		        c1.color = "green";
		        c.number = 5;
		        c1.run();//结果是什么？
		        c = null;//有垃圾吗？you
                */
            }
        }
        
}


/*
类与对象关系：
类：对事物的描述。需要体现属性和行为。
对象：该类事物创建的实例（实体），通过该对象调用具有的属性和行为。

成员变量和局部变量的区别：
区别一：定义的位置不同。
    成员变量定义在类中。
    局部变量定义在方法中以及语句里。

区别二：在内存中的位置不同。
    成员变量存储在堆内存的对象中。
    局部变量
*/