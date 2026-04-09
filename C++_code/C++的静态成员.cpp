/*
第1关：体验C++静态成员的用法
本关任务：利用静态成员机制，编写一个程序计算 Student 类对象的个数。

测试输入：
5
预期输出：
1
2
3
4
5
4
3
2
1
0
*/
#include <iostream>
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */
class Student
{
private:
	string name;           //姓名
	string id;             //学号
	double cpp_score;      //C++成绩
	double math_score;     //数学成绩
	double Eng_score;      //英语成绩
	//此处填写静态属性num的定义，num用来记录Student对象的个数。 
    static  int num;

    //---------------------------------------------------
	
	
public:
	//此处填写静态成员函数show_num的声明，show_num函数用来将num的值显示到屏幕上
    static int show_num();

    //-----------------------------------------------------
	//构造函数的声明，实现对num值的调整。
    Student();


    //析构函数的声明，实现对num值的调整。
    ~Student();
    };

//此处用来初始化静态属性num 
 int Student::num = 0;

 //-----------------------------------
//此处用来实现show_num函数 
   int Student::show_num()
    {
        cout<<num<<endl;
    }


//-----------------------------------
//此处填写构造函数的定义，实现对num值的调整。
   Student:: Student()
    {
        num++;
    }





//-------------------------------------
//此处填写析构函数的定义，实现对num值的调整。

    Student ::~Student()
{
    num--;
}




//----------------------------------------- 
int main(int argc, char *argv[]) {
	int i, n; 
	Student *ps[100];
	cin >> n;
	for(i = 0; i < n; i++)
	{
		ps[i] = new Student();
		Student::show_num();
	}
	for(i = 0; i < n; i++)
	{
		delete ps[i];
		Student::show_num();
	}
	return 0;
}
