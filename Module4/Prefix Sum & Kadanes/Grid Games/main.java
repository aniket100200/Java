//Grid Games
import java.util.*;

class Solution {

    public long solve(int grid[][])
	{//we'll have to find prefix sum of 1st index and
		/* suffix sum of last index */
int n=grid[0].length;
		long[] suffixSumOfFirstRow=new long[n];
		suffixSumOfFirstRow[n-1]=grid[0][n-1];
		//It is the suffix sum that's why...
		for(int i=n-2;i>=0;i--)suffixSumOfFirstRow[i]=grid[0][i]+suffixSumOfFirstRow[i+1];//this is suffix sum array..

		//we need to create the prefix sum array...
		long[] preffixSumOfSecRow=new long[n];
		preffixSumOfSecRow[0]=grid[1][0];

		for(int i=1;i<n;i++)preffixSumOfSecRow[i]=grid[1][i]+preffixSumOfSecRow[i-1];

		//we have successfully generated preefix and suffix sum for grid 2*n.... TC:O(N)\\<--------------------------->////
		//let's generate all the switch points for the A--->
		//so robot B--will have the min of all the possible paths...
		//
		
		Long ans=new Long(Long.MAX_VALUE);
		for(int j=0;j<n;j++)
		{
			//I've on the point from where this A turns or switchin g point so I've two options....
			
			long choise1=(j==n-1 ? 0:suffixSumOfFirstRow[j+1]);
					long choise2=(j==0?0:preffixSumOfSecRow[j-1]);  //best use of ternary operator... here we go yrr...<<<<><>>>>>>>>>>>>>>>>>>>>
			long bestOfRobotB=Math.max(choise1, choise2);
			ans=Math.min(ans,bestOfRobotB);
		}
		return ans;
		
	}
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}
