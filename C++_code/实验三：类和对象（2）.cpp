/*
第一关：点与圆的组合类设计
编程要求
1.定义Point类
私有成员：int x, y，分别表示点的横坐标和纵坐标。
公有成员函数：
Point(int x1, int y1)，并输出提示：Point类构造函数。
~Point()：析构函数，输出提示：Point类析构函数。
void setPoint(int x1, int y1)：设置点的横、纵坐标。
void showPoint()：输出点的坐标，格式为：(x, y)。
2.定义Circle类（组合类）
私有成员：
Point center：圆心。
int r：圆的半径。
公有成员函数：
Circle(int x, int y, int r1)，并输出提示：Circle类构造函数。
~Circle()，输出提示：Circle类析构函数
void setCircle(int x, int y, int r1)：设置圆的圆心坐标、半径。
void showCircle()：输出圆的完整信息，格式为：
圆心：(x, y) 
半径：r。
3.主函数要求
输入 3 个整数：圆心 x、y、半径 r
用带参构造创建 Circle 对象
调用 showCircle() 输出圆信息


测试输入：
5 5 3
预期输出：
Point类构造函数
Circle类构造函数
圆心：(5,5)
半径：3
Circle类析构函数
Point类析构函数
*/

#include<iostream>
#include<string>
using namespace std;
class Point
{
    private:
    int x;
    int y;
    public:
    Point(int x1,int y1):x(x1),y(y1)//只有类才能这样写吗？
    {
        cout<<"Point类构造函数"<<endl;
    }
    ~Point()
    {
        cout<<"Point类析构函数"<<endl;
    }
    void setPoint(int x1,int y1)
    {
        x = x1;
        y = y1;
    }
    void showPoint()
    {
        cout<<"("<<x<<","<<y<<")"<<endl;
    }
};
class Circle
{
    private:
    Point center;
    int r;
    public:
    Circle(int x,int y,int r1):center(x,y),r(r1)
    {
        cout<<"Circle类构造函数"<<endl;
    }
    ~Circle()
    {
        cout<<"Circle类析构函数"<<endl;
    }
    void setCircle(int x1,int y1,int r1)
    {
        center.setPoint(x1,y1);
        r = r1;
    }
    void showCircle()
    {
        cout<<"圆心：";
        center.showPoint();//这个函数本身就已经有输出流了，不需要再装入输出流里面了！！！
        cout<<endl;
        cout<<"半径："<<r<<endl;
    }
};
int main()
{
    int x1,y1,r1;
    cin>>x1>>y1>>r1;
    Circle c(x1,y1,r1);
    c.showCircle();
    return 0;
}

/*
注意：
组合类的成员对象如果没有默认构造函数，必须在外部类的构造函数初始化列表中显式调用其构造函数。

初始化列表是“直接构造”，函数体内赋值是“先构造再修改”。

优先使用初始化列表，尤其是对于组合对象、const 成员、引用成员，以及需要提高效率的场景。

初始化列表只能用于构造函数，不能用于普通成员函数。


*/





/*
第2关：课程成绩管理
编程要求
1.定义 Course 类
私有成员：
string cname：课程名称
int score：课程成绩
公有成员：
带参构造函数：Course(string n, int s)
int getScore()：返回成绩
string getCname()：返回课程名
void showCourse()：输出课程信息
2.定义 Student 类（组合类）
私有成员：
string name：学生姓名
Course c1：第 1 门课程
Course c2：第 2 门课程
Course c3：第 3 门课程
公有成员：
带参构造函数：必须使用初始化列表初始化 3 门课程
int getTotal()：计算并返回 3 门课总分
void showInfo()：输出学生所有信息
3.主函数要求
输入学生姓名
输入3门课程的名称和成绩
创建学生对象
输出完整信息

测试输入：
张三
语文 85
数学 92
英语 90
输出：
学生姓名：张三
课程成绩：
语文：85分
数学：92分
英语：90分
总分：267
*/

#include<iostream>
#include<string>
using namespace std;
class Course
{
    private:
    string cname;
    int score;
    public:
    Course(const string &n,int s):cname(n),score(s)//为啥名字用引用，而成绩不用引用？为啥int s不加const啊？
    {

    }
    int getScore()//这俩函数有什么区别？
    {
        return score;
    }
    string getCname()
    {
        return cname;
    }
    void showCourse()
    {
        cout<<getScore()<<endl;
    }
};
class Student
{
    private:
    string name;//这里的name 和course里面的name不是一个吗？那为什么还要定义两次？
    Course c1;
    Course c2;
    Course c3;
   Student(const string &n,const string &cn1,int s1,const string &cn2,int s2,const string &cn3,int s3):name(n),c1(cn1,s1),c2(cn2,s2),c3(cn3,s3)
   {

   }
   int getTotal()
   {
        return c1.getScore()+c2.getScore()+c3.getScore();
   }
   void showInfo()
   {
    cout<<"学生姓名:"<<name<<endl;
    cout<<"课程成绩："<<endl;
    cout<<c1.getCname()<<":"<<c1.getScore()<<"分"<<endl;
    cout<<c2.getCname()<<":"<<c2.getScore()<<"分"<<endl;
    cout<<c3.getCname()<<":"<<c3.getScore()<<"分"<<endl;
    cout<<"总分:"<<getTotal()<<endl;
   }
};
int main()
{
    string name,course1,course2,course3;
    int score1,score2,score3;
    cin>>name;
    cin>>course1>>score1;
    cin>>course2>>score2;
    cin>>course3>>score3;
    Student s(name,course1,score1,course2,score2,course3,score3);
    s.showInfo();
    return 0;

}



/**
 1. 为什么 Course 构造函数中 string 参数用 const string &（引用），而 int 不用引用？为什么 int s 不加 const？
 
string 用引用：string 是类类型，复制开销较大（需要分配内存、拷贝字符）。用 const 引用可以避免复制，提高效率，同时 const 保证不会修改原字符串。

int 不用引用：int 是基本类型，复制开销极小（通常就是一条指令）。传值即可，不需要引用。当然也可以写成 const int &，但没必要。

int s 不加 const：可以加，例如 const int s，表示参数在函数内不可修改。但通常对于基本类型的值参数，加不加 const 影响不大（因为只是值副本），很多人省略。这里不加也不影响。
  

 2.Student 类中的 name 和 Course 类中的 cname 不是一个，为什么定义两次？

Student 的 name 是学生姓名，Course 的 cname 是课程名称（如“语文”、“数学”）。
两者是不同的概念，自然需要分别定义。即使名字相同（例如都叫 name），但因为属于不同类，作用域不同，不会冲突。但这里语义不同，所以分开定义是正确的。

 3.string getCname()和 void showCourse()的功能不一样吗？为什么要写两遍？

getScore() 是一个 getter 方法，它的作用是返回分数的数值。这样外部代码（比如 Student 类）可以获取分数，用来计算总分、平均分等，而不仅仅是输出。

showCourse() 是一个 显示方法，它的作用是把分数打印到屏幕上，不返回任何值。

如果去掉 getScore()，只保留 showCourse()：

Student 类就无法获得每门课的具体分数，也就无法计算总分（因为总分需要各科分数数值）。

即使强行在 showCourse() 里输出分数，但计算总分时还是需要数值，无法通过输出得到。

所以两者并不多余，而是各司其职：

getScore → 提供数据给程序逻辑使用（如求和、比较）。

showCourse → 提供显示功能给用户看。

简化思考
你可以把 getScore 想象成“取钱”，showCourse 想象成“数钱给外人看”。取钱是为了自己花（做计算），数钱给别人看只是为了展示，两者目的不同，不能互相替代。

当然，如果确实永远不需要获取分数值，也可以直接把分数成员变量设为 public 或者只写 showCourse，但这样做会破坏封装，且不利于扩展。通常推荐保留 getter，即使暂时用不到，也为未来留有余地。




 */