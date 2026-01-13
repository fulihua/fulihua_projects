#include<stdio.h>
int main()
{
	int m,n,r,a,b,max,min;
	printf("请输入两个整数:");
	scanf("%d%d",&m,&n);
	if(m>n)
	{
	 a=m;
	 b=n;
	}
	else
	{
	 b=m;
	 a=n;
	}
	r=a%b;
	while(a%b!=0)
	 {
	  a=b;
	  b=r;
	  r=a%b;
	 }
	max=b;
	min=m*n/max;
	printf("最大公约数为:%d\n最小公倍数为:%d\n",max,min);
return 0;
}

