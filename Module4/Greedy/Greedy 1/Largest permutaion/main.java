//it's approach is NLOGN

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	static class Pair {
		int val;
		int idx;
		public Pair(int val,int idx){
			this.val=val;
			this.idx=idx;
		}
	}
    public static int[] largestPermutation(int[] A, int c)
	{
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
		{
			return b.val-a.val;
		});
		int n=A.length;

		for(int i=0;i<n;i++)
		{
			pq.add(new Pair(A[i],i));
		}

		for(int i=0;i<n;i++)
		{
			//I've to find the replacement..
			Pair curr=pq.remove();
			if(curr.idx<=i)
			{
				while(pq.size()>0 && curr.idx<=i)curr=pq.remove();				
			}
			if(curr.val<=A[i])
			{
				pq.add(curr);continue;
			}
			//here means greater value means replacement..
			int temp=A[i];
			A[i]=curr.val;
			curr.val=temp;
			A[curr.idx]=curr.val;
			pq.add(curr);
			c--;
			if(c==0)return A;
		}
		return A;
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
