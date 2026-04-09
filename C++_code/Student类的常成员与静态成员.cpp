/*
第1关：Student类的常成员与静态成员
本关任务：定义类 Student，
私有数据成员包括

int classNo，表示学生所在班号，不允许被修改,故为常数据成员
int count，表示学生对象的数目，也可以看作是学生对象的流水号，为所有学生对象共享，故为静态成员
公有成员函数包括

构造函数 Student(int i) 对classNo赋初值
void print() 函数，用于输出对象的信息，例如 Student1’s classNo is 6. 其中，1为该对象的流水号，6为该对象的班号

在 Begin 和 End 之间补充代码。
根据用户输入的班号，初始化Student对象的班号，并通过调用print成员函数输出相应信息。

测试输入：6
预期输出：
Please enter the student's classNo:
Student1’s classNo is 6.
Student2’s classNo is 6.
*/
#include <iostream>
    using namespace std;
    class Student
    {
    /****************Begin****************/
        private:
        const int classNo;
        static int count;
        public:
        Student(int i);
        void print();
        
    /****************End****************/
    };

    // 定义和初始化静态成员
    /****************Begin****************/
    int Student::count = 0;

    /****************End****************/
    // 定义构造函数，用参数i初始化常数据成员classNo, 更新人数（流水号）
    //注意，常数据成员只能通过初始化列表的形式，不可以赋值
    /****************Begin****************/
    Student::Student(int i):classNo(i)
        {
            count++;
        }


    /****************End****************/
    void Student::print()
    {
        cout << "Student"<< count << "'s classNo is "<<classNo <<"." << endl;
    }
    int main() {
        // 建立对象stu1和stu2，并以m作为初值，调用构造函数
        // 通过构造函数的初始化列表给对象的常数据成员赋初值
        int m;
        cout <<"Please enter the student's classNo: "<<endl;
        cin >> m ;
        Student stu1(m);
        stu1.print();
        Student stu2(m);
        stu2.print();
        return 0;
    }

