#include<stdio.h>
int main()
{
int year,month,day;
printf("year= ,month= ");
scanf("%d %d",&year,&month);
   if(month >= 1 && month <= 12)
    {
	switch(month)
	{
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: printf("31天");  break;
		case 4:
		case 6:
		case 9:
		case 11: printf("30天"); break;
		case 2:
                        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                        printf("29天");
                        else
                        printf("28天");}
    }
   else
   printf("Error");
return 0;
}
