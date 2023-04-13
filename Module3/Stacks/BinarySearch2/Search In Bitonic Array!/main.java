
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException 
	{
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
    
    static int findElement(int arr[], int n,int target)
    {
        // your code here
		//let's use binary SEarch...
		int si=0;
		int ei=n-1;
		while(si<=ei)
		{
			int mid=(si+ei)>>1;
			if(arr[mid]==target)
			{
				return mid;
			}
			else if(arr[0]<=arr[mid])
			{
				//left region is sorted..
				if(arr[0]<=target && arr[mid]>=target)
				{
					ei=mid-1;
				}
				else
				{
					si=mid+1;
				}
			}
			else
			{
				//right region is sorted..
				if(target>=arr[n-1] && arr[mid]>=target)
				{
					si=mid+1;
				}
				else
				{
					ei=mid-1;
				}
			}
		}
		return -1;

    }
}
