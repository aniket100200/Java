import java.io.*;
import java.util.*;

class Solution{
	public long minSubarraySum(int n, int a[])
	{
		//we'll use... Monotonic Stacks..
		Stack<Integer> st=new Stack<Integer>();
		//let's find the minimum element to right... of present element...
		long totalSum=0;
		for(int i=0;i<n;i++)
		{
			int ele=a[i];
			while(st.size()>0 && ele<a[st.peek()])
			{
				int index=st.pop();
				int rb=i;
				int lb=-1;

				if(st.size()>0)
				{
					lb=st.peek();
				}

				//principle of counting...
				//let's find the no. of subarrays...
				int numOfSubArrays=(rb-index)*(index-lb);

				//in all these subarrays.. the min will be the a[index];

				long sumOfMin=numOfSubArrays*a[index];

				totalSum+=sumOfMin;
			}

			//he will look for next smaller element to right...
			st.push(i);
		}

		//I've still elements in the stack... here we go...
		//as they don't have rigth boundary take right boundary... as.
		//n

		while(st.size()>0)
		{
			int index=st.pop();
				int rb=n;
				int lb=-1;

				if(st.size()>0)
				{
					lb=st.peek();
				}

				//principle of counting...
				//let's find the no. of subarrays...
				int numOfSubArrays=(rb-index)*(index-lb);

				//in all these subarrays.. the min will be the a[index];

				long sumOfMin=numOfSubArrays*a[index];

				totalSum+=sumOfMin;
		}
		return totalSum;
		
	}
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}
