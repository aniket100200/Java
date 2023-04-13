import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	  public static void main(String[] args) throws Throwable {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();

	        int nums[]=new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            nums[i] = sc.nextInt();
	        }
	        Solution obj = new Solution();
	        long ans[] = obj.ProductOfArrayExceptSelf(n,nums);
	        for(int i=0; i<n ; i++){
	            System.out.print(ans[i] + " ");
	        }
	    }
}
class Solution{
  public long[] ProductOfArrayExceptSelf(int n, int[] a)
{
        long ans=1;
		for(int i: a)
		{
			ans*=i;
		}
	//I've overall product of the array...
	long[] ret=new long[n];
	for(int i=0;i<n;i++)
	{
		ret[i]=ans/a[i];
	}
	return ret;
	
}
}
