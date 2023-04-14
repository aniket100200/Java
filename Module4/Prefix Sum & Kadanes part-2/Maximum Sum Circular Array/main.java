import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n)
	{
        // Write your code here
		//int this we've four case
			/* case1: all elements are positive--- ans total sum of array..
			*case 2: if all elements are negative-- ans greatest element or subarray of length 1
			*case 3: if ans is present in array itself .... we'll do it
			*case 4: if ans is present on two side except some contgeous peopel.. which makes it smaller
			*/
		int total=0;
		int maxSubArraySum=Integer.MIN_VALUE;
		int minSubArraySum=Integer.MAX_VALUE;
		int maxTrain=0;
		int minTrain=0;
		for(int i:arr)
		{
			total+=i;
			//for maximum subarray... sum
			int prevMax=maxTrain+i;
			int newMaxTrain=i;
			maxTrain=Math.max(prevMax,newMaxTrain);
			maxSubArraySum=Math.max(maxSubArraySum,maxTrain);

			//let's do it for minSubarray train...
			int prevMin=minTrain+i;
			int newMinTrain=i;
			minTrain=Math.min(prevMin,newMinTrain);
			minSubArraySum=Math.min(minSubArraySum,minTrain);			
		}
		if(total==maxSubArraySum)return total;

		if(total==minSubArraySum)return total;
		int itself=maxSubArraySum;
		int wrapAround=total-minSubArraySum;

		return Math.max(itself,wrapAround);

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}
