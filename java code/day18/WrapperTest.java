package day18;
import java.util.Arrays;
public class WrapperTest {
    private static final String SPACE = " ";
   
    public static void main(String[] args)
    {
        	/*
		 * 练习：【面试题】： "23 9 -4 18 100 7" 要求对这串数字按照从小到大排序，生成一个数值有序的字符串。 思路：
		 * 1，只有排序会，排序需要数组，数组中就要有元素。
		 * 2，元素在哪里？在字符串里，怎么取出来呢？要获取字符串中的内容，是不是需要String对象。
		 * 3，从字符串获取到数值后存储到一个int数组中。因为要排序。 4，将排完序的数组变成字符串。
		 */


        String numsString = "23 9 -4 18 100 7";
        numsString = sortNumberString(numsString);
        System.out.println("nums="+numsString);
    }
    public static String sortNumberString(String numsString)
    {
        //1.获取字符串中的数字。怎么获取？通过空格进行indexOf的索引，找到其位置，substring截取。
        // 可是这个方法很麻烦，这些数值之间的分隔符就是 空格。通过空格对字符串分离，分出来的都是数字内容的字符串。
        // 一个字符串通过分割变成多个字符串。split();
        String[] strs = numsString.split(SPACE);

        //2.不能直接对字符串进行大小排序，因为，字符串23 比 字符串9 要小，是错误的，必须转成整数值才可以比较。
        //将字符串数组转出int数组。
        int[] nums = parseIntArray(strs);
        
        //3.对数组排序。
        Arrays.sort(nums);

        //4.将数组转成字符串。
        return toString(nums);
    }

    private static String toString(int[] nums)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++)
        {
            if(i!=nums.length-1)
            {
                sb.append(nums[i]+" ");
            }
            else{
                sb.append(nums[i]);
            }
        }
        return sb.toString();
    }
    //将字符串数组转成int数组。
    private static int[] parseIntArray(String[] strs)
    {
        //1.定义一个int数组。
        int[] arr = new int[strs.length];

        //2.遍历字符串数组，把元素转成int存储到arr中。
        for(int i = 0;i<strs.length;i++)
        {
            arr[i]= Integer.parseInt(strs[i]);
        }
        return arr;
    }
}


/*
疑问：为什么并没有在代码中 Arrays.sort(nums);
定义这个函数却可以使用？


答：Arrays.sort 是 JDK 提供的一个静态方法，属于 java.util.Arrays 类。
只要导入正确的包，就可以直接通过类名调用，无需自己实现排序逻辑。
这是 Java 标准库为我们提供的便利功能。


*/