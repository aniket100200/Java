import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr)
	{
        // write code here
		//let's try to find... using Monotonic Stack... here we go..

		//step1: get Next greateest to right 
		int[] ngeri=new int[N];

		//for monotonic stack need a stack...

		Stack<Integer> st=new Stack<Integer>();

		for(int i=0;i<N;i++)
		{
			int ele=arr[i];//this can be the next greater element to the right of peple present in thestack..

			while(st.size()>0 && ele>arr[st.peek()])
			{
				int index=st.pop();
				ngeri[index]=i;
			}
			//I will look for my next greater element...
			st.push(i);
		}

		//for whom they didn't find their greatest elment to right... 
		//they will have their greatest element size of the arr... i.e..N
		//this is to know the whether the element's boundary lies...

		while(st.size()>0)
		{
			int index=st.pop();
			ngeri[index]=N;
		}

		/*** this all operation will done in O(N) time complexity...****/

		//Now find how many sliding windows will be there ...
		//as the size of the array is N and size of window is k...
		//then N-K+1 windows willl be form...

		int[] ans=new int[N-K+1];

		for(int i=0;i<=N-K;i++)
		{
			int j=i;
			while(ngeri[j]<i+K)//this means it is lies in the present window...
			{
				j=ngeri[j];
			}
			ans[i]=arr[j];
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
