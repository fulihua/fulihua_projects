#include<stdio.h>
int main()
{
	int m,n,max,min,temp;
	scanf("%d%d",&m,&n);
	if(m>n)
	{
	 int a=m,b=n;
	 while(b!=0)
	 {
	  temp=a%b;;
	  a=b;
	  b=temp;
	 }  
	  max=a;
	  min=m*n/max;
	  printf("最大公约数为:%d\n最小公约数为:%d\n",max,min);
	 }
	 else
	 {
	  printf("要求输入的第一个数要比第二个数大，请重新输入\n");
	 }
return 0;
}
