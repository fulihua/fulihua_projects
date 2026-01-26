package day02;
class Test_day02
{
    public static void main(String[] args)
    {
        int a = 3,b;
        b=(a++)+(++a)+(a++)*2+a+(++a);
          // 3    5      5*2   6   7 
        System.out.println("a="+a+",b="+b);//a=7,b=31
        int i=3;
        i=i++;
        /*
        temp=i;
        i=i+1;
        i=temp;
        */  
       System.out.println("i="+i);
    }
}
