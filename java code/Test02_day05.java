public class Test02_day05 {
    /*
思考题：
需求：如果往有序的数组中插入一个元素并继续保证有序，问如何获取该位置？
思路：
1.既然是有序的数组，而且是查找位置，必须要想到二分查找法。

*/

 public static void main(String[] args)
 {
    int key=0;
    int[] arr = {9,13,17,22,31,46,58,77};

    int index = binarySearch(arr,7);
    System.out.println("index="+index);
 }   

public static int binarySearch(int[] arr,int key)
{
    int max,min,mid;
    min=0;
    max=arr.length-1;
    while(min<=max)
    {
        mid=(min+max)>>1;//相当于/2,这种做法更快捷，更有效率。
        if(key>arr[mid])
            min=mid+1;
        else if(key<arr[mid])
            max=mid-1;
        else
            return mid;

    }
    return -(1+min);
}
}

