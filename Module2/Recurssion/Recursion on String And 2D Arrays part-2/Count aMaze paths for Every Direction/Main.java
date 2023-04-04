import java.util.*;

public class Main {
    static int countAllPath(int n, int m)
    {
        //Write your code here
		boolean[][] visit=new boolean[n][m];
		return f(n-1,m-1,visit);
    }
	static int f(int n, int m, boolean[][] visit)
	{
		if(m==0 && n==0)return 1;
		if(m<0 || n<0)return 0;
		if(n>=visit.length || m>=visit[0].length)return 0;
		if(visit[n][m])return 0;

		//let's try to move all eight possible direction..
		int ans=0;
		//let's mark presente cordinateas true..
		visit[n][m]=true;

		//horizontally...
		ans+=f(n,m+1,visit);
		//hrizontally back..
		ans+=f(n,m-1,visit);

		//vertically...
		//upward..
		ans+=f(n+1,m,visit);

		//downward
		ans+=f(n-1,m,visit);

		/*digonally*/
		//1st quadrant..
		ans+=f(n+1,m+1,visit);

		//2nd qudrand..
		ans+=f(n+1,m-1,visit);

		//3rd quadrant
		ans+=f(n-1,m-1,visit);

		//4th qudrant..
		ans+=f(n-1,m+1,visit);

		visit[n][m]=false;
		return ans;
		
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
}
