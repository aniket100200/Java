import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static int solve(String A)
	{
	     int i=0;
		int j=A.length()-1;
		
		while(i<j)
		{
			if(A.charAt(i)!=A.charAt(j))
			{
				if(isPal(A.substring(0,i)+A.substring(i+1)) || isPal(A.substring(0,j)+A.substring(j+1)))
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			i++;
			--j;
		}
		
		return 1;
		
    }
	static boolean isPal(String A)
	{
		int i=0; 
		int j=A.length()-1;
		while(i<j)
		{
			if(A.charAt(i)!=A.charAt(j))
			{
				return false;
			}
			i++;--j;
		}
		return true;
	}
}

public class Main{
          public static void main (String[] args){
            Scanner sc = new Scanner(System.in);
	    String A = sc.nextLine();
            Solution Obj = new Solution();
            int ans=Obj.solve(A);
            System.out.println(ans);
	}
}
