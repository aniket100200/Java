import java.util.*;

class Solution {
    public void allDuplicates(int n, int[] arr)
	{
        // Write Your code here.
		HashSet<Integer> hs=new HashSet<>();
		HashSet<Integer> set=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			if(!hs.add(arr[i]))
			{
				set.add(arr[i]);
			}
		}
		for(int i: set)
		{
			System.out.print(i+" ");
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}
