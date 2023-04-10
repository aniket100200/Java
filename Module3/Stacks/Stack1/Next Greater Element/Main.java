/******* O(n2) Solution I can say******/
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    { 
     
		for(int i=0;i<n;i++)
		{
			long x=findNextGreater(arr,i+1,n,arr[i]);
			arr[i]=x;
		}
		return arr;
    } 
	public static long findNextGreater(long[] arr, int from,int to,long ele)
	{
		
		for(int i=from;i<to;i++)
		{
			if(arr[i]>ele)return arr[i];
		}
		return -1;
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
