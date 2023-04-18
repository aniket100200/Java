import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) 
	{
		// write code here
		HashMap<Character,Integer>hasT=new HashMap<>();
		HashMap<Character,Integer> hasW=new HashMap<>();
		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			hasT.put(ch,hasT.getOrDefault(ch,0)+1);
		}
		int sp=0;
		int ep=0;
		String ans="";
		int ansLen=Integer.MAX_VALUE;
		while(ep<s.length())
		{
			//let's try to expand the window..
			char ch=s.charAt(ep);
			hasW.put(ch,hasW.getOrDefault(ch,0)+1);
			//let's try to shring the window till it is valid..

			while(isValid(hasT,hasW))
			{
				//let's first of all try decrease the length...
				if(ansLen>ep-sp+1)
				{
					ans=s.substring(sp,ep+1);
					ansLen=ep-sp+1;
				}

				//let's exclude the people..
				hasW.put(s.charAt(sp),hasW.get(s.charAt(sp))-1);
				sp++;				
			}
			ep++;
		}
		return ans;
    }
	public boolean isValid(HashMap<Character,Integer> hasT,HashMap<Character,Integer> hasW)
	{
		for(char c: hasT.keySet())
		{
			int idealFre=hasT.get(c);
			if(hasW.containsKey(c)==false || hasW.get(c)<idealFre)return false;
		}
		return true;
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
