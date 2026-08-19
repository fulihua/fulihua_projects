/*
第2关：学生成绩管理
任务描述
本关任务：定义一个Student类，实现以下功能：
私有成员：
姓名（string）
学号（int）
语文成绩、数学成绩、英语成绩（double）
公有成员函数：
无参构造函数：初始化姓名为"无名"，学号为0，所有成绩为0
有参构造函数：传入姓名、学号、三科成绩
设置学生信息函数：可修改姓名、学号、成绩
计算总分函数：返回三科成绩之和
计算平均分函数：返回三科成绩平均值
显示学生信息函数：输出姓名、学号、各科成绩、总分、平均分
主函数要求：
创建 2 个学生对象（一个用无参构造，一个用有参构造）
修改第一个对象的信息
分别输出两个学生的完整信息

测试输入：
张三
1001
85.5
92
78
李四
1002
90
88
95
预期输出：
学生1信息：
姓名：张三
学号：1001
语文：85.5 数学：92 英语：78
总分：255.5 平均分：85.1667

学生2信息：
姓名：李四
学号：1002
语文：90 数学：88 英语：95
总分：273 平均分：91
*/


#include<iostream>
#include<string>
using namespace std;
class Student
{
    private:
    string name;
    int id;
    double chinese;
    double english;
    double math;
    double sum = 0;
    double ave = 0;
    public:
    Student()
    {
        name = "无名";
        id = 0;
        chinese = 0;
        english = 0;
        math = 0;
        sum = 0;
        ave = 0;
    }
    Student(string n,int i,double c,double e,double m)
    {
        name = n;
        id = i;
        chinese = c;
        english = e;
        math = m;
        sum = total();
        ave = average();
    }
    void fix(string n,int i,double c,double e,double m)
    {
        name = n;
        id = i;
        chinese = c;
        english = e;
        math = m;
        sum = total();
        ave = average();
    }
    double total()
    {
        return chinese + english + math;
    }
    double average()
    {
        return sum/3;
    }
    void show()
    {
        cout<<"姓名："<<name<<endl;
    cout<<"学号："<<id<<endl;
    cout<<"语文："<<chinese<<" "<<"数学："<<math<<" "<<"英语："<<english<<endl;
    cout<<"总分："<<sum<<" "<<"平均分："<<ave<<endl;
    }
};
int main()
{
    string name;
    int id;
    double chinese,english,math;
    cin>>name>>id>>chinese>>english>>math;
    Student stu1;
    stu1.fix(name,id,chinese,english,math);
    cin>>name>>id>>chinese>>english>>math;
    Student stu2(name,id,chinese,english,math);
    cout<<"学生1信息"<<endl;
    stu1.show();
    cout<<endl;
    cout<<"学生2信息"<<endl;
    stu2.show();
    return 0;

}


/*
问：为什么要用fix啊？直接传正确的值不就好了？

答：代码中使用 fix 函数的原因是：stu1 是通过无参构造函数创建的，此时它的成员变量都是默认值（"无名", 0, 0...）。
而题目要求“修改第一个对象的信息”，因此需要调用一个修改函数（你命名为 fix）来将输入的值赋给 stu1 的成员。
如果不调用 fix，stu1 就会一直是默认值，无法得到输入的数据。

问：函数前加viod不是没有返回值吗？那为什么show（）函数明明输出了还能写void ？到底什么时候写void的？

答：void 表示函数不返回任何值给调用者，但函数内部仍然可以执行各种操作，比如计算、输出、修改全局变量等。

show() 函数的作用是将数据打印到屏幕上，它不需要向调用者返回一个结果，所以返回类型为 void 是合理的。

什么时候用 void？
函数只需要执行一系列操作，但不需要产生一个值交给调用者使用时，就用 void。

例如：输出信息、修改对象的内部状态（如 fix 函数）、关闭文件等。

什么时候写具体类型（如 int、double、string）？
函数需要计算并返回一个结果给调用者时，就写对应的返回类型。

例如：total() 返回总分（double），average() 返回平均分（double）。


*/