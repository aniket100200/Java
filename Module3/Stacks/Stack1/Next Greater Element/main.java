import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
		/**** This is O(N) and with O(n) space use for stacks... ****/
        //Write code here and print output
		//Now it is possible to get in O(N)... using Monotonic Stacks....
		//let's optimise it... using the stack we'll use the power of the Stack... itself...
		Stack<Integer> st=new Stack<>();
		for(int i=0;i<n;i++)
		{
			long ele=arr[i];
			while(st.size()> 0 && ele>arr[st.peek()])
			{
				//It means stack has element and who is looking for his next greater elment...
				//this present element is greter than it is next greater element for this stack elements...
				arr[st.pop()]=ele;
			}
			//as the stack size 0 or ele< peeked element of the stack
			//this present element will look for next greater element....
			st.push(i);
		}

		while(st.size()>0)
		{
			arr[st.pop()]=-1;
		}
		return arr;
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
