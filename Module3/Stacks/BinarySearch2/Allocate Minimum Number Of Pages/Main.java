import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public boolean isPossible(int[] arr,int B,long cap)
	{
		
		int NumberOfStudent=1;
		long NumberOfPages=0;
		for(int pages: arr)
		{
			
			if(NumberOfPages+pages<=cap)
			{
				NumberOfPages+=pages;
			}
			else{
				NumberOfStudent++;
				NumberOfPages=pages;
			}
		}
		return NumberOfStudent<=B;
	}
    public long MinimumPages(int[] arr, int B)
	{
		if(arr.length<B)
		{
			return -1;
		}
	/***type : Bs .. i.e Binary Search Over the Problem ***/
       
		//let's find the range of the pages... 
		
	/* Range will be from Maximum El*/
		/* lower range .. 
		f there are n --> no.of students  && n---->no.of  students
		each student will get Single...>>>>><<<<
		  Pick Maximum... which will be lower limit...
		*/

		/*
		Higer Range---->>>> <<<<------
		will decide-----<<>>
		if there is single student and you can only allot all the books..
	  Sum of all will be the Maximum Range...
	  */
	/* let's calculate higher and lower limit */
		long low=0;
		long up=0;
		for(int i=0;i<arr.length;i++)
		{
			low=Math.max(low,arr[i]);
			up+=arr[i];
		}
		//the above process will take O(n) time...
		//so I've lower upper...limit's..
		//let's apply binary search... here we go..
		long pans=-1;
		while(low<=up)
		{
			//let's find the mid...
			long mid=(low+up)/2;
			if(isPossible(arr,B,mid))
			{
				pans=mid;
				//let's find some smaller people...
				up=mid-1;
			}
			else 
			{
				low=mid+1;
			}
		}
		return pans;
    }
}

class Main
	{
		
    public static void main (String[] args) 
		{
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}
