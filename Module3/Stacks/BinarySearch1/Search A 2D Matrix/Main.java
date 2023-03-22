import java.util.*;

public class Main {

	//let's fidn it...
	static int findRow(int[][] arr, int col, int x)
	{
		int si=0;
		int ei=arr.length-1;
		int prow=-1;
		while(si<=ei)
		{
			//let's find the mid..
			
			int mid=(si+ei)/2;
			if(arr[mid][col]==x)
			{
				return mid;
			}
			else if(arr[mid][col]>x)
			{
				prow=mid;
				ei=mid-1;
			}
			else
			{
				si=mid+1;
			}
		}
		return prow;
	
	}
    public static boolean SearchA2DMatrix(int[][] arr, int x)
	{
		/** Tc:O(logN*m) sc:O(1)....*****/
		//let's find first in which row does it present...
		int row=findRow( arr,arr[0].length-1,x);

		int i=0,j=arr[0].length;
		while(i<=j)
		{
			//let's find mid..
			int mid=(i+j)/2;
			if(arr[row][mid]==x)
			{
				return true;
			}
			else if(arr[row][mid]<x)
			{
				i=mid+1;
			}
			else
			{
				j=mid-1;
			}
		}
		return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
