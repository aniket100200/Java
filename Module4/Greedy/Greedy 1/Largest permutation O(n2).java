import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int[] largestPermutation(int[] A, int b)
	{        
		//Write your code here
		int n=A.length;
		for(int i=0;i<n;i++)
		{
			if(b==0)break;
			int largest=find(A,i+1,i);
			if(largest==i)continue;
			int temp=A[i];
			A[i]=A[largest];
			A[largest]=temp;
			b--;
		}
		return A;
        
    }
	static int find(int[]arr,int i,int j)
	{
		for(;i<arr.length;i++){
			if(arr[j]<arr[i])
			{
				j=i;
			}
		}
		return j;
	}
}

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int b =sc.nextInt();
        Solution obj= new Solution();
        int [] ans = obj.largestPermutation(A, b);

        for(int i=0;i<n;i++)
            System.out.print(ans[i]+" ");
    }
}
