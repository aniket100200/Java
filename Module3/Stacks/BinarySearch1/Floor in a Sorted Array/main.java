
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[])
	{
        //your code here
		Scanner sc=new Scanner(System.in);
		int n =sc.nextInt();
		int ele=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		//let's find the floor value ...
		System.out.print(findFloor(arr,ele,0,n-1));
    }

	public static int findFloor(int[] arr, int b, int s,int e)
	{
		//let's have the potential answer...
		 
		int pans=-1;

		//as you want to get floor value you'll have 
		//travel towards the right rather than left..
		while(s<=e)
		{
			
			//let's find the mid
			int mid=(s+e)/2;
			if(arr[mid]==b)
			{
				return mid;
			}
			else if(arr[mid]>b)
			{
				
				
				e=mid-1;
			}
			else
			{
				//this will give you the floor value...
				pans=mid;
				s=mid+1;
				
			}
			
		}
		return pans;
		
	}
}
