#include<stdio.h>
#include<math.h>
int main()
{
	float zi=1.0,mu=1.0,t,sum=0.0;
	int i=1;
	t=zi/mu;
       while(fabs(t)>=0.000001)
        {
		sum+=t;
	 	zi*=-1.0;
		i++;
	 	mu*=i;
		t=zi/mu;
        }
	 printf("%.2f",sum);
return 0;
}
	
	
