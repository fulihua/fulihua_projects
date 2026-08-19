#include<stdio.h>
int main()
{
	float a,b,c;
	char oper;
	printf("请输入一个算术运算符和两个实数:");
	scanf("%c%f%f",&oper,&a,&b);
	if(oper=='+')
	{ 
	 c=a+b;
	 printf("%.2f+%.2f=%.2f\n",a,b,c);
	}
	else if(oper=='-')
	{
	 c=a-b;
	 printf("%.2f+%.2f=%.2f\n",a,b,c);
	}
	else if(oper=='*')
	{
	 printf("%.2f+%.2f=%.2f\n",a,b,c);
	}
	else if(oper=='/')
	{
	 if(b==0)
	 {
		printf("除数不能为0\n");
	 	return 0;
	 }
	 else
	 {
	  c=a/b;
	  printf("%.2f+%.2f=%.2f\n",a,b,c);
	 }
	}
	else
	{
	 printf("无效的运算符\n");
	}	
return 0;
}
