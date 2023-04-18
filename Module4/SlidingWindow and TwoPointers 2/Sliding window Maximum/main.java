import java.util.*;

class Solution{
	static void addToDq(LinkedList<Integer> dq,int[] arr,int i)
	{
			while(dq.size()>0 &&arr[i]>arr[dq.getLast()])dq.removeLast();
		dq.addLast(i);
	}
    static int[] SlidingWindowMaximum(int N, int K, int[] arr)
	{
		//let's we'll use our linked list as deque...
		int[]ans=new int[N-K+1];
		LinkedList<Integer> dq=new LinkedList<>();

		//let's addTo dq for the first element...
		for(int i=0;i<K;i++)
		{
			addToDq(dq,arr,i);
		}
		ans[0]=arr[dq.getFirst()];

		int sp=1;
		int ep=K;
		int window=1;
		while(ep<N)
		{
			//add to the dq...
			addToDq(dq,arr,ep);

			//let's remove the element.. which are not in window..
			while(dq.size()>0 && dq.getFirst()<sp)dq.removeFirst();
			ans[window++]=arr[dq.getFirst()];
			sp++;
			ep++;
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
