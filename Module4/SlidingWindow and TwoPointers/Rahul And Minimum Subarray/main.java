import java.util.*;


class Solution {
    
    public static void minSubArrayLen(int arr[], int target, int n)
	{
        //Write your code here   
		int si=0;
		int ei=0;
		int sum=0;
		int length=Integer.MAX_VALUE;
		while(ei<n)
		{
			//introduce a new person...
			sum+=arr[ei];
			//let's contract the window..
			while(si<=ei && sum>target)
			{
				length=Math.min(length,ei-si+1);
				sum-=arr[si++];
			}
			//let's calculate the answer..

			//let's expand the window..
			ei++;			
		}
	if(length==Integer.MAX_VALUE)System.out.println(0);
		else System.out.println(length);

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Solution.minSubArrayLen(arr,target,n);
        
    }
}
