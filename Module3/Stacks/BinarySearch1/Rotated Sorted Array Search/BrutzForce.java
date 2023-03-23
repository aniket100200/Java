/**** Tc: O(logn) Sc: O(1) *****/
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

		int piviot=0;
		int start=0;
		int end=arr.length-1;
		while(start<=end)
		{
			//let's find the min...
			int mid=(start+end)/2;
			//let's find wich is sorted regio.. 
			//to find piviot we have to move towards.. unsoretd
			if(arr[start]<=arr[mid])
			{
				//means left region is sorted..
				//try to move towards the right side..
				if(arr[mid]>arr[mid+1])
				{
					piviot=mid+1;
					break;
				}
				else
				{
					start=mid+1;
				}
			}
			else if(arr[mid]<=arr[end])
			{
				//right one is sorted...
				if(arr[mid-1]>arr[mid])
				{
					piviot=mid;
					break;
				}
				else
				{
					end=mid-1;
				}
			}
		}

		int x=find(arr,target,0,piviot-1);
		int y=find(arr,target,piviot,arr.length-1);
		if(x==-1 && y==-1)
		{
			return -1;
		}
		else if(x>y){
			return x;
		}
		else{
			return y;
		}
    }
}
