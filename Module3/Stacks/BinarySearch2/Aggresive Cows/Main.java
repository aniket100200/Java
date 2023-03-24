import java.io.*;
import java.util.*;
import java.util.*;

class Solution
{
	
    public static int aggressiveCows(int arr[],int cows)
	{
		Arrays.sort(arr);
       //Write your code here
		int n=arr.length;
		//let's decide the range..
		//if you have a cow at every positioon it will give min or low rnage..
		int si=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-1;i++)
		{
			si=Math.min(arr[i+1]-arr[i],si);
		}

		//if you have two cows... then what will be the max distatnce.. diff of first and last cow index..
		int ei=arr[arr.length-1]-arr[0];
		int pans=-1;
		while(si<=ei)
		{
			int mid=(si+ei)>>1;//right shift.. one time makes it half...
			if(isPossible(arr,mid,cows))
			{
				//if it is possible then try to increase the distance.. will have to move towards the right...
				pans=mid;
				si=mid+1;
			}
			else
			{
				//else you'll have to move towards the left side... here we go...............
			ei=mid-1;	
			}
		}
		return pans;
    }

	public static boolean isPossible(int[] arr,int min,int cows)
	{
		int numberOfCows=1;
		int posOfLastCow=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]-posOfLastCow>=min)
			{
				numberOfCows++;
				posOfLastCow=arr[i];
			}
		}
		return numberOfCows>=cows;
		
	}


}

class Main {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));

    }
}
