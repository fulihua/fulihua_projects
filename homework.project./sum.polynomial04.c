#include<stdio.h>
int main()
{
	float s=0.0,zi=1.0,mu=1.0,t=1.0;
	int i=1,n;
	printf("请输入一个正整数:");
	scanf("%d",&n);
	while(i<=n)
	{ 
	 s+=t;
	 zi*=-1.0;
	 i++;
	 mu*=i;
	 t=zi/mu;
	}
	printf("%.6f\n",s);
	return 0;
}
