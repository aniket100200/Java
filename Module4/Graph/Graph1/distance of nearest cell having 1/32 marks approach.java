import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static int[][] nearest(int[][] grid)
    {
        // your code here
		//O(n3).. 
		int n=grid.length;
		int m=grid[0].length;
		int[][]ans=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==1)
				{
					ans[i][j]=0;
					continue;
				}
			int min=dfs(grid,i,j,0,new int[n][m]);
				ans[i][j]=min;
			}
		}
		return ans;
    }
	public static int dfs(int grid[][],int i,int j,int min,int [][]visit)
	{
		if(grid[i][j]==1)return min;
		visit[i][j]=1;
		int ans=Integer.MAX_VALUE;
		int[]di={-1,0,1,0};
		int[]dj={0,-1,0,1};
		for(int k=0;k<4;k++)
		{
			int ni=i+di[k];
			int nj=j+dj[k];
			if(ni<0 || nj<0 || ni==grid.length || nj==grid[0].length)continue;
			if(visit[ni][nj]==1)continue;
			ans=Math.min(ans,dfs(grid,ni,nj,min+1,visit));
		}
		visit[i][j]=2;
		return ans;
	}

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            int[][] ans = nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
