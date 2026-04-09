/*
第一关：构造函数 —— 学生信息类
要求：编写一个学生类 Student，类中含有两个成员变量、两个构造函数和一个析构函数（访问性都为公有的），平台会调用你编写的函数来创建学生对象，具体要求如下：

学号：int SID
姓名：string Name
无参的构造函数：Student()，在函数中将学号初始化为0，姓名初始化为王小明。
带两个参数的构造函数：Student(int sid,string name);，在函数中分别用这两个参数设置内部的两个成员。
析构函数：~Student()，在函数中输出学号 姓名 退出程序的消息。

测试输入：1 厉宏富 2 冷欣荣 3 鲍俊民

预期输出：

0 王小明 退出程序
3 鲍俊民 退出程序
2 冷欣荣 退出程序
1 厉宏富 退出程序
*/
#include<iostream>
using namespace std;
#include<string>
class Student
{
    private:
    int SID;
    string Name;
    public:
    Student()
    {
        SID = 0;
        Name = "王小明";
    }
    Student(int sid,string name)
    {
        SID = sid;
        Name = name;
    }
    ~Student()
    {
        cout<<SID<<" "<<Name<<" "<<"退出程序"<<endl;
    }
};

/*第2关：对象数组 —— 学生信息表
本关任务：编写一个能管理多条学生信息的程序。
设计 Student 类并实现用于管理学生信息表（学生表的长度不超过5）的3个函数，成员变量和函数的访问性都为公有的，具体类结构和函数要求如下：
学号，int类型
姓名，string类型
分数，float类型
带参构造函数：Student(int sid,string name,float sco)，分别用这三个参数设置内部的三个成员。
void Add(int sid,string name,float sco)，函数用于向学生表的末尾添加一条学生记录。
void PrintAll()，输出学生表中所有的记录，格式为：学号 姓名 成绩。
void Average()，计算学生表中学生的平均成绩并输出，格式为：平均成绩 计算结果。
提示：学生表可以用全局对象数组来完成，定义全局对象数组和定义全局变量一样，即定义在最外层作用域。

测试输入：0 厉宏富 96 1 冷欣荣 85 2 鲍俊民 76

预期输出：

0 厉宏富 96
1 冷欣荣 85
2 鲍俊民 76
平均成绩 85.6667

*/

#include<iostream>
#include<string>
using namespace std;
class Student
{
    public:
    int id;
    string name;
    float score;
    Student(){}
    Student(int i,string n,float s)
    {
        id = i;
        name = n;
        score = s;
    }

};
Student students[5];
int num = 0;
void Add(int i,string n,float s)
{
    students[num].id = i;
    students[num].name = n;
    students[num].score = s;
    num++;
}
void PrintAll()
{
    for(int i = 0;i<num;i++)
    {
        cout<<students[i].id<<" "<<students[i].name<<" "<<students[i].score;
    }
}
void Average()
{
    double ave =0;
    double sum = 0;
    for(int i=0;i<num;i++)
    {
        sum+=students[i].score;
    }
    ave = sum/num;
    cout<<"平均成绩："<<ave<<endl;
}

/*
注意：

1.一定要记得写无参的构造函数！！！
因为如果只定义了一个有参构造函数 Student(int i,string n,float s)。
当编译器看到 Student students[5]; 时，它需要创建 5 个 Student 对象，
但找不到无参构造函数（默认无参构造函数只在你不写任何构造函数时才会自动生成），所以编译失败。

2.num不能改成count！！！
若写成count会报错，“count” 不明确 错误，是因为 count 这个名字与标准库中的 std::count 算法冲突了。

3.关于Add函数：
那不是有构造函数吗？直接调用构造函数传参就好了啊，为什么还要用add函数？
答：
构造函数是用来创建并初始化一个 Student 对象的。
Add 函数不是要创建独立的学生对象，而是要把学生信息存储到全局数组 students 中的下一个空闲位置，相当于维护一个“学生表”。
这个表是一个容器，用来存放多个学生的数据。
总结：
构造函数：负责创建一个全新的、独立的学生对象。

Add 函数：负责将信息填入已经存在的数组元素中，它不创建新对象，而是复用已有的对象槽位。

两者用途不同：一个是个体对象的诞生，一个是容器元素的更新。
*/




/*
第3关：静态成员 —— 模拟共享书店
编程要求：设计一个 User 类（客户类），现有一个共享书店，该书店客户在进入书店时需要托管一定量的书籍，而这些书籍将由书店内所有用户共享，当客户离开书店时，他还是要将他进入书店时托管的书带走。设计时访问性可自主选择，具体要求如下：
姓名：string Name
托管的书籍量：int Books
带参构造函数：User(string name,int books)，使用这两个参数初始化内部的两个成员，同时按照姓名 数量 进入的格式打印一条消息。
析构函数：~User()，按照姓名 数量 离开的格式打印一条消息。
静态成员函数：void GetState()，按照书店人数:用户总数，书店共享书数量:书籍总数，人均共享数量:人均书籍量的格式打印一条消息，其中人均书籍量只保留整数部分，具体请参考测试说明。
提示：可以增加 UserCount ，BookCount 两个静态变量用于记录已有用户数和已有书籍数。

测试输入：厉宏富 10 冷欣荣 2 叶文光 0

预期输出：

厉宏富 10 进入
冷欣荣 2 进入
书店人数:2，书店共享书数量:12，人均共享数量:6
厉宏富 10 离开
叶文光 0 进入
书店人数:2，书店共享书数量:2，人均共享数量:1
冷欣荣 2 离开
书店人数:1，书店共享书数量:0，人均共享数量:0
叶文光 0 离开
*/


#include<iostream>
#include<string>
using namespace std;

class User
{
    private:
    static int totalUsers;
    static int totalBooks;
    string Name;
    int Books;
    public:
    User(string name,int books)
    {
        Name = name;
        Books = books;
        totalUsers++;
        totalBooks+=books;
        cout<<Name<<" "<<books<<" "<<"进入"<<endl;
    }
    ~User()
    {
        totalBooks-=Books;
        totalUsers--;
        if(totalUsers!=0)
        {
            cout<<Name<<Books<<"离开"<<endl;
        }
        else
        {cout<<Name<<Books<<"离开";}
        
    }
 static void Getstate()
{
    int ave = 0;
    if(totalUsers!=0)
    {
        ave = totalBooks/totalUsers;
        cout<<"书店人数:"<<totalUsers<<","<<"书店共享书数量:"<<totalBooks<<","<<"人均共享数量:"<<ave<<endl;
        }
};
int User::totalUsers = 0;
int User::totalBooks = 0;
};

/*
注意：
问：
1.为什么 int User::totalUsers = 0; 要在最后定义？直接在构造函数里定义不行吗？
答：
静态成员变量属于类本身，不属于任何对象，必须在类外单独分配存储空间并初始化。这行代码是定义（分配内存），而不是声明。
不能在构造函数中定义，因为构造函数每创建一个对象就会执行一次，而静态成员只能初始化一次。如果放在构造函数里，每次创建对象都会重新赋值，而且无法通过编译。

规则：静态成员变量在类内声明，在类外定义（通常放在 .cpp 文件中）。
2.static 的作用是什么？
答：
静态成员变量：所有对象共享一份，用于记录全局状态（如总人数、总书籍数）。
静态成员函数：可以直接通过类名调用（User::GetState()），不需要创建对象。它只能访问静态成员变量，不能访问非静态成员。
3.为什么 Getstate 和静态成员变量前都要加 static？
静态成员变量：加 static 表示它属于类，而不是对象。
静态成员函数：加 static 表示它不需要对象即可调用，并且只能访问静态成员。
如果不加 static，Getstate 就成了普通成员函数，必须通过对象调用（如 user.GetState()），但题目要求可能通过类名调用，所以需要静态。

总结
static 成员变量 → 全局唯一副本，所有对象共享。

static 成员函数 → 类级别操作，无需对象，只能访问静态成员。



*/

