public class Array2Demo_day05 {
    /*
    数组。

int[][] arr=new int[3][2];

        System.out.println(arr);// [[I@e6f7d2//二维数组实体。
		System.out.println(arr[0]);//[I@3e0ebb//一维数组实体。
		System.out.println(arr[0][0]);//0 一维数组中的元素。
		*/
		//
    int[][] array=new int[3][];//明确了二维数组的长度。没有明确具体的一维数组。
    System.out.println(array);//[[I@3e0ebb
	System.out.println(array[0]);//null
	System.out.println(array[0][0]);//NullPointerException

}

