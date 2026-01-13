#include<stdio.h>
int main()
{
	int i,n=0;
	for(i=1;i<=20;i++)
	{
	 if(i%2==0&&i%3==0)
	{
	 continue;
	}
	printf("%d",i);
	n++;
	}
	printf("满足条件的数有%d",n);
return 0;
}
