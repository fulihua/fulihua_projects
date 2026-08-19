/*
第1关：医生接诊
本关任务：定义Doctor医生类、Patient患者类：
医生拥有姓名、科室；
患者拥有姓名、病症；
医生可为多名患者接诊看病，医生不存患者数据，只通过函数传参交互。

编程要求
根据提示，在右侧编辑器补充代码:
对Patient做前置声明；
Patient 患者类：
私有成员：姓名name、病症ill
构造函数初始化姓名和病症
成员函数showIll()：输出患者病症信息
Doctor 医生类：
私有成员：姓名dName、科室dept
构造函数初始化姓名和科室
成员函数diagnose(Patient &p)：接诊单个患者，调用患者病症信息，输出诊疗提示。

测试输入：
张大夫
呼吸内科
2
王明
咳嗽咽痛
刘芳
胸闷乏力

预期输出：

请输入医生姓名：
请输入所属科室：
请输入接诊患者人数：
第1位患者姓名：
病症描述：
第2位患者姓名：
病症描述：
呼吸内科张大夫接诊
患者：王明，病症：咳嗽咽痛
问诊完成，已登记诊疗建议
呼吸内科张大夫接诊
患者：刘芳，病症：胸闷乏力
问诊完成，已登记诊疗建议
所有患者接诊完毕！
*/
#include <iostream>
#include <string>
using namespace std;
class Patient;
class Patient
{
    private:
    string pname;
    string ill;
    public:
    Patient(string p,string i):pname(p),ill(i)
    {}
    void showill()
    {
        cout<<"患者："<<pname<<"，病症："<<ill<<endl;
    }
};
class Doctor
{
    private:
    string dname;
    string dept;
    public:
    Doctor(string d,string de):dname(d),dept(de)
    {}
    void diagnose(Patient &p)
    {
        cout<<dept<<dname<<"接诊"<<endl;
        p.showill();
        cout<<"问诊完成，已登记诊疗建议"<<endl;
    }
};
int main()
{
    string ill,patname;
    string dept,docname;
    int count;
    cout<<"请输入医生姓名："<<endl;
    cin>>docname;
    cout<<"请输入所属诊室："<<endl;
    cin>>dept;
    cout<<"请输入接诊人数："<<endl;
    cin>>count;
    string names[100],ills[100];
    Doctor doc(docname,dept);
    for(int i=1;i<=count;i++)
    {
        cout<<"第"<<i<<"位患者姓名："<<endl;
        cin>>names[i];
        cout<<"病情描述"<<endl;
        cin>>ills[i];
    }
    for(int i = 1;i<=count;i++)
    {
        Patient pat(names[i],ills[i]);
        doc.diagnose(pat);

    }
    cout<<"所有患者接诊完毕！"<<endl;
    return 0;
}



/*
第2关：班级学生管理系统
任务描述
本关任务：设计两个类：学生类 (Student)：有姓名、学号，独立存在，不依赖班级。班级类 (Class)：用指针数组收纳学生，实现添加学生、展示全班学生。
业务逻辑：
学生随时加入班级、转出班级；班级消失，学生依然存在，属于聚合关系。学生是单独 new 创建，完全独立，能换班，符合聚合；班级只存指针成员；班级没了，学生对象还在内存里。

编程要求
根据提示，在右侧编辑器补充代码。
Student 类
私有：姓名、学号
构造函数初始化信息
成员函数：展示个人信息
Class 类
私有：班级名、学生指针数组、当前人数
新增学生方法：把外部学生指针加入班级
展示全班所有学生信息
main 函数
键盘输入班级名称
输入学生数量，循环录入每个学生姓名 + 学号
把学生逐个添加进班级
打印全班花名册

测试输入：
高三(1)班
3
李明
20260101
王浩
20260102
张晓雅
20260103

预期输出：
请输入班级名称：
请输入学生人数：
第1位学生：
姓名：学号：
第2位学生：
姓名：学号：
第3位学生：
姓名：学号：
高三(1)班学生花名册
学号：20260101，姓名：李明
学号：20260102，姓名：王浩
学号：20260103，姓名：张晓雅
*/
class Student
{
    private:
    string sname;
    string id;
    public:
    Student(string s,string i):sname(s),id(i)
    {}
    void show()
    {
        cout<<"学号："<<id<<"，姓名："<<sname<<endl;
    }
};
class Class
{
    private:
    string cname;
    int count;
    Student* students[100];
    public:
    Class(string c):cname(c),count(0)
    {}
    void put(Student* stu)
    {
        if(count<100)
        {
            students[count]=stu;
            count++;
        }
        
    }
    void showinfo()
    {
        cout<<cname<<"花名册"<<endl;
        for(int i= 0;i<count;i++)
        {
            students[i]->show();
        }
    }
};
int main()
{
    string cname;
    int count = 0;
    cout<<"请输入班级名称："<<endl;
    cin>>cname;
    cout<<"请输入学生人数："<<endl;
    cin>>count;
    Class myclass(cname);
    for(int i= 1;i<=count;i++)
    {
        string name,id;
        cout<<"第"<<i<<"位学生："<<endl;
        cout<<"姓名："<<name<<"学号："<<id<<endl;
        cin>>name;
        cin>>id;
       Student *stu = new Student(name,id);
       myclass.put(stu);
    }
    myclass.showinfo();
    return 0;
}