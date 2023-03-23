/****** WithExtraEdgeCase *****/

import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] arr)
	{
       // Your code here.
		//let's have a search space...
		int n=arr.length;
		int start=0;
		int end=n-1;
		if(n==1)
		{
			return 0;
		}
		
		while(start<=end)
		{
			//let's find the mid..
			int mid=(start+end)/2;
			if(mid==n-1)
			{
				//this is one of the edge case.... if you increasign sorted 
				//array right andgled triangle..
				if(arr[mid]>arr[mid-1])
				{
					return mid;
				}
				else
				{
					//move towards the left part...;
					end=mid-1;
				}
			}
			else if(mid==0)
			{
				if(arr[mid]>arr[mid+1])
				{
					return mid;
				}
				else
				{
					//move towards the right... part..
					start=mid+1;
				}
			}
			else
			{
				if(arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1])
			{
				//if it is peak...
				return mid;
			}
			else if(arr[mid]>=arr[mid-1])
			{
				/*means it is in increaseing order 
				means you are  at left side of the mountain..
				so to find peek you have to move..
				towards the right...
				*/

				start=mid+1;
			}
			else
			{
				//means your in right part of the array 
				//let's go towards the peek ... means move 
				//toward the left...
				end=mid-1;
			}
			}
		}
		return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
