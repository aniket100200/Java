import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        int result=maxElement(nums);
        System.out.print(result);
    }

    public static int maxElement(int[] arr)
	{
      //Write your code here
		return f(arr,0,Integer.MIN_VALUE);
    }
	static int f(int[] arr, int start, int Max)
	{
		if(start==arr.length)return Max;
		Max=Math.max(Max,arr[start]);
		return f(arr,start+1,Max);
	}
	
}
