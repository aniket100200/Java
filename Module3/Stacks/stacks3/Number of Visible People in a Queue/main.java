import java.io.*;
import java.util.*;


class Main {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int heights[]=new int[n];
        for(int i=0;i<n;i++)
        heights[i]=sc.nextInt();

        Solution ob = new Solution();
        
        int ans[]=ob.solve(heights);
        
        for(int i=0;i<n;i++)
        System.out.print(ans[i]+" ");
        
        System.out.println();
        
	}
}

class Solution {
    public int[] solve(int heights[])
    {
        // your code here
		int[] ans=new int[heights.length];
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<heights.length;i++)
		{
			while(st.size()>0 && heights[st.peek()]<=heights[i])
			{
				ans[st.pop()]++;
			}

			if(st.size()>0)ans[st.peek()]++;
			st.push(i);
		}
		return ans;
        
    }

}
