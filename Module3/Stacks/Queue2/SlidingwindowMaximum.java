/**** This Solution has the O(N*K) Time complexity... and O(N) space complexity...*****/
import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr)
	{
        // write code here
		//there will be the N-K+1 windows  of size k..
		int[] ans=new int[N-K+1];
		int k=0;
		for(int i=0;i<=N-K;i++)
		{
			//widow of k size...
			int max=Integer.MIN_VALUE;
			for(int j=i;j<i+K;j++)
			{
				max=Math.max(max,arr[j]);
			}
			ans[k++]=max;
			
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
