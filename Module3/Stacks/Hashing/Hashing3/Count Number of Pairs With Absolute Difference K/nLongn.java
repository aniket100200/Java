import java.io.*;
import java.util.*;

class Solution 
{
    public long pairDifference(int []arr, int n, int k)
	{
		Arrays.sort(arr);
		int count=0;
		for(int i=0;i<n;)
		{
			if(bs(arr[i]-k,arr,i+1,n))
			{
				//System.out.println("arr[i]-k");
				count++;
				int prev=arr[i];
				while(i<n && arr[i]==prev)i++;
				
			}
			else if(bs(arr[i]+k,arr,i+1,n))
			{
				count++;
				//System.out.println(arr[i]+"--"+" ");
				int prev=arr[i];
				while(i<n && arr[i]==prev){i++;};
			}
			else{i++;}
			
		}
		return count;
    }
	public boolean bs(int tar,int[] arr, int si, int n)
	{
		int ei=n-1;
		while(si<=ei)
		{
			int mid=(si+ei)>>1;
			if(arr[mid]==tar)return true;
			else if(arr[mid]<tar) si=mid+1;
			else ei=mid-1;
		}
		return false;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i)
		{
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
