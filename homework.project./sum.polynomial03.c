#include<stdio.h>
#include<math.h>
int main()
{
	float x,zi,mu=1,t,sum=0;
	int i=1;
	printf("请输入x的值:");
	scanf("%f",&x);
	zi=x;
	t=zi/mu;
	while(fabs(t)>=1e-7)
	{
	 sum+=t;
	 zi=zi*(-1)*x*x;
	 i+=2;
	mu=mu*(i-1)*i;
	t=zi/mu;
	printf("%f",t);
	}
	printf("sin(%f)=%f\n",x,sum);
	return 0;
}
