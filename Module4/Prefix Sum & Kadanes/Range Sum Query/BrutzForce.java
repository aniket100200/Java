//* in this method you'll take linear time to find the sum got it...
import java.util.*;

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges)
	{
				/*
				* TC:- n*m
				*where n--> length of arr
				* m- no.of queries....
				*/
            // Your code here.
		int[] ans=new int[ranges.length];
		int i=0;
		for(int[] a:ranges)
		{
			int si=a[0];
			int ei=a[1];
			int sum=0;
			while(si<=ei)
			{
				sum+=arr[si++];
			}
			ans[i++]=sum;
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
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}
