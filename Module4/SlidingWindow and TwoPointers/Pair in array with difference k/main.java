import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
	
    public int findPairs(int[] arr,int n, int k)
	{
        //Write code here
		HashSet<Integer> hs=new HashSet<>();
		Arrays.sort(arr);
		int count=0;
		for(int i=0;i<n;i++)
		{
			int tar=arr[i]-k;
			if(isFound(arr,tar,i-1))
			{
				hs.add(arr[i]);
			}
		}
		return hs.size();
    }
	public boolean isFound(int[] arr, int tar,int j)
	{
		int i=0;		
		while(i<=j)
		{
			int mid=(i+j)>>1;
			if(arr[mid]==tar)return true;
			else if(arr[mid]<tar)i=mid+1;
			else j=mid-1;
		}
		return false;
	}
}
