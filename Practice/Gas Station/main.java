import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost)
	{
        //Write code here
		//first let's say if it possible or not here we go..
		int tg=0;
		int tc=0;
		for(int i=0;i<gas.length;i++)
		{
			tg+=gas[i];
			tc+=cost[i];
		}
		if(tc>tg)return -1;
		//we'll have to be greed as we know that ans does exists..
		int n=gas.length;
		int idx=-1;
		int prev=0;
		for(int i=0;i<n;i++)
		{
			int diff=gas[i]-cost[i];
			if(diff+prev>=0)
			{
				if(idx==-1)idx=i;
				prev+=diff;
			}
			else
			{
				prev=0;
				idx=-1;
			}
		}
		return idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++)
            A[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = input.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.canCompleteCircuit(A, B));
        input.close();
    }
}
