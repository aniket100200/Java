import java.io.*;
import java.util.*;
import java.lang.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        String inputLine[] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(inputLine[0]);

		int start[] = new int[n];
		int end[] = new int[n];

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++)
			start[i] = Integer.parseInt(inputLine[i]);

		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) 
			end[i] = Integer.parseInt(inputLine[i]);
			
		int ans = new Solution().maxMeetings(start, end, n);
		System.out.println(ans);
    }
}

class Solution 
{
    public int maxMeetings(int start[], int end[], int n) 
    {
        //Write code here
		int[][]meet=new int[n][2];
		for(int i=0;i<n;i++)
		{
			meet[i][0]=start[i];
			meet[i][1]=end[i];
		}
		//let's say I'm greedy here we go...
		Arrays.sort(meet,(a,b)->{
			return a[0]-b[0];
		});

		//easy problem.. here we go..
		int sp=-1;
		int ep=-1;
		int count=0;
		for(int i=0;i<n;i++)
		{
			int csp=meet[i][0];
			int cep=meet[i][1];
			if(csp>ep)
			{
				count++;
				sp=csp;
				ep=cep;
			}
			else
			{
				//means overlap.. we have to choose the interval..
				if(cep<ep)
				{
					sp=csp;
					ep=cep;
				}
			}
		}
		return count;
		
    }
}
