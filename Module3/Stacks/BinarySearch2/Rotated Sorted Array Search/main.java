import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int N = sc.nextInt();
	  int[] A = new int[N];
	  for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
      }
	  int B = sc.nextInt();
	  Solution ob = new Solution();
    System.out.println(ob.search(A,B));
		
	}
}

class Solution{
    public int search(final int[] arr, int target)
	{
		/**** Tc: o(logn) && Sc: O(1) ******/
        //Write code here
		//let's define range...
		int start=0;
		int end=arr.length-1;

		//let's search...
		while(start<=end)
		{			
			//let's find the mid one..
			int mid=(start+end)/2;
			if(arr[mid]==target)
			{
				return mid;
			}
			else if(arr[start]<=arr[mid])
			{
				//you'll come here if  your left region is sorted...
				if(arr[start]<=target && target<=arr[mid])
				{
					//if your element is in sorted region... 
					//move to left..
					end=mid-1;
				}
				else
				{
					//move to unsorted regio...
					start=mid+1;
				}
			}
			else
			{
				//right region is sorted...
				if(arr[mid]<=target && target<=arr[end])
				{
					//your target is in soreted region... 
					//sor move towards right..
					start=mid+1;
				}
				else
				{
					//move to the unsorted region..
					end=mid-1;
				}
			}
		}
		return -1;
    }
}
