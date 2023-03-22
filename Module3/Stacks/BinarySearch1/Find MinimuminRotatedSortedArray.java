// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int arr[], int low, int high)
    {
      //let's do it using Binary search...
		
		while(low<=high)
		{
			//let's find the mid..
			int mid=(low+high)/2;
			//in rotated array can se decreament at certain point..
			if(arr[mid]<arr[mid-1])
			{
				return arr[mid];
			}
			else if(arr[mid]>arr[mid+1])
			{
				return arr[mid+1];
			}
			else
			{
				//let's find the unsorted region...
				if(arr[low]<=arr[mid])
				{
					// means it is sorted.. regio.. move towards the right...
					low=mid+1;
				}
				else
				{
					high=mid-1;
				}
			}
			
		}
		return -1;
    }
}
class Main {
    
 
    // Driver Program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}
