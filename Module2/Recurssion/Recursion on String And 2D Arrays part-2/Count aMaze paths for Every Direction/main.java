import java.util.*;

public class Main {
    static int countAllPath(int n, int m)
    {
        //Write your code here
		boolean[][] visit=new boolean[n][m];
		return f(0,0,n-1,m-1,visit);
    }
	static int  f(int i, int j, int n, int m, boolean[][] visit)
	{
				
		if(i==n && j==m)
			{
				return 1;
			}
		if(i>n || i<0 || j>m || j<0 )return 0;
		if(visit[i][j]){return 0;}
		visit[i][j]=true;
		int ans=0;
		//i'll tarve in all the eight possible directions 

		//first travel along x axis;

		ans+=f(i,j+1,n,m,visit);//x++

		ans+=f(i,j-1,n,m,visit);//x--

		//then trave along y axis

		ans+=f(i+1,j,n,m,visit);//y++

			ans+=f(i-1,j,n,m,visit);//y--

		// now trave along  digonal 

		ans+=f(i+1,j+1,n,m,visit);//along Ist quadrant

		ans+=f(i-1,j-1,n,m,visit);//along IIIrd quadrant


		ans+=f(i+1,j-1,n,m,visit);//alogn IInd quadrant

		ans+=f(i-1,j+1,n,m,visit);//along Iv quadrant
		visit[i][j]=false;
		return ans;
		
	}
	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
}
