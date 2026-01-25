public class Array2Demo2_day05 {
    public static void main(String[] args)
    {
        /*
        二维数组的另一种定义方式。
        */
       int[][] arr={{23,17,11},{88,11,33,90},{11,78,34}};
        
       //求和。
       int sum=0;
       for(int x=0;x<arr.length;x++)
       {
        for(int y=0;y<arr[x].length;y++)
        {
        sum=sum+arr[x][y];
        }
       }

       System.out.println("sum="+sum);
    }
}
