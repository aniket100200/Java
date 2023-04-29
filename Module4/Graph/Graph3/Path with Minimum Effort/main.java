import java.util.*;

public class Main{

  public static void main(String[] args) 
	{
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt(), columns = sc.nextInt();
    int[][] heights = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        heights[i][j] = sc.nextInt();
      }
    }
    sc.close();
    System.out.println(minimumEffortPath(heights));
  }
static class Pair 
{
	int r;
	int c;
	int diff;
	Pair(int r,int c, int diff)
	{
		this.r=r;
		this.c=c;
		this.diff=diff;
	}
	
}
  public static int minimumEffortPath(int[][] heights)
{
    // your code here
	PriorityQueue<Pair> que=new PriorityQueue<>(
		(a,b)->
		{
			//this is the lambda function which is uses 
			//best way... of sorting things.. 
			//tell the truth...
			return a.diff-b.diff;
		}
	);
	int n=heights.length;
	int m=heights[0].length;
	que.add(new Pair(0,0,0));
	boolean[][] visit=new boolean[n][m];

	//directino array...
	//-------------{up,left,down,right}... these are the changes when you take up left down right in x and y.. 
	int[] di=new int[]{-1,0,1,0};
	int[] dj=new int[]{0,-1,0,1};
	while(que.size()>0)
	{
		//let's remove the pair...
		Pair curr=que.remove();
		int i=curr.r;
		int j=curr.c;
		int effort=curr.diff;
		if(i==n-1 && j==m-1)return effort;
		//mark..
		visit[i][j]=true;
		for(int dir=0;dir<4;dir++)
		{
			int ni=i+di[dir];
			int nj=j+dj[dir];
			//this is my new directon..
			if(ni<0 || nj<0 || ni==n || nj==m || visit[ni][nj])continue;

			que.add(new Pair(ni,nj,Math.max(effort,Math.abs(heights[i][j]-heights[ni][nj]))));
		}		
		
	}
	return -1;
}
}
