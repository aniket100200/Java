import java.util.*;
import java.io.*;

class Solution {
static void mergeSort(int[] arr,int l,int r)
	{
     // Your code here
		if(l>=r){
			return;
		}
		
		{int mid=(l+r)/2;
		mergeSort(arr,l,mid);
		
		mergeSort(arr,mid+1,r);
		
		merge(arr,l,mid,r);
		}
        }
	static void merge(int[] a,int l,int mid, int r)
	{
		//I'have two sorted array ... here we you go...
		int[] b=new int[r-l+1];
		int  i=l;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=r)
		{
			if(a[i]<=a[j])
			{
				b[k++]=a[i++];
			}
			else
			{
				b[k++]=a[j++];
			}
		}

		while(i<=mid)
		{
			b[k++]=a[i++];
		}
		while(j<=r)
		{
			b[k++]=a[j++];
		}

		///now copy the arrray
		k=0;
		i=l;
		while(i<=r)
		{
			a[i++]=b[k++];
		}
		return;
	}
}
public class Main {
    public static void main(String args[]) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] a=new int[n];
        for(int i= 0; i < n; i++)
            a[i] = input.nextInt();
        Solution Obj = new Solution();
        Obj.mergeSort(a,0,n-1);
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
    }
}
