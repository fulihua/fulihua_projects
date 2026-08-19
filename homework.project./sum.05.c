#include<stdio.h>
int main()
{
	int cock=0,hen,chick;
	while(cock<=20)
	{
	 hen=0;
	 while(hen<=33)
	  {
	    chick=100-cock-hen;
		if(chick>=0&&chick%3==0&&5*cock+3*hen+chick/3==100)
		  {
			printf("%d\n%d\n%d\n",cock,hen,chick);
		  }
	    hen++;
	   }
	  cock++;
	 }
return 0;
}
