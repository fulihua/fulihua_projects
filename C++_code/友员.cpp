/*
第1关：求两点之间的距离以及是否原点对称

任务描述
本关任务：设计一个程序，用于计算两点之间的距离以及判断两点是否关于原点对称。

测试输入：1 2 
3 4
-1 -2

预期输出：
两点之间的距离是:2.82843
点p1和点p3是否关于原点对称:是


*/
#include<iostream>
#include<cmath>
using namespace std;
class Point{
    private:
    double x,y;
    public:
    Point(double x=0,double y=0):x(x),y(y){}
    friend bool Symmetric(const Point&p1,const Point&p2);
    friend double distance(const Point&p1,const Point&p2);
};
double distance(const Point&p1,const Point&p2){
    double dx = p1.x-p2.x;
    double dy = p1.y-p2.y;
    double s = sqrt(dx*dx+dy*dy);
}
bool Symmetric(const Point&p1,const Point&p2){
    return (p1.x==-p2.x&&p1.y==-p2.y);
}

int main(){
    double x1,y1,x2,y2,x3,y3;
    cin>>x1>>y1>>x2>>y2;
    Point p1(x1,y1);
    Point p2(x2,y2);
    double dis = distance(p1,p2);
    cin>>x3>>y3;
    Point p3(x3,y3);
    bool sym = Symmetric(p1,p3);
    cout<<"两点之间的距离是:"<<dis<<endl;
    cout<<"点p1和p3是否关于原点对称:"<<(sym?"是":"否")<<endl;
    return 0;
}

/*
第2关：学生成绩管理

任务描述
本关任务：实现一个简单的学生成绩管理功能。
你需要设计两个类：Student 类和 Teacher 类。
Student 类包含以下私有数据：
name：学生的姓名，类型为 string。
score：学生的成绩，类型为 int。
提供一个构造函数，用于初始化学生的姓名和成绩。
提供一个成员函数 displayInfo()，用于显示学生的姓名和成绩。
Teacher 类包含以下私有数据：
teacherName：教师的姓名，类型为 string。
提供一个构造函数，用于初始化教师的姓名。
提供以下成员函数：
modifyStudentScore(Student& student, int newScore)：修改指定学生的成绩。
displayStudentInfo(Student& student)：显示指定学生的姓名和成绩。

程序开始时，需要输入教师的姓名、学生的姓名和初始成绩。然后，教师输入要修改的学生成绩。
测试输入：
张三
李四
100
80

预期输出：
修改成绩前学生信息:
学生姓名:李四,成绩:100
修改成绩后学生信息:
学生姓名:李四,成绩:80
*/
#include<iostream>
#include<string>
using namespace std;
class Student{
    private:
    string name;
    int score;
    friend class Teacher;
    public:
    Student(string s,int i):name(s),score(i){}
    void displayInfo(){
        cout<<"学生姓名:"<<name<<",成绩:"<<score<<endl;
    }
};
class Teacher{
    private:
    string tname;
    public:
    Teacher(string t):tname(t){}
    void modifyStudentScore(Student& student,int newScore){
        student.score = newScore;
    }
    void displayStudentInfo(Student& student){
        student.displayInfo();
    }
};
int main(){
    string sname,tname;
    int score1,score2;
    cin>>tname;
    cin>>sname;
    cin>>score1;
    cin>>score2;
    Teacher tea(tname);
    Student stu(sname,score1);
    cout<<"修改成绩前学生信息："<<endl;
    tea.displayStudentInfo(stu);
    cout<<"修改成绩后学生信息："<<endl;
    Student stu2(sname,score2);
    tea.modifyStudentScore(stu,score2);
    tea.displayStudentInfo(stu2);
    return 0;
}