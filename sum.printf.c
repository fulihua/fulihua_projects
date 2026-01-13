#include <stdio.h>
int main()
{
	char a = 'A';
	int b = 9;
	float c = 12.3;
	double d = 34.56;
	printf("输入不同类型的数据：a = %c,b = %d,c =%f,d = %lf\n",a, b, c, d);
	printf("控制输出的宽度精度：%8c,% 8d,% 8.2f\n", a, b, c);
	printf("控制输出的左右对齐：% 8d， % -8d\n",b,b);
	printf("使用0进行空位填充：%08d\n", b);
	printf("使用+显示正数的正号：%0+8.2f\n",c);
	return 0;
}
