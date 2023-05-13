//Chocolate Distribution Problem
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s = new Solution();
        System.out.println(s.minChocolateDifference(a, n, m));
    }
}

class Solution {

    public static int minChocolateDifference(int a[], int n, int m)
	{
        Arrays.sort(a);
		int[]max=new int[n-m+1];
		int[]min=new int[n-m+1];
		int i=0;
		int j=0;
		int l=0;
		int r=m-1;
		//I've cutted it..
		while(r<n)
		{
			max[i++]=a[r++];
			min[j++]=a[l++];
		}
		int MIN=Integer.MAX_VALUE;
		for( i=0;i<max.length;i++)
		{
			MIN=Math.min(MIN,max[i]-min[i]);
		}
		return MIN;
		
    }
}
