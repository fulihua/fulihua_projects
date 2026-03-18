package day17;

public class StringTest2_1 {
    
    public static void main(String[] args)
    {
        /*
		 * 案例一：字符串数组
		 * ["abc","nba","cctv","itcast"]
		 * 要求从小到大排序。
		 * 
		 */
		String[] strs = {"abc","nba","cctv","itcast"};
		printArray(strs);
		sortString(strs);
		printArray(strs);
		

	}

	/**
     * 字符串数组
     * 思路：
     * 1.曾将学过int[]排序，选择，冒泡。
     * 2.字符串排序同理。
     * 3.for嵌套循环。
     * 4.循环中进行元素的大小比较，满足条件位置置换。
    
    */
   public static void sortString(String[] strs)//这段代码中的 String[] strs 是方法 sortString 的参数定义，
   // 它表示这个方法需要接收一个字符串数组作为参数，并在方法内部用变量名 strs 来引用这个数组。参数名 strs 是程序员自定义的，完全合法。
   {
        for(int i = 0;i<strs.length-1;i++)
        {
            for(int j = i+1;j<strs.length;j++)
            {
                if(strs[i].compareTo(strs[j])>0)
                {
                    swap(strs,i,j);
                }
            }
        }
   }

//	Arrays.sort(strs);
/*
	 * 数组元素位置置换。
	 */
    private static void swap(String[] strs,int i,int j)//代码中没有用到String[] strs这个数组，为什么还要写？
//String[] strs 是必须的参数，它告诉方法要操作哪个数组。

//方法体内通过 strs 来访问数组元素，完成交换。

//如果没有这个参数，方法就无法知道要交换的是哪个数组，也就无法工作。
    {
        String temp = strs[i];
        strs[i]= strs[j];
        strs[j] = temp;
    }

    /*
	 * 打印字符串数组。
	 */
    private static void printArray(String[] strs)
    {
        for(int i = 0;i<strs.length;i++)
        {
            System.out.println(strs[i]+" ");
        }
        System.out.println();
    }

}
