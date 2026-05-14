/*
第1关：构造函数和析构函数
任务描述
本关任务：声明一个基类 BaseClass，有整型成员变量 Number，构造其派生类 DerivedClass，观察构造函数和析构函数的执行情况。

编程要求
根据提示，在右侧编辑器补充代码。

测试说明
平台会对你编写的代码进行测试：

测试输入：
预期输出：
Construction. Number = 1
Destruction. Number = 0
*/

#include<iostream>
#include<string>
using namespace std;
class BaseClass{
  protected:
        int Number;
    public:
        BaseClass(int n):Number(n){
            cout<<"Construction.Number = "<<Number<<endl;
}
      ~BaseClass(){
    Number--;
    cout<<"Destruction.Number = "<<Number<<endl;
}

};
class DerivedClass:public BaseClass{
    public:
DerivedClass(int i):BaseClass(i){}
~DerivedClass(){}
};
int main(){
    DerivedClass d(1);
    return 0;
}

