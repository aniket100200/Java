import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long solve(int[] arr, int B)
	{
        //Write your code here  
		
		
		//let's fidn the min range...
	long  si=0;
		//if you Have n number of day's and and n number of pakages...
		//during this the maxPack you'll take in these day's it will be min cap...
	long  ei=0;
		for(int pack: arr)
		{
			si=Math.max(si,pack);
			ei+=pack;
		}

		//as you have to find upperlimit.. that ship can hold...
		//if you have to shit all the packages in single day... it will your max>>>lim...

		//let's apply binary search...
		long pans=-1;
		while(si<=ei)
		{
			long  limit=si+(ei-si)/2;
			if(isPossible(arr,limit,B))
			{
				//if it is possible to shift n---> packages in B day's With the limit at once...
				//limit.. then it will be your potential answer...
				pans=limit;
				//then try to decrease the limit...
				ei=limit-1;
			}
			else
			{
				//if it is not possible then increase the limit..
				si=limit+1;
			}
		}
		return pans;
    }
	public static boolean isPossible(int[] packages, long limit, int days)
	{
		//let's try to find... if it is possible or not...
		int numberOfDays=1;
		long  weight=0;
		for(int w: packages)
		{
			if(w+weight<=limit)
			{
				weight+=w;
			}
			else
			{
				numberOfDays++;
				weight=w;
			}
		}
		return numberOfDays<=days;
	}
}

class Main 
{
	public static void main (String[] args)
	{
                Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
        	int[] A = new int[n];
        	for(int i=0;i<n;i++)
		{
                        A[i] = sc.nextInt();
		}
        int B = sc.nextInt();
        System.out.println(Solution.solve(A,B));
	}
}
