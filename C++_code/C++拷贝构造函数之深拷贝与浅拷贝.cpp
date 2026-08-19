/*
第1关：C++的深拷贝与浅拷贝

预期输出：
姓名：小明
ID：001
C++成绩：100
数学成绩：100
英语成绩：100
*/
#include <iostream>
#include <string.h>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
class Student
{
private:
	char *name;           //姓名
	string id;             //学号
	double cpp_score;      //C++成绩
	double math_score;     //数学成绩
	double Eng_score;      //英语成绩
public:
	//此处定义构造函数
    Student(const char* n,string i,double c,double m,double e)
    {
        name = new char[strlen(n)+1];
        strcpy(name,n);
        id = i;
        cpp_score = c;
        math_score = m;
        Eng_score = e;
	}
    //--------- --------------------------
	//此处定义深拷贝构造函数 
    Student(const Student& other)
    {
        name = new char[strlen(other.name)+1];
        strcpy(name,other.name);
        id = other.id;
        cpp_score = other.cpp_score;
        math_score = other.math_score;
        Eng_score = other.Eng_score;
    }
    //---------------------------------------
	//此处定义析构函数
	~Student()
	{
		delete[] name;
	} 
	//------------------------------------ 
	void show();//数据输出到屏幕上
	
};

void Student::show()
{
	cout << "姓名：" << name << endl;
	cout << "ID：" << id << endl;
	cout << "C++成绩：" << cpp_score << endl;
	cout << "数学成绩：" << math_score << endl;
	cout << "英语成绩：" << Eng_score << endl; 
}
int main(int argc, char** argv) {
	Student s1("小明","001",100,100,100);
	Student s2 = s1;
	s2.show();
	return 0;
}


/*
问：关于Student(const Student& other)
    {
        name = new char[strlen(other.name)+1];
        strcpy(name,other.name);
        id = other.id;
        cpp_score = other.cpp_score;
        math_score = other.math_score;
        Eng_score = other.Eng_score;
    }
        和
     Student(const char* n,string i,double c,double m,double e)
    {
        name = new char[strlen(n)+1];
        strcpy(name,n);
        id = i;
        cpp_score = c;
        math_score = m;
        Eng_score = e;
	}
        这两个有什么区别？都是深拷贝吗？

答：是的，两个都是深拷贝。
两个构造函数的区别（通俗版）
1. 普通构造函数：就像“用原材料造一个新房子”
cpp
Student(const char* n, string i, double c, double m, double e)
你提供一堆零散的建材：姓名（C字符串）、学号、三门成绩。

函数内部根据这些建材，从零开始建造一个全新的学生对象。

因为姓名是外来材料（可能用完就丢），所以必须复制一份存到自己家里（深拷贝），以防原材料被销毁后家里变成空洞。

2. 拷贝构造函数：就像“克隆一个已有的房子”
cpp
Student(const Student& other)
你给函数一个已经建好的房子（other对象）。

函数会原样复制这个房子的所有结构，克隆出一个一模一样的新房子。

同样，为了让新房子独立，也要把原房子里的姓名内容复制一份放到新房子里（深拷贝），而不是两个房子共用同一份姓名。

简单总结：

普通构造 = 用原料新建。

拷贝构造 = 用旧对象克隆。


*/


/*
知识点总结：

不加 const 的引用 = 可以直接修改外面那个变量本身的值！
 
不是改名字，不是改别名，
是直接改原来那个变量的内容！
 
我用最简单的例子给你看
 int main() {
    int a = 10;
    func(a);        // 把 a 传进去

    // 现在 a 变成 999 了！
}
 
 
看到了吗？
x 是 a 的引用，改 x 就是改 a！
 
这就是：
 
不加 const 的引用 = 可以改外面的东西
 
那加 const 会怎样？
 
 void func(const int& x) {
    x = 999;   // 报错！不允许修改！
}
 
加了 const → 不能改外面的值
 
 
 
终极总结（一定要记死）
 
-  int& x         = 引用，可以改外面变量的值

-  const int& x   = 引用，不能改外面变量的值
 
跟“改名字”半毛钱关系都没有！
是改“值”！改“内容”！改“数据”！


---------------------------------------------------------------------------------------------------------------------

好，我现在完全以大一C++老师的身份，一步一步、超级细致、一句一句讲，不讲半句空话，保证你把这段代码 + 所有相关知识点彻底吃透。
 
我会分成几块讲：
 
1. 先讲清楚：指针传递、引用传递
2. 再讲：浅复制、深复制（这是你最卡的地方）
3. 再讲：复制构造函数、赋值运算符重载
4. 最后逐行拆开你看不懂的那段代码
 
一、指针传递 & 引用传递（最基础）
 
1. 值传递（你以前学的）
 
cpp
  
void f(int x) {
    x = 100;
}
 
 
- 实参传给形参时，会复制一份
- 函数里改的是副本
- 外面原来的变量不会变
 
 
 
2. 指针传递
 
cpp
  
void f(int* p) {
    *p = 100;
}
 
 
- 传递的是变量的地址
-  *p  就是地址指向的那个变量本身
- 所以函数里改  *p ，外面的变量直接被改掉
 
 
 
3. 引用传递（C++ 特有）
 
cpp
  
void f(int& x) {
    x = 100;
}
 
 
-  int& x  意思：x 是外面那个变量的别名
- 没有复制，没有新变量
- 改 x 就是改外面原来的变量
 
重点：
 
-  int& x ：可以改外面变量
-  const int& x ：不能改，只能读
 
复制构造函数里写  const ，就是因为：
我只是复制你，我绝对不改你。
 
 
 
二、浅复制 & 深复制（核心难点）
 
前提：类里有指针
 
cpp
  
class A {
    int* data;
};
 
 
指针  data  不存数据，存的是一个地址，指向堆上的数据。
 
 
 
1. 浅复制（系统默认做的）
 
cpp
  
A a1;
A a2 = a1;
 
 
系统默认干的事只有一句：
 
cpp
  
data = other.data;
 
 
翻译成人话：
 
- a1 的 data 指向一块内存
- a2 直接把地址抄过来
- 两个指针指向同一块内存！
 
后果：
 
- 一个对象改值，另一个也变
- 一个对象析构，把内存删了
- 另一个对象再删一次 → 程序崩溃
 
 
 
2. 深复制（我们手动写的）
 
我们不抄地址，我们干三件事：
 
1. 新开一块内存
2. 把内容复制过去
3. 让自己的指针指向新内存
 
cpp
  
data = new int(*other.data);
 
 
翻译：
 
-  other.data ：别人的地址
-  *other.data ：别人地址里的数据
-  new int(值) ：新开一块 int 大小内存，把数据放进去
- 最后把新地址给自己的  data 
 
结果：
两个对象各有各的内存，互不干扰。
 
 
 
三、复制构造函数（用来创建新对象）
 
什么时候调用？
 
cpp
  
MyClass a;
MyClass b = a;   // 调用复制构造
MyClass c(a);    // 也调用
 
 
格式固定：
 
cpp
  
MyClass(const MyClass& other)
 
 
-  const ：不修改别人
-  & ：引用传递，不复制
-  other ：被复制的那个对象
 
 
 
四、赋值运算符重载（给已存在对象赋值）
 
什么时候调用？
 
cpp
  
MyClass a, b;
a = b;   // 调用赋值重载
 
 
格式固定：
 
cpp
  
MyClass& operator=(const MyClass& other)
 
 
必须干 3 件事：
 
1. 判断是不是自己给自己赋值（ this != &other ）
2. 释放自己原来的内存（ delete data ）
3. 深复制，新开内存，复制内容
 
 
 
五、组合（has-a）
 
一个类里包含另一个类的对象：
 
cpp
  
class Engine {};
class Car {
    Engine e;
};
 
 
Car 有一个 Engine → 组合。
复制 Car 时，Engine 也会被自动复制。
 
 
 
六、逐行逐字拆开你看不懂的代码
 
我现在一句一句讲，你一定能懂。
 
 
 
1. 类定义
 
cpp
  
class MyClass {
private:
    int* data;  // 一个指针，指向堆上的 int
public:
 
 
-  data  是指针
- 不存数字，存地址
 
 
 
2. 复制构造函数（深复制）
 
cpp
  
MyClass(const MyClass& other) {
    data = new int(*other.data);
}
 
 
逐句解释：
 
-  const MyClass& other ：
other 是另一个对象，我只复制它，不改它
-  other.data ：别人的指针（地址）
-  *other.data ：别人指针指向的数据
-  new int(数据) ：新开一块内存，把数据放进去
-  data = ... ：让自己的指针指向这块新内存
 
→ 这就是深复制
 
 
 
3. 赋值运算符重载
 
cpp
  
MyClass& operator=(const MyClass& other) {
 
 
- 返回  MyClass& ：支持链式赋值  a=b=c 
 
cpp
  
if (this != &other) {
 
 
- 防止自己给自己赋值  a=a 
 
cpp
  
delete data;
 
 
- 先把自己原来的内存删掉，避免泄漏
 
cpp
  
data = new int(*other.data);
 
 
- 深复制，新开内存，复制内容
 
cpp
  
}
return *this;
}
 
 
- 返回当前对象本身
 
 
 
4. 析构函数
 
cpp
  
~MyClass() {
    delete data;
}
 
 
- 对象销毁时，自动释放指针指向的内存
- 防止内存泄漏
 
 
 
七、超级总结（考试必背）
 
- 值传递：复制，改不动外面
- 指针/引用传递：可以改外面
- const 引用：只看不改
- 浅复制：复制指针地址，共用内存，会崩
- 深复制：新开内存，复制内容，安全
- 复制构造：用旧对象创建新对象
- 赋值重载：给已存在对象赋值
- 组合：一个类包含另一个类对象
 

*/