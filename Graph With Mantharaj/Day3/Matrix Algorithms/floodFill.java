import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] image = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                image[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        int newColor = sc.nextInt();
        int[][] ans = Solution.floodFill(image, x, y, newColor);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(j == m-1) {
                    System.out.print(ans[i][j] + "\n");
                }
                else {
                    System.out.print(ans[i][j] + " ");
                }
            }
        }
    }
}

class Solution
{
static class Pair{
		int i;
		int j;
		Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
    static int[][] floodFill(int[][] w, int x, int y, int c)
    {     
		//w--> image 
			//c--> color
		  // write code here
		Queue<Pair>que=new LinkedList<>();
		que.add(new Pair(x,y));
		int n=w.length;
		int m=w[0].length;
		boolean[][]visit=new boolean[w.length][w[0].length];
		int iColor=w[x][y];
		int[]dx={0,1,0-1};
		int[]dy={1,0,-1,0};
		while(que.size()>0)
		{
			//remove the element..,,
			Pair curr=que.remove();
				int i=curr.i;
			int j=curr.j;
			if(visit[i][j])continue;
			w[i][j]=c;
			visit[i][j]=true;
			//let's travell in all possilbe four directions..

			//right
			if(j+1<m && w[i][j+1]==iColor)que.add(new Pair(i,j+1));
			//left
			if(j-1>=0 && w[i][j-1]==iColor)que.add(new Pair(i,j-1));
			//up
			if(i-1>=0 && w[i-1][j]==iColor)que.add(new Pair(i-1,j));
			//down
			if(i+1<n && w[i+1][j]==iColor)que.add(new Pair(i+1,j));		
		}
		return w;
    }
}
