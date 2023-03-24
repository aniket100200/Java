import java.util.*;
import java.io.*;
class Solution
{
    public static int solve(int n,int m,int arr[])
    {
      //let's decide the range for the solution....
		//single bac can hold at least --> 1 balll..
		int si=1;

		//a single bag can hold at Most----> max holded by the bag in 
		//in the array..
		int ei=0;
		for(int balls: arr)
		{
			ei=Math.max(ei,balls);
		}
		int pans=-1;

		//let's use binary search..
		while(si<=ei)
		{
			int mid=(si+ei)>>1;
			if(isPossible(arr,mid,m))
			{
				//if it is possible to convert all the bags into penalty of mid.... where
				//penalty will be the max--- a bag can hold...
				pans=mid;
				//let's try to reduce the penalty...
				ei=mid-1;
			}
			else
			{
				si=mid+1;
			}
		}
	return pans;	
    }

	public static boolean isPossible(int bags[], int penalty, int operations)
	{
		int numOfOper=0;
		for(int balls: bags)
		{
			if(balls%penalty==0)
			{
				numOfOper+=((balls/penalty)-1);
			}
			else
			{
				numOfOper+=(balls/penalty);
			}
		}
	return	numOfOper<=operations;
	}
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}
