import java.util.*;

public class Main {

	public static int findFirst(int[] arr, int k,int start, int end)
	{
		//to get first occurece trey to left as left you can...
		int pans=-1;
		while(start<=end)
		{
			//let's find mid first..
			int mid=(start+end)/2;
			if(arr[mid]==k)
			{
				pans=mid;
				//try to move left as left you can..
				end=mid-1;
			}
			else if(arr[mid]>k)
			{			
				//hence I'll have to move towards the left.. of it.. 
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		return pans;
	}
    public static void findPosition(int a[], int n,int k)
    {
        // Write code here
		//let's find the first position first..
		int first=findFirst(a,k,0,n-1);
		int last=findLast(a,k,0,n-1);
		System.out.println(first+" "+last);
    }



	public static int findLast(int[] arr, int k,int start, int end)
	{
		//to get first occurece trey to as rigth as you can
		int pans=-1;
		while(start<=end)
		{
			//let's find mid first..
			int mid=(start+end)/2;
			if(arr[mid]==k)
			{
				pans=mid;
				//try to move left as left you can..
				start=mid+1;
			}
			else if(arr[mid]>k)
			{			
				//hence I'll have to move towards the left.. of it.. 
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		return pans;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}
