import java.util.*;
public class Main {
    static int array11(int[] nums, int index)
	{
        //Write your code here
		if(index==nums.length)
		{
			return 0;
		}
		if(nums[index]==11)
		{
			return 1+array11(nums,index+1);
		}

		return array11(nums,index+1);
		
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(array11(arr, 0));
    }
}
