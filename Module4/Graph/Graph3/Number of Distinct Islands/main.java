import java.util.*;

class Solution {


  
  public static int countDistinctIslands(int[][] grid) 
{
    // write your code here
	//what I will do..
	HashSet<ArrayList<Integer>> set=new HashSet<>();
	//HashSet<String> hs=new HashSet<>();
	for(int i=0;i<grid.length;i++)
		for(int j=0;j<grid[0].length;j++)
		{
			if(grid[i][j]==0)continue;
			ArrayList<Integer> al=new ArrayList<>();
			dfs(grid,i,j,i,j,al);
			set.add(al);
		}
	return set.size();
}
	public static void dfs(int[][] grid,int i,int j,int bi, int bj,ArrayList<Integer> al)
	{
		//what will be the base cases..
		if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0)return;

		//first destroy the is land...
		grid[i][j]=0;
		al.add(i-bi);
		al.add(j-bj);

		//let's try to move 
		//uldr
		dfs(grid,i-1,j,bi,bj,al);
		dfs(grid,i,j-1,bi,bj,al);
		dfs(grid,i+1,j,bi,bj,al);
		dfs(grid,i,j+1,bi,bj,al);
	}
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}
