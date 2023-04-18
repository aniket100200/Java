/* Tc==O(n) 
Sc==O(26) i.e. O(1) constant 
*/
import java.util.*;

class Solution {
	public int longestSubstringWithXUniqueCharacterAndKRepeating(String s, int x, int k)
	{
		int countUnique=0;
		int countKrep=0;
		int sp=0;
		int ep=0;
		int ans=0;

		//we'll do it with frequency array...
		int[] fre=new int[123];
		while(ep<s.length())
		{
			//let's we character...
			//let's add it..
			char ch=s.charAt(ep);
			fre[ch]++;
		//as I've increase 
			if(fre[ch]==1)countUnique++;
			if(fre[ch]==k)countKrep++;

		//let's shring k the window..
			while(countUnique>x)
			{
				//let's remove the char at sp...
				char re=s.charAt(sp);
					fre[re]--;
				if(fre[re]==0)countUnique--;
				if(fre[re]==k-1)countKrep--;
				sp++;				
			}

			//let's calculate the answer...

			//whyx you said countKrep ==x... 
			//this means all the character which are unique should be k repeating... got it...

			 if(countUnique==x && countKrep==x)
			 {
				 ans=Math.max(ans,ep-sp+1);
			 }
			//let's expand the window... 
			ep++;
		}
		return ans;
	}
    public int longestSubstring(String s, int k)
	{
        int ans=0;
		for(int i=1;i<=26;i++)
		{
			int xUniqueKRep=longestSubstringWithXUniqueCharacterAndKRepeating(s,i,k);
			ans=Math.max(xUniqueKRep,ans);
		}
		return ans;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
