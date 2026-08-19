#include<stdio.h>
#include<math.h>
int main()
{
	float pi,sum=0,t=1,n=1;
	int sign=1;
	while(fabs(t)>1e-6)
	{
	 sum+=t;
	 n+=2;
	 sign*=-1;
	 t=sign/n;
	}
	pi=sum*4;
	printf("pi的近似值:%f\n",pi);
	return 0;
}
