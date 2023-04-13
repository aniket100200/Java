import java.util.*;

class Solution {
        public int[] sumQuery(int[] arr, int[][] ranges)
	{
        /* let's try to do it constant time
		*it will take linear time or Tc: O(n);
		* but you can solve you're all queries in linear time
		*/
		//we'll use Prefix sum method...

		//let's make prefix sum array...
		int[] pref=new int[arr.length];
		pref[0]=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			pref[i]=arr[i]+pref[i-1];		
		}
		//we have successfull make prefix sum array...

		//let's solve queries...
		int[] ansToEachQuery=new int[ranges.length];
		int i=0;
		for(int[] a: ranges)
		{
			int si=a[0];
			int ei=a[1];
			ansToEachQuery[i++]=solve(pref,si,ei);			
		}
		return ansToEachQuery;		
    }

	static int solve(int[] pref,int si,int ei)
	{
		if(si==0)return pref[ei];
		return pref[ei]-pref[si-1];
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
