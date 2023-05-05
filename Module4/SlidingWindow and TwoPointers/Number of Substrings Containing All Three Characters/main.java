import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
		  
		   Scanner sc = new Scanner(System.in);
	        String s = sc.nextLine();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.numberOfSubstrings(s));
	    }
}
class Solution
	{
public static int numberOfSubstrings(String s)
{
		int[] counts=new int[3];///count a b c..
		int left=0;
		int count=0;
	for(int right=0;right<s.length();right++)
	{
		char ch=s.charAt(right);
		counts[ch-'a']++;
	while(counts[0]>0 && counts[1]>0 && counts[2]>0)
		{
		 ch=s.charAt(left);
			counts[ch-'a']--;
			left++;
		}
		count+=left;
	}
	return count;
	
}
	}
