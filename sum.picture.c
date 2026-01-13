#include<stdio.h>
int main()
{
	int i,j,k;
	for(i=1;i<9;i++)
	{
	for(k=1;k<=9-i;k++)
	{
	printf(" ");
	}
	 for(j=1;j<=2*i-1;j++)
	 {
	  printf("%d",i);
	 }
	printf("\n");
	}
return 0;
}
