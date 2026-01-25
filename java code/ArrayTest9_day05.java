public class ArrayTest9_day05 {
    public static void main(String[] args)
    {
        int[] arr={12,9,23,77,6,34};

        printArray(arr);
		//selectSort(arr);
//		bubbleSort(arr);
//		Arrays.sort(arr);//开发时用这个。
		printArray(arr);
    }

//打印数组的方法。
public static void printArray(int[]arr)
{
    for(int x=0;x<arr.length;x++)
    {
        if(x!=arr.length-1)
            System.out.println(arr[x]+",");
        else
            System.out.println(arr[x]);
    }
}

/*
数组的排序。
选择排序。
*/
public static void selectSort(int[] arr)
{
    for(int x=0;x<arr.length-1;x++)
    {
        for(int y=x+1;y<arr.length;y++)
        {
            if(arr[x]>arr[y])
            {
 //               int temp=arr[x];
 //               arr[x]=arr[y];
 //               arr[y]=temp;
                swap(arr,x,y);
            }
        }
    }
}

/*
冒泡排序：
*/
public static void bubbleSort(int[] arr)
{
    for(int x=0;x<arr.length-1;x++)
    {
        for(int y=0;y<arr.length-1-x;y++)
        {
            if(arr[x]>arr[y])
            {
                swap(arr,y,y+1);
            }
        }
    }
}

//发现排序方法，位置置换代码重复，进行抽取。
public static void swap(int[] arr,int a,int b)
{

                int temp=arr[a];
                arr[a]=arr[b];
                arr[b]=temp;
}
}

