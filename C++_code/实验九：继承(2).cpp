/*
第1关：企业员工工资管理系统

任务描述
本关任务：某企业需要开发一个员工工资管理系统，该系统需要处理不同类型员工的工资计算。企业员工分为全职员工、兼职员工和管理人员，其中部分管理人员同时具有全职或兼职身份。系统需要能够计算并输出每个员工的工资信息。
你的任务是实现以下五个类，完善整个工资管理系统：
FullTimeEmployee（全职员工）
PartTimeEmployee（兼职员工）
Manager（管理人员）
FullTimeManager（全职管理人员）
PartTimeManager（兼职管理人员）

编程要求
基类和主函数已提供，不得修改。
派生类实现要求：
全职员工（FullTimeEmployee）：

继承方式：虚继承自 Employee
新增保护成员：月薪（double）
构造函数：初始化员工 ID、姓名和月薪
方法：calculateSalary() 返回月薪
兼职员工（PartTimeEmployee）：

继承方式：虚继承自 Employee
新增保护成员：时薪（double）、工作小时数（int）
构造函数：初始化员工 ID、姓名、时薪和工作小时数
方法：calculateSalary() 返回时薪 × 工作小时数
管理人员（Manager）：

继承方式：虚继承自 Employee
新增保护成员：部门（string）、奖金（double）
构造函数：初始化员工 ID、姓名、部门和奖金
方法：calculateSalary() 返回奖金
多重继承类实现要求：

全职管理人员（FullTimeManager）：

同时继承 FullTimeEmployee 和 Manager
构造函数：初始化所有基类成员
方法：calculateSalary() 返回月薪 + 奖金
兼职管理人员（PartTimeManager）：

同时继承 PartTimeEmployee 和 Manager
构造函数：初始化所有基类成员
方法：calculateSalary() 返回时薪 × 工作小时数 + 奖金
测试说明
平台会对你编写的代码进行测试：

测试输入：
预期输出：
Employee ID: F1001
Name: John Doe
Salary: $5000

Employee ID: P2001
Name: Jane Smith
Salary: $2000

Employee ID: M3001
Name: Bob Johnson
Salary: $2000

Employee ID: FM4001
Name: Alice Brown
Salary: $7500

Employee ID: PM5001
Name: Charlie Green
Salary: $2600


*/

#include<iostream>
#include<string>
using namespace std;
class Employee {
protected:
    string Id;
    string name;
public:
    Employee(string id, string n) : Id(id), name(n) {}
    string getId() const { return Id; }
    string getName() const { return name; }
};
class FullTimeEmployee:virtual public Employee{
    protected:
    double salary;
    public:
    FullTimeEmployee(string id,string n,double s):Employee(id,n),salary(s){}
    double calculateSalary(){return salary;}
};
class PartTimeEmployee:virtual public Employee{
    protected:
    double hoursalary;
    int workhours;
    public:
    PartTimeEmployee(string id,string n,double h,int w):Employee(id,n),hoursalary(h),workhours(w){}
    double calculateSalary(){return hoursalary*workhours;}
};
class Manager:virtual public Employee{
    protected:
    string group;
    double prize;
    public:
    Manager(string i,string n,string g,double p):Employee(i,n),group(g),prize(p){}
    double calculateSalary(){
        return prize;
    }
};
class FullTimeManager:public FullTimeEmployee,public Manager{
    public:
    FullTimeManager(string id, string n, string g, double s, double p)
    : Employee(id, n), FullTimeEmployee(id, n, s), Manager(id, n, g, p) {}
     double calculateSalary(){
        return (salary+prize);
    }
};
class PartTimeManager:public PartTimeEmployee,public Manager{
     public:
   PartTimeManager(string id, string n, string g, double h, int w, double p)
    : Employee(id, n), PartTimeEmployee(id, n, h, w), Manager(id, n, g, p) {}
    double calculateSalary(){
        return (hoursalary*workhours+prize);
    }
};
int main() 
{
    FullTimeEmployee emp1("F1001", "John Doe", 5000.0);
    PartTimeEmployee emp2("P2001", "Jane Smith", 25.0, 80);
    Manager emp3("M3001", "Bob Johnson", "HR", 2000.0);
    FullTimeManager emp4("FM4001", "Alice Brown", "IT", 6000.0, 1500.0);
    PartTimeManager emp5("PM5001", "Charlie Green", "Marketing", 30.0, 60, 800.0);

    cout << "Employee ID: " << emp1.getId() << endl;
    cout << "Name: " << emp1.getName() << endl;
    cout << "Salary: $" << emp1.calculateSalary() << endl;
    cout << "------------------------" << endl;

    cout << "Employee ID: " << emp2.getId() << endl;
    cout << "Name: " << emp2.getName() << endl;
    cout << "Salary: $" << emp2.calculateSalary() << endl;
    cout << "------------------------" << endl;

    cout << "Employee ID: " << emp3.getId() << endl;
    cout << "Name: " << emp3.getName() << endl;
    cout << "Salary: $" << emp3.calculateSalary() << endl;
    cout << "------------------------" << endl;

    cout << "Employee ID: " << emp4.getId() << endl;
    cout << "Name: " << emp4.getName() << endl;
    cout << "Salary: $" << emp4.calculateSalary() << endl;
    cout << "------------------------" << endl;

    cout << "Employee ID: " << emp5.getId() << endl;
    cout << "Name: " << emp5.getName() << endl;
    cout << "Salary: $" << emp5.calculateSalary() << endl;
    cout << "------------------------" << endl;

    return 0;
}


/*
第2关：多继承

本关任务：本编程任务旨在让你通过 C++ 多继承来模拟现实生活中的人物角色关系。你需要基于给定的部分代码，完成剩余的代码编写，以实现一个完整的多继承程序。具体来说，你需要完成以下几个部分：
Person 类：这是基类，已经给出了部分代码。你需要添加一个 introduce 方法，该方法用于输出人物的姓名和年龄信息。
Student 类：继承自 Person 类，需要添加一个新的成员变量 studentID 来表示学生的学号。同时，要实现一个 study 方法，用于输出学生正在学习的信息，以及一个构造函数来初始化学生的姓名、年龄和学号。
Teacher 类：同样继承自 Person 类，添加成员变量 teacherID 表示教师的编号。实现 teach 方法，用于输出教师正在教学的信息，以及相应的构造函数。
GraduateStudent 类：多继承自 Student 和 Teacher 类。添加一个 assistTeaching 方法，用于输出研究生正在辅助教学的信息，以及一个构造函数来初始化研究生的姓名、年龄、学号和教师编号。
main 函数：从键盘读取用户输入的姓名、年龄、学号和教师编号，使用这些输入的数据创建一个 GraduateStudent 对象，并调用该对象的 introduce、study、teach 和 assistTeaching 方法，以验证程序的正确性。

编程要求
根据提示，在右侧编辑器补充代码。

测试说明
平台会对你编写的代码进行测试：

测试输入：
赵强
28
S2025003
T2025003
预期输出：
My name is 赵强 and I am 28 years old.
赵强 is studying.
赵强 is teaching.
赵强 is assisting in teaching.
My student ID is S2025003
My teacher ID is T2025003
*/
#include <iostream>
#include <string>
using namespace std;

// 基类：人
class Person {
protected:
    string name;
    int age;
public:
    Person(const string& n, int a) : name(n), age(a) {
        // 可以在这里添加初始化相关的代码

    }
    // 请实现 introduce 方法
    void introduce() {
        // 输出姓名和年龄信息
     cout<<"My name is "<<name<<" and I am "<<age<<" years old."<<endl;
    }
};

// 派生类：学生
class Student : virtual public Person {
protected:
    // 请添加成员变量 studentID
    string studentID;
    // 请实现构造函数
    public:
    Student(const string& n, int a,const string& i):Person(n,a),studentID(i){}
    // 请实现 study 方法
    void study(){
        cout<<name<<" is studying."<<endl;
    }
    // 请实现 showStudentID 方法
    void showStudentID(){
        cout<<"My student ID is "<<studentID<<endl;
    }
};

// 派生类：教师
class Teacher :virtual public Person {
protected:
    // 请添加成员变量 teacherID
    string teacherID;
    // 请实现构造函数
    public:
    Teacher(const string& n, int a,const string& i):Person(n,a),teacherID(i){

    }
    // 请实现 teach 方法
    void teach(){
        cout<<name<<" is teaching."<<endl;
    }
    // 请实现 showTeacherID 方法
    void showTeacherID(){
        cout<<"My teacher ID is "<<teacherID<<endl;
    }

};

// 多继承类：研究生（既是学生又是助教）
class GraduateStudent : public Student, public Teacher {
public:
    // 请实现构造函数
    GraduateStudent(const string& n, int a,const string& i,const string& t):Person(n,a),Student(n,a,i),Teacher(n,a,t){}
    // 请实现 assistTeaching 方法
    void assistTeaching(){
        cout<<name<<" is assisting in teaching."<<endl;
    }
};

int main() {
    string name, studentID, teacherID;
    int age;
    cin >> name >> age >> studentID >> teacherID;
    
    // 请使用读取的数据创建一个 GraduateStudent 对象
    GraduateStudent grad(name,age,studentID,teacherID);
    // 请调用该对象的 introduce、study、teach、assistTeaching、showStudentID 和 showTeacherID 方法
    grad.introduce();
    grad.study();
    grad.teach();
    grad.assistTeaching();
    grad.showStudentID();
    grad.showTeacherID();
    return 0;
}



/*
//总结：
问：也就是说爸爸类继承爷爷类时，需要初始化爷爷类，然后 孙子类继承爸爸类时，不仅要初始化爸爸类，还要初始化爷爷类，对吗、

答:
. 普通继承（没有 virtual）
爸爸类继承爷爷类：爸爸的构造函数会在初始化列表中调用爷爷的构造函数（你可以显式写，也可以不写，默认会调用爷爷的无参构造）。

孙子类继承爸爸类：孙子的构造函数只需要调用爸爸的构造函数，爸爸的构造函数会自动调用爷爷的构造函数。孙子不需要也不能直接调用爷爷的构造函数。

. 虚继承（你代码中的情况）
爸爸类虚继承爷爷类：爸爸的构造函数可以（但不强制）调用爷爷的构造函数，但这种调用最终会被忽略。

孙子类同时继承多个爸爸（且爸爸们虚继承了爷爷）：此时，爷爷的虚基类部分必须由孙子直接初始化。也就是说，孙子的初始化列表里必须显式调用爷爷的构造函数，否则爷爷的无参构造会被调用（如果不存在则编译错误）。


回到你的问题
“爸爸类继承爷爷类时，需要初始化爷爷类，然后孙子类继承爸爸类时，不仅要初始化爸爸类，还要初始化爷爷类，对吗？”

普通继承：不对。孙子只需要初始化爸爸，爷爷由爸爸负责。

虚继承：对。孙子必须直接初始化爷爷（即使爸爸也初始化了爷爷，孙子的调用才是真正生效的那个）。
*/



/*
问：为啥这个类中，明明是只继承了 PartTimeEmployee,public Manager，为啥在初始化列表时还需要在写一个 Employee？

答：
在虚继承下，最派生类（如 PartTimeManager）必须直接负责初始化虚基类（Employee）


*/

/*
问：
为啥有的继承需要写虚类，有的继承不需要写？把什么时候需要写虚继承给我讲清楚

答：
将来可能被一个孙子同时继承的那些“爸爸类”，在继承“爷爷类”时必须加上 `virtual`。



什么时候用虚继承？

口诀：

当你想让一个类作为爷爷，后面会有多个爸爸，而一个孙子同时继承这些爸爸时，那这些爸爸都要用 virtual 来继承爷爷。

在你的代码里：

爷爷是 Employee

爸爸们是 FullTimeEmployee、PartTimeEmployee、Manager（因为它们都会被孙子 FullTimeManager 或 PartTimeManager 同时继承）

所以这些爸爸声明时都要写 virtual public Employee

而孙子（如 FullTimeManager）本身继承爸爸时，不需要再加 virtual，因为虚性已经从上往下传了。

//所有可能出现在菱形继承路径中的中间类（即那些会被其他类多重继承的类），都应该采用虚继承
*/