import java.util.Scanner;

class Solution{
    static int findLengthOfSmallestSubarray(int[] a, int K)
	{
        //Write your code here
		int si=0;
		int ei=0;
		int sum=0;
		int min=Integer.MAX_VALUE;
		int n=a.length;
		while(ei<n)
		{
			//let's expand till when...
			while(ei<n&& sum<K)
			{
				sum+=a[ei];
				ei++;
			}

			//we'll calculate the answer...
			min=Math.min(min,ei-si);

			//let's contract shrink the window..

			while(si<ei && sum>=K)
			{
				sum-=a[si];
				si++;
				if(sum>=K)
				{
					min=Math.min(min,ei-si);
				}
			}

			//expand the window...					
		}
		return min;
    }
}
public class Main{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
}
