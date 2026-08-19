package day05;
public class ArrayTest10_day05 {
    public static void main(String[] args)
    {
        int[] arr={9,12,15,24,36,41,59,68};

        int index=binarySearch(arr,45);
        System.out.println("index="+index);

    }
    //二分查找。前提：数组必须是有序的。
    /*
    思路：
    1.通过角标先获取中间角标上的元素。
    2.让该元素和要找的数据比较。
    3.如果要找的数大了，缩小范围，要找的范围应该是：中间的角标+1---尾角标。
    如果要找的数小了，要找的范围 头角标---中间角标-1；
    4.不断如此重复，就可以找到元素对应的角标。
    */
   public static int binarySearch(int[] arr,int key)
   {
    //1.定义三个变量，记录头角标，尾角标，中间角标。
    int max,mid,min;
    min=0;
    max=arr.length-1;
    mid=(min+max)>>1;

    while(arr[mid]!=key)
    {
        if(key>arr[mid])
            min=mid+1;
        else if(key<arr[mid])
            max=mid-1;

        //判断元素是否存在。
        if(max<min);
            return -1;//表示没有。

        

    }
    return mid;
   }

   //查找。
   /*
   需求：查找一个元素在数组中的第一次出现的位置。
   */
  public static int searchKey(int[] arr,int key)
  {
    //遍历查找。
    for(int x=0;x<arr.length;x++)
    {
        if(arr[x]==key)
            return x;
    }
    return -1;
  }
}
