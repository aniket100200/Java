import java.io.*;
import java.util.*;

class Solution 
{
    public void TappingWater(int[] arr, int n)
	{
		//let's try using TwoPointers approach...
		int lb=arr[0];
		int rb=arr[arr.length-1];

		//let's have two pointers.. staring on 1st index...
		//
		int l=1;
		int r=n-2;

		int totalWater=0;
		while(l<=r)
		{
			if(lb<=rb)
			{
				//this measn for present element left is smaller..
				if(arr[l]<lb)
				{
					int heightOfWater=lb-arr[l];
					totalWater+=heightOfWater*1;
				}
				else
				{
					lb=arr[l];
				}
				l++;
				
			}
			else
			{
				//this means right boundary is less.. or limiting..

				if(arr[r]<rb)
				{
					int heightOfWater=rb-arr[r];
					totalWater+=heightOfWater*1;
				}
				else
				{
					// agar present element bda hai toh..
					//this will the rigth boundary...
					rb=arr[r];
				}
				r--;				
			}
		}
		System.out.println(totalWater);
    }
}       

public class Main 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}
