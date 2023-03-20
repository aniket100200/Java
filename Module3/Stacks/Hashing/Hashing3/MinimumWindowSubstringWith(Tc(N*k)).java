import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t)
	{
		// write code here
		HashMap<Character,Integer> m2=new HashMap<>();
		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			m2.put(ch,m2.getOrDefault(ch,0)+1);
		}
		//creation of map 2 is done....

		//let's iterate over the String...
		// let's have the mp1.. to create the map..

		HashMap<Character,Integer> m1=new HashMap<>();
		int inc=-1;
		int exc=-1;
		String ans=s;//this hole string will be my potential answer...
		while(inc<s.length() && exc<s.length())
		{
			//let's chek.. the keySet of the m2.. in m1..
			boolean chek=false;
			for(char key: m2.keySet())
			{
				if(m1.containsKey(key) && m1.get(key)>=m2.get(key))
				{
					// 
				}
				else
				{
					chek=true;
				}
			}
			//let's incluse the character...
			if(chek)
			{
				//you'll have to include...
				inc++;
				if(inc<s.length() && inc>=0){
				char ch=s.charAt(inc);
				m1.put(ch,m1.getOrDefault(ch,0)+1);}
			}
			else
			{
				//You'll have to drecrease the frequencey...
				//before excluding.. you'll have to set you're potential answer..
				String pans=s.substring(exc+1,inc+1);
				if(pans.length()<ans.length())
				{
					ans=pans;
				}				
				exc++;
				char ch=s.charAt(exc);
				if(m1.containsKey(ch) && m1.get(ch)==1)
				{
					m1.remove(ch);
				}
				else if( m1.containsKey(ch) && m1.get(ch)>1)
				{
					m1.put(ch,m1.get(ch)-1);
				}
			}
			
		}
		return ans;
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
		t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}
