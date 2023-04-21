/*** O(N) Solutin with O(n) Space Complexity****/
import java.util.*;

class Solution {

    public int solve(int nums[],int n) 
	{
        // Your code here
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)if(st.isEmpty() || nums[i]<nums[st.peek()]) 
			st.push(i);

		int ans=0;
		for(int i=n-1;i>=0;i-=1)
	{
		while(st.size()>0 && nums[i]>=nums[st.peek()])
		{
			ans=Math.max(ans,i-st.pop());
		}
			}
return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}
