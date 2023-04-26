import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void merge(int[][] b) 
	{
		Arrays.sort(b,(c,d)->
		{
			return c[0]-d[0];
		});

		int psp=-1;
		int pep=-1;
		for(int[] arr: b)
		{
			//when to merge...
			int sp=arr[0];
			int ep=arr[1];
			if(sp>pep)
			{
				if(psp!=-1){System.out.println(psp+" "+pep);}
				psp=sp;
				pep=ep;
			}
			else
			{
				//if it is..overlapping ...				
				if(ep>pep)
				{
					pep=ep;
				}
			}
		}
		System.out.println(psp+" "+pep);
		
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        int[][] A = new int[m][2];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        Obj.merge(A);
        
    }
}
