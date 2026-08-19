#include<stdio.h>
int main()
{
	int i,n,flag=1;
	printf("请输入一个整数:");
	scanf("%d",&n);
	for(i=2;i<n;i++)
	{
	 if(n%i==0)
	{
	 flag=0;
	 break;
	}
	}
	if(flag==1)
	{
	 printf("%d是素数",n);
	}
	else
	{
	 printf("%d不是素数",n);
	}
return 0;
}
	
