import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t)
	{
		//Tc: O(n) && sc==O(1);;;;
		// write code here
		//let's create the HashMap... 
		HashMap<Character,Integer> map2=new HashMap<>();
		//I'll map all the characters of t string...
		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			map2.put(ch,map2.getOrDefault(ch,0)+1);
		}

		//so i'll Have desired cout..
		int dcnt=t.length();

		//let's say I've matciching count initially ==0;

		int mcnt=0;
		//let's get ans strign.. that we have to return;..
		String ans="";

		//let's have two pointers..
		int inc=-1;
		int exc=-1;

		// let's statrt iteratring over the s String...
		//character by character...

		//so we'll need a map.. for stroring the data for string s..
		
		HashMap<Character,Integer> map1=new HashMap<>();
		
		while(true)
		{

			//let's include the people but when...
			//they are important... and matchign count should less or equal ot derised coutn
		boolean f1=true;
			while(inc+1<s.length() && mcnt<dcnt)
			{
				inc=inc+1;
				//get the char at..
				//add it into the whether it is importatn or not we'll chek lastr
				//let's get char first
				char ch=s.charAt(inc);

				map1.put(ch,map1.getOrDefault(ch,0)+1);

				//how to know it is important or not...
				if(map2.containsKey(ch) && map1.get(ch)<=map2.get(ch))
				{
					mcnt++;
				}
				f1=false;
			}

			///let's exclude people but when to exclude..
			boolean f2=true;
				while(exc<inc && mcnt==dcnt)
				{
					// you'll come here present string from exc+1 inc +1 it your poterital ans

					String pans=s.substring(exc+1,inc+1);

					if(ans.length()==0 || pans.length()<ans.length())
					{
						ans=pans;
					}
					//let's get the char at exclude..
					exc=exc+1;
					char ch=s.charAt(exc);

					//let's remove that char...
					map1.put(ch,map1.get(ch)-1);

                    //you'll have to also chage the mcnt..k
					//how you'll know which one is to remove whic h one is not important...
                    
					if(map2.containsKey(ch) && map1.get(ch)<map2.get(ch))
					{
						mcnt--;
					}

					//if this present char is going to be zeroe.. 
					//remove it from the map.. 

					if(map1.get(ch)==0)
					{
						map1.remove(ch);
					}

					
					f2=false;
				}
			if(f1 && f2){break;}
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
