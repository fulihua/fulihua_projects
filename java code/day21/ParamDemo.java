package day21;

public class ParamDemo {
    public static void main(String[] args)
    {
        //int[] arr = {34,12,89};
        //int sum = add(arr);
        //System.out.println("sum="+sum);

        //int[] arr1 = {23,11,44,55,66};先创建数组，再将这个数组作为实参传递给add方法。
        //int sum1 = add(arr1);
        //System.out.println("sum1="+sum1);

        //jdk1.5以后，出现了简化操作。...用在参数上，称之为可变参数。
        //同样是代表数组，但是在调用这个带有可变参数的函数时，不用创建数组（这就是简单之处），直接
        //将数组中的元素作为实际参数进行传递，其实编译成的class文件，将这些实参先封装到一个数组中，再进行传递。
        //这些动作编译器在生产class时，都帮你完成了。
        int sum = add(34,12,89);
        System.out.println("sum="+sum);

        int sum1 = add(23,11,44,55,66);
        System.out.println("sum1="+sum1);

        //注意事项：记录可变参数一定要定义在参数列表最后。
        //public static int add(int a,int... arr)
    }

    public static int add(int... arr){
        //数组参数的简化表现形式。...代表很多int类型数据。
        int sum = 0;
        for(int i = 0;i<arr.length;i++)
        {
            sum+=arr[i];
        }
        return sum;
    } 
    /*
	// 求多个整数的和。
	public static int add(int[] arr){
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	*/
	// 求两个整数的和。
	public static int add(int a, int b) {
		return a + b;
	}
	// 求三个整数的和。
	public static int add(int a,int b,int c){
		return a + b + c;
	}
	
}

//4月19日  复习
public class ParamDemo{
    public static void main(String[] args){
        //jdk1.5之后，出现了简化操作。  ...用在参数上，称之为可变参数
        //同样是代表数组，但是在调用这个带有可变参数的函数时，不用创建数组（这就是简单之处），直接
        //将数组中的元素作为实际参数进行传递，其实编译成的class文件，将这些实参先封装到一个数组中，再进行传递。
        //这些动作编译器在生产class时，都帮你完成了。
        int sun = add(34,12,89);
        System.out.println("sum="+sum);

        int sum1 = add(23,11,44,55,66);
        System.out.println("sum="+sum1);

        //注意事项：记录可变参数一定要定义在参数列表最后。
        //public static int add(int a,int ... arr)
    }
    public static int add(int... arr){
        //数组参数的简化表现形式。...代表很多int类型数据。
        int sum =0;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    /*
    //求多个整数的和。
    public static int add(int[] arr){
    int sum = 0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
    }
        return sum;
    }
    */
   //求两个整数的和。
   public static int add(int a, int b) {
		return a + b;
	}
	// 求三个整数的和。
	public static int add(int a,int b,int c){
		return a + b + c;
	}
}