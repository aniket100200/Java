
import java.util.*;

class Solution {
	public int SubArraySumEqualToK(int[]arr, int k)
	{
		TreeSet<Integer> ts=new TreeSet<>();
		ts.add(0);
		int pref=0;
		for(int i=0;i<arr.length;i++)
		{
			pref+=arr[i];
			if(ts.contains(pref-k))
			{
				//
				System.out.println("Got a subarray");
			}
			ts.add(pref);
		}
		return -1;
	}
    public int maxSumSubmatrix(int[][] matrix, int k)
	{
        //Write code here
		k=3;
		int[] arr={-1,2,3,-1,1,-5,1};
		SubArraySumEqualToK(arr,k);
		return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.maxSumSubmatrix(matrix, k));
        sc.close();
    }
}
