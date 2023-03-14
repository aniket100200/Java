import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] prevGreater(long[] arr, int n)
    { 
        //Write code here and print output  
		//need a stack..
		Stack<Integer> st=new Stack<>();
		long[] pgr=new long[n];
		for(int i=n-1;i>=0;i--)
		{
			//here means..
			//need to find the greatest element to the left.. of the pre element..
			long ele=arr[i];
			while(st.size()>0 && ele>arr[st.peek()])
			{
				int idx=st.pop();//st.peek();...
				pgr[idx]=ele;
			}
			st.push(i);
		}
		while(st.size()>0)
		{
			pgr[st.pop()]=-1;
		}
		return pgr;
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().prevGreater(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}
