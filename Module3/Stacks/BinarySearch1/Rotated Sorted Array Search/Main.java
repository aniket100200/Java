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

class Solution {
    int find(int[] arr, int tar,int start,int end)
	{
		int index=-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(arr[mid]==tar)
			{
				return mid;
			}
			else if(arr[mid]>tar)
			{
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		return -1;
	}
    public int search(final int[] arr, int target)
	{

		//lets' search in rotated soretd array...
		//lets' decide search space...
		//let's first find the piviot element..

		int piv=0;
		int start=0;
		int end=arr.length-1;

		while(start<=end)
		{
			//let's find the piviot..
			// first find the mid
			 int mid=(start+end)/2;
			if(mid>0 && arr[mid]<arr[mid-1])
			{
				piv=mid;
				break;
			}
			else if(mid<arr.length-1 && arr[mid]>arr[mid+1])
			{
				piv=mid+1;
				break;
			}
			else
			{
				//you have to move towards the unsoretdresio...
				if(arr[start]<=arr[mid])
				{
					//let's move towards the right ...
					start=mid+1;
				}
				else
				{
					end=mid-1;
				}
			}
		}
		

		int x=find(arr,target,0,piv-1);
		int y=find(arr,target,piv,arr.length-1);
		if(x==-1 && y==-1)
		{
			return -1;
		}
		else if(x>y)
		{
			return x;
		}
		else
		{
			return y;
		}
    }
    }
