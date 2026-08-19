#include <stdio.h>
int main()
{
    int i,result,n;
    for(i=1;i<=9;i++)
	{ 
	   for (n=1;n<=i;n++)
	 {
	  result=i*n;
	  printf("%d*%d=%d\t",i,n,result);
	  }
	 printf("\n");
	 }
return 0;
}
