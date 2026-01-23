public class OperateDemo2 {
    public static void main(String[] args)
    {
        /*
        赋值运算符。
        = += -= *= /= %=
        */
       //int x,y z;
       //x=y=z=3;
        
       int a=3;//右边赋给左边。
       a+=4;//将左右两边的和赋给左边。 a= a+4;

       short s=4;
       //s=s+5;//编译失败; 为什么？因为等号右边为int型，而等号左边规定为short型，Java认为这种从int到short的转换可能会丢失精度（因为int的范围要远大于short），所以要求你必须进行强制类型转换，否则就报错。
       //为什么等号右边是int型？因为在byte,short,char参与算术运算时，会自动提升为int型；
       s+=5;//编译通过，会做自动转换。    
            //为什么这样写就能通过？因为+=是一个独立的复合赋值运算符，它内置了一个隐式强制类型转换。
            // s+=5 <=> s=(sort)(s+5)
        System.out.println("Hello World");    
        
    }

}
