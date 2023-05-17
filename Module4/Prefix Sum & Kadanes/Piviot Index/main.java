import java.util.*;

class Solution {
    public int pivotIndex(int[] nums) {
        //Write code here
		int n=nums.length;
		for(int i=1;i<n;i++)
		{
			nums[i]+=nums[i-1];
		}
		for(int i=0;i<n-1;i++)
		{
			if(i==0)
			{
				int left=0;
				int right=nums[n-1]-nums[i];
				if(left==right)return i;
			}
			else
			{
				int left=nums[i-1];
			int right=nums[n-1]-nums[i];
			if(left==right)return i;
			}
		}
		return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}
