import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	
	  public static void main (String[] args) throws IOException {
		  Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        int [][] arr= new int[n][m];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                arr[i][j]=sc.nextInt();
	            }
	        }
	        Solution obj= new Solution();
	        
	        System.out.println(obj.orangesRotting(arr));
		}
}
class Pair
{
	int row;
	int col;
	Pair(int row, int col)
	{
		this.row=row;
		this.col=col;
	}
}
class Solution{        
	 public static int orangesRotting(int[][] grid)
{

	int n=grid.length;
	int m=grid[0].length;
//o--> Empty..
	//1--> fresh..
	//2--> Rotten...

	Queue<Pair> que=new ArrayDeque<Pair>();

	//que.add(new Pair(0,0));//singley added ...
//add all the sources...

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<m;j++)
		{
			if(grid[i][j]==2)
			{
				que.add(new Pair(i,j));
			}
		}
	}

	
	
	int level=0;
	while(que.size()>0)
	{
		int size=que.size();
		while(size-->0)
		{
			Pair rpair=que.remove();

			int r=rpair.row;
			int c=rpair.col;
			//bottom... me dekh.. koi hai..
			if(r+1<n && grid[r+1][c]==1)
			{
				grid[r+1][c]=2;
				que.add(new Pair(r+1,c));
			}

			//agar tu up ja skta hai or dekh ki koi hai!..shhh.

			if(r-1>=0 && grid[r-1][c]==1)
			{
					grid[r-1][c]=2;
				que.add(new Pair(r-1,c));
			}

			//agar tu right jana chahta hai toh 
			//dekh jagh hai.. j+1<m...

			if(c+1<m && grid[r][c+1]==1)
			{
					grid[r][c+1]=2;
				que.add(new Pair(r,c+1));
			}

			//agar tu left me jana chahata hai toh...
			//check krega... valid hoga aur koi hia !....
			if(c-1>=0 && grid[r][c-1]==1)
			{
					grid[r][c-1]=2;
				que.add(new Pair(r,c-1));
			}
			}
		level++;
		}
	//check for fresh oranges...
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<m;j++)
		{
			if(grid[i][j]==1)
			{
				return -1;
			}
		}
	}
int time=level-1;
	return level==-1?0:time;
	
}
	
}

