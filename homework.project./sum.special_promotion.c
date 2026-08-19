#include<stdio.h>
int main()
{
	int n;
	float x,y,r;
	printf("请输入商品的实际价格:");
	scanf("%f",&x);
	if(x<=0)
	printf("输入的商品价格有误\n");
	else
	{
	 n=(int)x/1000;
	 switch(n)
	  {
	   case 0: r=0; break;
	   case 1: r=0.1; break; 
	   case 2:
	   case 3:
	   case 4: r=0.22; break;
	   case 5:
	   case 6:
	   case 7: r=0.35; break;
	   case 8:
	   case 9: r=0.4; break;
	  default: r=0.5;
	  }
	y=x*(1-r);
	printf("优惠后的商品价格：%.2f\n",y);
	}
return 0;
}
