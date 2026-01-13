#include<stdio.h>
int main()
{
	int n=1;
	double sum=0.0;
	double term=1.0;
	int sign=1;
	double factorial=1.0;
   do{
	factorial *= n;
	term=(double)sign/factorial;
	sum+=term;
	sign=-sign;
	n++;
     }
    while(term>0.000001||term<-0.000001);
    printf("多项式的和为:%.2f\n",sum);
return 0;
}
