import java.util.*;
import java.lang.*;
import java.io.*;
class Pair{
	int i,j;
	public Pair(int i,int j){
		this.i=i;
		this.j=j;
	}
}
public class Main
{
    public static int[][] nearest(int[][] grid)
    {
        // your code here
		Queue<Pair>que=new LinkedList<>();
		int n=grid.length;
		int m=grid[0].length;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==1)que.add(new Pair(i,j));
				
			}
		}
		int[][]ans=new int[n][m];
		int level=0;
		int[]di={0,-1,0,1};
		int[]dj={-1,0,1,0};
		while(que.size()>0)
		{
			int size=que.size();
			while(size-->0)
			{
				Pair p=que.remove();
				int i=p.i;
				int j=p.j;
				ans[i][j]=level;
				for(int k=0;k<4;k++)
				{
					int ni=i+di[k];
					int nj=j+dj[k];

					if(ni<0 || nj<0 || ni==n || nj==m || grid[ni][nj]==1)continue;
					que.add(new Pair(ni,nj));
					grid[ni][nj]=1;
					
					
				}
			}
			level++;
		}
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
