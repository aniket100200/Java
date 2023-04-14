/*** this is know as Kadanes Algorithmmmm***/ //we'll do the max_subarraySum in O(N) Tc.... //O(1) space...
import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n)
	{
        //Write code here
		/*** this Algorithm is know as kadane algorithm ****/
		int train=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			int prev=train+a[i];
			int newTrain=a[i];
			if(prev>newTrain)
			{
				train=prev;
			}
			else train=newTrain;

			if(train>max)
			{
				max=train;
			}
		}
		return max;
		
    }
}
