//Problem With Given Difference
import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []arr, int n, int k) 
	{
        // write your code here
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			//agar merko koi ek milta hai map me isse krelated.. to..
			int x=arr[i];
			if(hs.contains(arr[i]-k)|| hs.contains(arr[i]+k))
			{
				//O(n) T.C.
				return 1;
			}
			hs.add(arr[i]);
		}
		return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
