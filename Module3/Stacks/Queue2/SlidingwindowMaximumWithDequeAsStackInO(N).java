import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr)
	{
        // write code here
		int[] ans=new int[N-K+1];
		//with DoubleEnded Queue...
		Deque<Integer> dq=new ArrayDeque<>();
		//Using deque as a stack...

		//how will work Deque as Stack... 
		//i.e using addLast and removeLast... || addfirst and Remove First..

		// I'll need a window number...
		
		int windowNo=0;
		for(int i=0;i<N;i++)
		{
			while(dq.size()>0 && dq.peek()<=i-K)
			{
				dq.removeFirst();
			}
			int ele=arr[i];

			while(dq.size()>0 && ele>arr[dq.getLast()])
			{
				dq.removeLast();
			}
			dq.addLast(i);

			if(i>=K-1)
			{
				ans[windowNo]=arr[dq.peek()];
				windowNo++;
			}
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
