import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			    int n = Integer.parseInt(br.readLine().trim());
			    String inputLine[] = br.readLine().trim().split(" ");
			    int[] nums = new int[n];
			    for(int i=0; i<n; i++)nums[i]=Integer.parseInt(inputLine[i]);
			    int[] res = new Solution().nextLarger2(nums, n);
			    for (int i = 0; i < n; i++) 
			        System.out.print(res[i] + " ");
			    System.out.println();
		}
}
class Solution{
  
	public static int[] nextLarger2(int[] nums, int n)
    { 
		//your code here
		//let's find the next greater element..
		int[]nger=new int[n];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			int ele=nums[i];
			while(st.size()>0 && ele>nums[st.peek()])
			{
				int idx=st.pop();
				nger[idx]=ele;
			}
			//you'll have add itself..
			st.push(i);
		}

		//we'll run a loop for 2nd time..
		for(int i=0;i<n;i++)
		{
			int ele=nums[i];
			while(st.size()>0 && ele>nums[st.peek()])
			{
				int idx=st.pop();
				nger[idx]=ele;
			}
		}
		while(st.size()>0)
		{
			int idx=st.pop();
			nger[idx]=-1;
		}
		return nger;
	}
}
