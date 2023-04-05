
import java.util.*;
import java.io.*;

class Solution{
	static void quickSort(int[] arr)
	{
        //Write code here
		// arr..
		//starting index..
		//ending index..
		qs(arr,0,arr.length-1);
    }
	static void qs(int[] arr,int start,int end)
	{
		if(start<end)
		{
			//need to find Partion Index.. 
			//here you are..
			int pi=Partition(arr,start,end);
			qs(arr,start,pi-1);
			qs(arr,pi+1,end);
		}
	}

	static int  Partition(int[] arr,int start, int end)
	{
		//Let's take end index as a Partion...
		int pivot=arr[end];
		int i=start;
		for(int j=start;j<end;j++)
		{
			//if my present element is less than pivot element..
			//it will lie on left side of the pivot..
			if(arr[j]<=pivot)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
				i++;				
			}
		}
		
		arr[end]=arr[i];
		
		arr[i]=pivot;
		
		return i;
	}
}

public class Main 
{
    public static void main(String args[])
	{
        Scanner sc = new Scanner(System.in);
		int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
		Obj.quickSort(arr);
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        sc.close();
    }
}
