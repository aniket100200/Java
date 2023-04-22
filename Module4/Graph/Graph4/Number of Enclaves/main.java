import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt(), n = sc.nextInt();
    int[][] grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(numEnclaves(grid));
  }
	static void destroy(int i,int j, int[][] grid){

		if(i<0 || j<0 || i>grid.length || j>grid[0].length || grid[i][j]==0)return;

		//mark
		grid[i][j]=0;
		//work 
		//visit
		//let's move towards up..
		if(i-1>=0)
		{
			destroy(i-1,j,grid);
		}

		//down
		if(i+1<grid.length) destroy(i+1,j,grid);

		//left
		if(j-1>=0)destroy(i,j-1,grid);

		//right
		if(j+1<grid[0].length)destroy(i,j+1,grid);
	}

  public static int numEnclaves(int[][] grid)
{
    // your code here

	//let's destroy the islands touching to boundary..

	int n=grid.length;
	int m=grid[0].length;

	//top
	for(int j=0;j<m;j++)
		{
			if(grid[0][j]==1)destroy(0,j,grid);
		}

	//left 
	 for(int i=0;i<n;i++)
	 {
		 if(grid[i][0]==1)destroy(i,0,grid);
	 }

	//bottom
	for(int j=0;j<m;j++)
	{
		if(grid[n-1][j]==1)destroy(n-1,j,grid);
	}

	//right
	for(int i=0;i<n;i++)
	{
		if(grid[i][m-1]==1)destroy(i,m-1,grid);
	}

	int count=0;
	for(int[] a: grid){
		for(int i: a)if(i==1)count++;
		
	}
	return count;

}
}
