
/***** this is 
*O(N) Time Complexity...
*O(n) space complexity
*but you have to meake two calls here...
* can you do better.....
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{	public static long maximumArea(long hist[], long n)
	{
	//Your code here   
		int m=(int)n;
		//this can be solve using monotonic stacks... here we go...
		//area means height into width.... 
		Stack<Integer> st=new Stack<>();
		long max=Long.MIN_VALUE;
		//as I'll look for the next smaller element to right... there will elment's in increasign order 
		//in the stack...<<><><>><<>><<><>><><><><><>>
		
		// 1)find next smaller element..
		// 	2)find previous smaller element
		int[] nseri=next(hist,(int)n);
		int[] nseli=left(hist,(int)n);

		//so I've the next smaller element and 
	
		for(int i=0;i<m;i++)
		{
			int width=nseri[i]-nseli[i]-1;
			long height=hist[i];
			max=Math.max(width*height,max);
		}
		return max;
		
    }
static int[] next(long[] arr,int n)
{
	int[]a=new int[n];
	Stack<Integer> st=new Stack<>();
	for(int i=0;i<n;i++)
		{
			long ele=arr[i];
			while(st.size()>0 && arr[st.peek()]>ele)
			{
				a[st.pop()]=i;
			}
			st.push(i);
		}
	while(st.size()>0)
	{
		a[st.pop()]=n;
	}
	return a;
}
 static int[] left(long[] arr,int n)
{
	int[] a=new int[n];
	Stack<Integer> st=new Stack<>();
	for(int i=n-1;i>=0;i--)
		{
			long ele=arr[i];
			while(st.size()>0 && arr[st.peek()]>ele)
			{
				a[st.pop()]=i;
			}
			st.push(i);
		}
	while(st.size()>0)
	{
		a[st.pop()]=-1;
	}
	return a;
}
}



