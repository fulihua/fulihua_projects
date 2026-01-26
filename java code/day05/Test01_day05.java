package day05;
public class Test01_day05 {
   
 /*
 对一个给定的数组进行反转。
 {23,14,88,5} ->
 {5,88,14,23}
 */
public static void reverse(int[] arr)
{
    for(int start=0,end=arr.length-1;start<end;start++,end--)
    {
        swap(arr,start,end);
    }
    for(int i=0;i<arr.length;i++)
    {
       System.out.print(arr[i]); 
       if(i<arr.length-1)
        System.out.print(",");
    }
}

public static void swap(int[] arr,int a,int b)
{
    int temp = arr[a];
    arr[a]=arr[b];
    arr[b]=temp;
}
public static void main (String[] args)
{
    int[] arr={23,14,88,5};
    reverse(arr);

}
}



