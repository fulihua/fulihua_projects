
/*
第1关：实现Person和Student类的继承关系
任务描述
本关任务：编写一个 C++程序，实现Person 父类和Student 子类的单继承关系。

编程要求
在右侧编辑器补充代码，要求如下：
1.父类 Person
包含保护成员变量：姓名（string）、年龄（int）
包含构造函数：初始化姓名和年龄，打印构造提示信息
包含析构函数：打印析构提示信息
包含公有成员函数：
showInfo()：打印姓名和年龄
eat()：打印 “姓名在吃饭”
2.子类 Student（public 继承 Person）
新增私有成员变量：学号（int）、班级（string）
包含构造函数：先初始化父类成员，再初始化自身成员，打印构造提示信息
包含析构函数：打印析构提示信息
重写父类的eat()函数：打印 “姓名在食堂吃饭”
新增成员函数study()：打印 “姓名在认真学习”
3.主函数
从键盘输入学生的姓名、年龄、学号、班级
创建 Student 对象，调用showInfo()、调用基类的eat()函数、重写后的eat()、study()函数
程序运行时按顺序输出构造、函数调用、析构的完整信息。

测试说明
平台会对你编写的代码进行测试：

测试输入：
张三
18
2025001
高三1班
预期输出：
请输入学生姓名：
请输入学生年龄：
请输入学生学号：
请输入学生班级：
Person构造函数：姓名张三，年龄18
Student构造函数：学号2025001，班级高三1班

姓名：张三，年龄：18
张三在吃饭
张三在食堂吃饭
张三在认真学习
Student析构函数：学号2025001
Person析构函数：姓名张三
*/

#include<iostream>
#include<string>
using namespace std;
class Person{
    protected:
    int age;
    string name;
    public:
    Person(int a,string n):age(a),name(n){
    cout<<"Person构造函数：姓名"<<name<<"，年龄"<<age<<endl;
}
    ~Person(){
    cout<<"Person析构函数：姓名"<<name<<endl;
}
void showInfo(){
    cout<<"姓名："<<name<<"，年龄："<<age<<endl;
  }
void eat(){
    cout<<name<<"在吃饭"<<endl;
}
};
class Student:public Person{
    private:
    int id;
    string grade;
    public:
    Student(int a,string n,int i,string g):Person(a,n),id(i),grade(g){
    cout<<"Student构造函数：学号"<<id<<"，班级"<<grade<<endl;
}
    ~Student(){
    cout<<"Student析构函数：学号"<<id<<endl;
}
void eat(){
    cout<<name<<"在食堂吃饭"<<endl;
}
void study(){
    cout<<name<<"在认真学习"<<endl;
}
};
int main(){
    int age,id;
    string name,grade;
 cout<<"请输入学生姓名："<<endl;
 cin>>name;
 cout<<"请输入学生年龄："<<endl;
 cin>>age;
 cout<<"请输入学生学号："<<endl;
 cin>>id;
 cout<<"请输入学生班级："<<endl;
 cin>>grade;
    cout<<endl;
    Student s(age,name,id,grade);
    s.showInfo();
    s.Person::eat();
    s.eat();
    s.study();
    return 0;
}



/*
第2关：实现交通工具Vehicle 类和Car 子类的继承关系

本关任务：编写一个 C++ 程序，实现Vehicle 父类（交通工具）和Car 子类（汽车）的public 公有继承关系。

编程要求
根据提示，在右侧编辑器补充代码。
1.父类 Vehicle
包含私有成员变量：品牌brand（string）、速度speed（int，单位：km/h）
包含保护成员变量：载重load（int，单位：kg）
包含公有构造函数：接收品牌、速度、载重参数，初始化所有成员，打印Vehicle构造函数：品牌XXX，速度XXkm/h，载重XXkg
包含公有析构函数：打印Vehicle析构函数：品牌XXX
包含公有成员函数：void run()，打印XXX（品牌）以XXkm/h的速度行驶
包含保护成员函数：void showLoad()，打印载重：XXkg
2.子类 Car（public 继承 Vehicle）
新增私有成员变量：座位数seatNum（int）
包含公有构造函数：接收品牌、速度、载重、座位数参数，先初始化父类成员，再初始化自身成员，打印Car构造函数：品牌XXX，座位数XX
包含公有析构函数：打印Car析构函数：品牌XXX
重写父类 run () 函数：打印XXX（品牌）汽车，以XXkm/h的速度平稳行驶
新增公有成员函数：void showCarInfo()，打印品牌：XXX，座位数：XX，载重：XXkg（必须访问父类保护成员load）
新增公有成员函数：void honk()，打印XXX（品牌）汽车鸣笛：嘀嘀嘀
3.主函数
从键盘输入 2 个 Car 对象的完整数据，每个对象包含：品牌、速度、载重、座位数
输入时给出清晰提示（如请输入第1辆汽车的品牌：）
分别创建 2 个 Car 对象，传入输入的数据
分别调用两个对象的run()、showCarInfo()、honk()函数

测试说明
平台会对你编写的代码进行测试：

测试输入：
丰田
120
500
5
大众
110
450
5
预期输出：
请输入第1辆汽车的品牌：
请输入第1辆汽车的速度(km/h)：
请输入第1辆汽车的载重(kg)：
请输入第1辆汽车的座位数：
Vehicle构造函数：品牌丰田，速度120km/h，载重500kg
Car构造函数：品牌丰田，座位数5

请输入第2辆汽车的品牌：
请输入第2辆汽车的速度(km/h)：
请输入第2辆汽车的载重(kg)：
请输入第2辆汽车的座位数：
Vehicle构造函数：品牌大众，速度110km/h，载重450kg
Car构造函数：品牌大众，座位数5

第1辆汽车信息：
丰田汽车，以120km/h的速度平稳行驶
品牌：丰田，座位数：5，载重：500kg
丰田汽车鸣笛：嘀嘀嘀

第2辆汽车信息：
大众汽车，以110km/h的速度平稳行驶
品牌：大众，座位数：5，载重：450kg
大众汽车鸣笛：嘀嘀嘀

Car析构函数：品牌大众
Vehicle析构函数：品牌大众
Car析构函数：品牌丰田
Vehicle析构函数：品牌丰田
*/

#include<iostream>
#include<string>
using namespace std;

class Vehicle{
    private:
    string brand;
    int speed;
    protected:
    int load;
    void showload(){
        cout<<"载重"<<load<<"kg"<<endl;
    }
    public:
    Vehicle(string b,int s,int l):brand(b),speed(s),load(l){
        cout<<"Vehicle构造函数："<<"品牌"<<brand<<",速度"<<speed<<"km/h,"<<"载重"<<load<<"kg"<<endl;
    }
    ~Vehicle(){
        cout<<"Vehicle析构函数：品牌"<<brand<<endl;
    }
     void run(){
        cout<<brand<<"以"<<speed<<"km/h"<<"的速度行驶"<<endl;
    }
    string getbrand(){return brand;}
    int getspeed(){return speed;}
};
class Car:public Vehicle{
    private:
    int seatNum;
    public:
    Car(string b,int s,int l,int seat):Vehicle(b,s,l),seatNum(seat){
        cout<<"Car构造函数： 品牌"<<getbrand()<<"，座位数"<<seatNum<<endl;
    }
    ~Car(){
        cout<<"Car析构函数：品牌"<<getbrand()<<endl;
    }
    void run(){
        cout<<getbrand()<<"汽车,以"<<getspeed()<<"km/h的速度平稳行驶"<<endl;
    }
    void showCarInfo(){
        cout<<"品牌："<<getbrand()<<",座位数："<<seatNum<<",载重："<<load<<"kg"<<endl;
    }
    void honk(){
        cout<<getbrand()<<"汽车鸣笛：嘀嘀嘀"<<endl;
    }
};
int main(){
    string brand;
    int load,speed,seatNum;
    cout<<"请输入第1辆汽车的品牌："<<endl;
    cin>>brand;
    cout<<"请输入第1辆汽车的速度(km/h)："<<endl;
    cin>>speed;
    cout<<"请输入第1辆汽车的载重(kg)："<<endl;
    cin>>load;
    cout<<"请输入第1辆汽车的座位数："<<endl;
    cin>>seatNum;
    Car c1(brand,speed,load,seatNum);
    cout<<endl;

    cout<<"请输入第2辆汽车的品牌："<<endl;
    cin>>brand;
    cout<<"请输入第2辆汽车的速度(km/h)："<<endl;
    cin>>speed;
    cout<<"请输入第2辆汽车的载重(kg)："<<endl;
    cin>>load;
    cout<<"请输入第2辆汽车的座位数："<<endl;
    cin>>seatNum;
    Car c2(brand,speed,load,seatNum);
    cout<<endl;

    cout<<"第1辆汽车信息："<<endl;
    c1.run();
    c1.showCarInfo();
    c1.honk();
    cout<<endl;

    cout<<"第2辆汽车信息："<<endl;
    c2.run();
    c2.showCarInfo();
    c2.honk();
    cout<<endl;
    return 0;
}