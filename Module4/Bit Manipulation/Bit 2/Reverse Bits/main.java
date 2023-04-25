import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public static long reverse(long A) 
	{
	    // Your code here
		//we'll create the mask till 32 th bit..
		long mask=1;
		String s="";
		int x=32;
		while(x-->0)
		{
			if((A&mask)!=0)s+=1;
			else s+=0;
			mask<<=1;
		}
		long ans=0;
		int pow=0;
	for(int i=s.length()-1;i>=0;i--)
	{
		if(s.charAt(i)=='1')ans+=Math.pow(2,pow);
		pow++;
	}
		return ans;
	}
}
public class Main {
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    	long n = sc.nextLong();
			System.out.println(Solution.reverse(n));
	}
}
