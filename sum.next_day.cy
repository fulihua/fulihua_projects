#include<stdio.h>
int main()
{
	int year,month,day;
	scanf("year= ,month= ,day= ");
	Maxmonth = 12;
	swich (month)
	{
		case 2:
		if (month % 4 == 0 && month % 100 != 0 || month % 400 != 0）
		 Maxday = 29;
		else
		 Maxday = 28; break;
	case 4:
	case 6:
	case 9:
	case 11: Maxday = 30; break;
	defult: Maxday = 31; break;
	}
	if(the next day > the Maxday)
	{
	 the next day = 1;
	 the next month ++;
	printf("%c%c%c",year,the next month,the next day");
	}
		 if(the next month > Maxmonth)
		{
			the next month = 1;
			the next day = 1;
			the next year ++;
		}
		
	}
printf(”%d年%d月%d日的下一天是：%d年%d月%d日“，year,month,day,the next year,the next month,the next day);
return 0
}
