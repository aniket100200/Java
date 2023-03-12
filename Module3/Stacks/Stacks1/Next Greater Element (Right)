import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
		//this one is more important.... okay.
        //let's create... stack
		Stack<Integer> st=new Stack();
		long[] ngre=new long[n];
		for(int i=0;i<n;i++)
		{
			long ele=arr[i];
			//here means.. 
			while(st.size()>0 && ele>arr[st.peek()])
			{
				int index=st.peek();
				st.pop();
				ngre[index]=ele;
			}
			///curr elem ko kr do push..
			st.push(i);
		}

		while(st.size()>0)
		{
			int idx=st.pop();
			ngre[idx]=-1;
		}
		return ngre;
		
		
		/*/Write code here and print output
		Stack<Long> st=new Stack<>();
		long[] ngre=new long[n];
		for(int i=arr.length-1;i>=0;i--)
		{
			//I'm here means..
			long ele=arr[i];
			//chek element on stak if they are smaller than me .. remove them..
			while(st.size()>0 && st.peek()<=ele)
			{
				st.pop();// this will remove the elements..;
			}
			if(st.isEmpty())
			{
				ngre[i]=-1;
			}
			else
			{
				ngre[i]=st.peek();
			}
			st.push(arr[i]);
		}
		return ngre;
		*/
		
    } 
}
class Main {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}
