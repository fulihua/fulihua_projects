#include<stdio.h>
int main()
{
	int year,month,day,next_month,next_year,next_day,maxDay;
	printf("Enter date (year month day):");
	scanf("%d%d%d",&year,&month,&day);
	next_year = year;
	next_month = month;
	next_day = day + 1;
	switch (month)
	{
		case 2:
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
	{
		 maxDay = 29;
	 }
		else
	{
		 maxDay = 28;
	}
			 break;
	case 4:
	case 6:
	case 9:
	case 11: maxDay = 30;
		 break;
	default: maxDay = 31;
		 break;
	}
	if(next_day > maxDay)
	{
	 	next_day = 1;
	 	next_month++;
	
		 if(next_month > 12)
		{
			 next_month = 1;
			 next_year ++;
		}
		
	}
   printf("%d%d%d_%d%d%d\n",year,month,day,next_year,next_month,next_day);
return 0;
}
