import java.io.*;
import java.util.*;

class Solution {
    public int findElement(int[] arr, int n) 
	{
		if(n==1)return 0;
		int count=0;
		int prev=arr[0];
		for(int i: arr)
		{
			if(i!=prev)break;
			count++;
		}
		if(count==n)return -1;	
		int ngeri[]=nextGreater(arr,n);
		int nseli[]=nextSmaller(arr,n);
		//System.out.print(Arrays.toString(ngeri)+"\n"+Arrays.toString(nseli));
		//next smallest
		int pans=-1;
		for(int i=1;i<n;i++)
		{
			if(ngeri[i]==n && nseli[i]==-1)pans=i;
		}
		return pans;
		
    }
	public int[] nextGreater(int[] arr,int n)
	{
		int [] brr=new int[n];
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			int ele=arr[i];
			while(st.size()>0 && arr[st.peek()]>ele)
			{
				brr[st.pop()]=i;
			}
			st.push(i);
		}

		while(st.size()>0)brr[st.pop()]=n;
		return brr;
	}

		public int[] nextSmaller(int[] arr,int n)
	{
		int [] brr=new int[n];
		Stack<Integer> st=new Stack<>();
		
		for(int i=n-1;i>=0;i--)
		{
			int ele=arr[i];
			while(st.size()>0 && arr[st.peek()]<ele)
			{
				brr[st.pop()]=i;
			}
			st.push(i);
		}

		while(st.size()>0)brr[st.pop()]=-1;
		return brr;
	}
}

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

        Solution Obj = new Solution(); 
		System.out.println(Obj.findElement(nums, n));
	}
}
