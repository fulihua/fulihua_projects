/*
第一题：计算数组元素的平均值
本关任务：编写一个函数，接受一个整数数组和数组的大小作为参数，使用引用返回数组元素的平均值。在 main 函数中调用该函数，并输出计算得到的平均值。
测试输入：8
20 24 23 23 21 25 20 27
预期输出：
数组元素的平均值是: 22.875
*/


#include <iostream>
using namespace std;

double Average(double nPtr[],double n,double&avg)
{   
    float sum = 0;
    float ave = 0;
    for(int i = 0;i<n;i++)
    {
        sum+=nPtr[i];
    }
    avg =(double)sum/n;
    
}
double main()
{
    double nPtr[20];
    double avg;
    double n ;
    cin>>n;
    for(int i = 0;i<n;i++)
    {
        cin>>nPtr[i];
    }
    Average(nPtr,n,avg);
    
    cout<<"数组元素的平均值是："<<avg<<endl;
    return 0;

}


/*
问：这段代码中为什么要用到double&avg引用呢？


答：double& avg 是一个引用参数。
在 Average 函数中，我们希望通过这个参数把计算得到的平均值传回 main 函数。
如果不用引用，传入的 avg 只是 main 中变量的一个副本，函数内部修改的只是副本，不会影响 main 中的原变量。
使用引用后，函数内对 avg 的修改直接作用于 main 中的 avg，从而实现“输出”效果。
在 main 中调用时，直接传入 avg 变量即可，不需要取地址符号。
*/



/*
第二题：实现不同图形的面积计算
本关任务：编写一组重载函数，用于计算不同图形（矩形、圆形、三角形）的面积。函数应分别接受矩形的长和宽、圆形的半径、三角形的底和高作为参数，并返回对应图形的面积。
在 main 函数中调用这些函数，传入相应的数据进行测试，并输出结果。
测试输入：4，91，51，2，32；
预期输出：
平均值：44.0
最大值：91
*/




#include<iostream>
using namespace std;
const double pi = 3.1415926535;


double area(double x,double y)
{
    double S=0;
    S = x * y;
    return S;
}
double area(double x)
{
    double circle = 0;
    circle = pi*x*x;
    return circle;
}
double area(double x,double y,double z)
{
    double trinang = 0;
    trinang = (x*y)/2.0;
    return trinang;
}
int main()
{
double x,y;
cout<<"输入矩形的长和宽:"<<endl;
cin>>x>>y;
double rectangleArea = area(x,y);
cout <<"矩形的面积是:"<<rectangleArea << endl;
cout<<"输入圆的半径:"<<endl;
cin>>x;
double circleArea = area(x);
std::cout <<"圆形的面积是:"<< circleArea << endl;
cout<<"输入三角形的底和高:"<<endl;
cin>>x>>y;
double triangleArea = area(x,y,0);
std:: cout <<"三角形的面积是:"<< triangleArea << endl;
return 0;

}




/*
第3关：动态分配内存-统计成绩
本关任务：编写程序，根据用户输入的人数和成绩统计小于等于平均分的人数。
测试输入：4
60 70 80 90
预期输出：
2



C++ 数组是定长的，本题需要动态分配内存。
int *nPtr = new int[n]; 动态分配长度为n的整型数组空间
别忘了，程序结束前，需要释放动态分配的空间。
delete [] nPtr;
*/




#include<iostream>
using namespace std;

int main()
{
    int num = 0;
    int n;
    int *nPtr;
    nPtr = new int[n];
    double ave = 0;
    cin>>n;
    for(int i =0;i<n;i++)
    {
        cin>>nPtr[i];
    }
    double sum = 0;
    for(int i = 0;i<n;i++)
    {
        sum+= nPtr[i];
    }
    ave = sum /n;
    for(int i = 0;i<n;i++)
    {
        if(nPtr[i]<ave||nPtr[i]==ave)
        {
            num++;
        }
    }
    cout<<num<<endl;
    delete [] nPtr;
    return 0;
}