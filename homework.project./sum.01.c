#include<stdio.h>
int main()
{
   int d,i,sum;
        scanf("%d",&i);
   if(i>=0&&i<=100)
	{
	d=2*i;
	sum=(i*(2+d))/2;
	printf("%d",sum);
	}
   else
	printf("不符合条件");
return 0;
}
