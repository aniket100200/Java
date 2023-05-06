import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int bulbs(int[] A)
	{
        // your code here
		int n=A.length;
		int state=1;
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(A[i]==state)continue;
			count++;
			//let's change the state..
			state=1-state;
		}
	
		return count;
    }
}

public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    	int n = sc.nextInt();
			int[] A = new int[n];
			for(int i=0;i<n;i++)
			{
				A[i]= sc.nextInt();
			}
            Solution solution = new Solution();
	    	System.out.println(solution.bulbs(A));
		
	}
}
