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
	public static int[] nextSmallestElementToRight(long[] arr)
	{
		//lets' create a stack...
		Stack<Integer> st=new Stack<>();

		//people inside the stack will look for then next smallere element to the left of thenm..

		int[] nseri=new int[arr.length];

		//people inside the stack will look for their next smaller element to right..

		for(int i=0;i<arr.length;i++)
		{
			long ele=arr[i];
			while(st.size()>0 && ele<arr[st.peek()])
			{
				nseri[st.pop()]=i;
			}

			st.push(i);
		}

		//then if there are people inside the stack so they don't have their next smaller element ...
		//it'll be -1;

		while(st.size()>0)
		{
			nseri[st.pop()]=arr.length;
		}
		return nseri;
		
	}

      public static long maximumArea(long hist[], long n)
	{
			//need first nextSmallestElementToLeft...
		int[] nseli=nextSmallestElementToLeftInteger(hist);

		//need nextSmallestElementToRight

		int[] nseri=nextSmallestElementToRight(hist);
		
	//so bro... I have.. bothe the array... so go..
long max=Long.MIN_VALUE;
		for(int i=0;i<(int)n;i++)
		{
			//to find area  i should havae the width and height tooo

			long width=nseri[i]-nseli[i]-1;
			long heigth=hist[i];
			max=Math.max(max,width*heigth);
		}
		return max;
	}


	public static int[] nextSmallestElementToLeftInteger(long[] arr)
	{

		//first need stack.... 

		Stack<Integer> st=new Stack();

	//need a array will return the next smallere element indexwise...

		int[] nseli=new int[arr.length];

		//Log jo stack ke andar rhenge o left side me dekhenge.. chote wale elment ko..
		//people inside the stack will look for the next smallere elment to the left...
		//so will go... from right to left...

		for(int i=arr.length-1;i>=0;i--)
		{
			//preseent element may be next smaller element for the people inside the stack..
			long ele=arr[i];
			//let's chek..

			while(st.size()>0 && ele<arr[st.peek()])
			{
				//lets' pop that index and insert present inedex inside the arre on the popped position..

				int idx=st.peek();
				nseli[idx]=i;
				st.pop();						
			}
			st.push(i);
			
		}

		//agar merepas still elements hai stack me toh... unko.. remove kro unki jagh.. 
		//arr.length dal do..
		while(st.size()>0)
		{
			int ind=st.pop();
			nseli[ind]=-1;
		}
		return  nseli;
	}
	
}



