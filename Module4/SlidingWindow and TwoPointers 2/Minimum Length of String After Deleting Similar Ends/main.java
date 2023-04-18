import java.util.*;

class Solution {
	static int solve(String s)
	{
		//Write your code here
		int l=0;
		int r=s.length()-1;
		while(l<r && s.charAt(l)==s.charAt(r) )
		{
			//like four sum problem...
			char prevChar=s.charAt(l);
			while(l<=r && s.charAt(l)==prevChar)l++;
			while(r>=l && s.charAt(r)==prevChar)r--;
		}
		return r-l+1<0 ? 0 : r-l+1;
	}
}
public class Main{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}
