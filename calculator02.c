#include<stdio.h>
int main()
{
	float a,b,c;
	char oper;
	printf("输入一个算术运算符和两个实数:");
	scanf("%c%f%f",&oper,&a,&b);
	swith(oper)
	{
	 case '+': c=a+b;
			printf("%.2f+%.2f=%.2f\n",a,b,c);
			break;
	 case '-': c=a-b;
                        printf("%.2f-%.2f=%.2f\n",a,b,c);
			 break;         
	 case '*': c=a*b;
                        printf("%.2f*%.2f=%.2f\n",a,b,c);
			 break;
	 case '/': if(b==0)
		      {
                        printf("除数不能为0\n")
			return 0;
		      }
		    else
		      {
			c=a/b;
			     printf("%.2f/%.2f=%.2f\n",a,b,c);
                      }
			break;
		default: printf("无效的运算符\n");
	}
return 0;
}
