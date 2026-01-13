#include<stdio.h>
#include<math.h>
int main()
{
	int a[5][5],i,j,gem_row,gem_col;
	for(i=0;i<5;i++)
	{
	 for(j=0;j<5;j++)
	 {
	  scanf("%d",&a[i][j]);
	  if(a[i][j]==1)
	 {
	  gem_row=i;
	  gem_col=j;
	 }
	 }
	}
	int m,n,sum;
	m=fabs(gem_row-2);
	n=fabs(gem_col-2);
	sum=m+n;
	printf("%d",sum);
return 0;
}
