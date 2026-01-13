#include<stdio.h>
int main()
{
	int s[3][4]={{64,72,78,66},{88,95,94,85},{78,82,87,80}};
	int i,j,sum;
	printf("------3名学生4门课的成绩------\n");
	printf("\t高数\tC语言\t政治\t英语\n");
	for(i=0;i<3;i++)
	{
	printf("学生%d\t",i+1);
	for(j=0;j<4;j++)
	{
	 printf("%d\t",s[i][j]);
	}
	 printf("\n");
	}
	printf("\n3名学生的平均分:");
	for(i=0;i<3;i++)
	{
	 sum=0;
	 for(j=0;j<4;j++)
	{
	 sum+=s[i][j];
	}
	printf("%.2f\t",sum/4.0);
	}
	printf("\n4门课程的平均分:");
	for(i=0;i<4;i++)
	{
	 sum=0;
	 for(j=0;j<3;j++)
	 {
	  sum+=s[j][i];
	 }
	 printf("%.2f\t",sum/3.0);
	}
	return 0;
}
	
