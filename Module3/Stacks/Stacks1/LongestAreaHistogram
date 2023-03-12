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
{
      public static long maximumArea(long hist[], long n)
	{

		//let's first find.. next smaller element to right..
	/************************************/
		//need a stack
		Stack<Integer> st=new Stack();
		long max=Long.MIN_VALUE;
		for(int i=0;i<(int)n;i++)
		{
			long ele=hist[i]; 
			//I've current element can be the next Smallest..
			//for next right...
			while(st.size()>0 && ele<hist[st.peek()])
			{
				//I'm here meanss.. present elment is a limit.. for the element present in the stack..
				//towards right.. that is present index..
					int index=st.pop(); 
					int rb=i;
					int lb=-1;
				if(st.size()>0)
				{
					//the present index or element in the stack is less than that of previous element present 
					//int the stack...
					lb=st.peek();
				}

				int width=rb-lb-1;
				long heigth=hist[index];
				max=Math.max(max,heigth*width);
				
			}
			//I'll push element into the stack...

			st.push(i);
		}

		//here means if I've elements in the stack...

		while(st.size()>0)
		{
			//here means.. I've elements in the stack who's nextSmallerElementToTheRight Unable to find..
			//
			int index=st.pop();
			int rb=(int)n;
			int lb=-1;
			if(st.size()>0)
			{
				lb=st.peek();
			}
				int width=rb-lb-1;
				long heigth=hist[index];
				max=Math.max(max,heigth*width);
				
		}
		return max;///.......

							/*The End Climax..*/
	
	}
}



