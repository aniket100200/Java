import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int tar) {
        //Write code here
		
		//This is the problem of Sliding window...
		//here we go..
		int i=0;
		int j=0;
		int ans=0;
		int curr=1;
		
		while(j<nums.length)
		{
			//step 1:Introduce a new person... in the window..
			curr*=nums[j];
			//Step 2: Shrink your window until it fails... 
			while(i<=j&&curr>=tar)
			{
				curr/=nums[i];
				i++;
			}

			//setp 3: calculate and count the answer here we go.,..,.,,..,.,.,.,
			ans+=j-i+1;

			//let's expan the window;
			j++;			
		}
		return ans;
		
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
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}
