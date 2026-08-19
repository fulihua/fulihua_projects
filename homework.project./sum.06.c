#include<stdio.h>
int main()
{
	int n,i,j;
	printf("请输入一个正整数:");
	scanf("%d",&n);
	i=2;
	while(i<=n)
	{
	  j=2;
	  while(j<i)
	  {
	   if(i%j==0)
	   {
	    break;
	   }
	   j++;
	   }
	 if(j==i)
	   {
		printf("%d",i);
	   }
	   i++;
	}
return 0;
}
