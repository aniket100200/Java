import java.util.*;

class Pair
	{
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int matrix[][], Pair query[])
	{
        //let's solve it... 
		/* for 0th row and 0th col prefix sum we'll have to do separately..
			* then do using your rules...
			*/
		int n=matrix.length;
		int m=matrix[0].length;
		int[][] pref=new int[n][m];

		//for 0th row..
		pref[0][0]=matrix[0][0];
		for(int j=1;j<m;j++)
		{
			pref[0][j]=matrix[0][j]+pref[0][j-1];
		}

		//for 0th col
		for(int i=1;i<n;i++)
		{
			pref[i][0]=pref[i-1][0]+matrix[i][0];
		}

		//done initial setup...<<<<<
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				int A=matrix[i][j];
				int B=pref[i][j-1];
				int C=pref[i-1][j];
				int D=pref[i-1][j-1];
				pref[i][j]=A+B+C-D;
			}
		}
		// prefix sum for each bolck or chunk is done
		List<Integer> al=new ArrayList<>();

		//let's see queries...
		for(Pair p: query)
		{
			int x1=p.row1;
			int y1=p.col1;
			int x2=p.row2;
			int y2=p.col2;
			al.add(solve(pref,x1,y1,x2,y2));
		}
		// for(int [] i: pref)
		// {
		// 	System.out.println(Arrays.toString(i));
		// }
		return al;        
    }
	int solve(int[][] pref,int x1,int y1,int x2,int y2)
	{
		
		//let's solve these queries...
		int A=pref[x2][y2];
			int B=  y1==0?0:pref[x2][y1-1];
		//best use ternary operator... here we go.... java developer..
			int C= x1==0? 0:pref[x1-1][y2];
		int D= (x1==0 || y1==0) ? 0 : pref[x1-1][y1-1];
		return A-B-C+D;
	}
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}
