#include<stdio.h>
int main()
{
   int n,a,b,c,num;
   scanf("%d",&n);
   if(n>=100&&n<=1000)
   {
        printf("%d以内的水仙花数有：\n",n);
        for(num=100;num<=n;num++)
        {
        a = num / 100;
        b = num % 100 / 10;
        c = num % 10;
        if(num == a*a*a + b*b*b + c*c*c)
        {
         printf("%d",num);
        }
	}
   }
   else
   {
	printf("输入错误！请重新输入。");
   } 
return 0;
}
	
