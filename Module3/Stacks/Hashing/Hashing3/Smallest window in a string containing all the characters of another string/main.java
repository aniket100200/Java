import java.util.*;

class Accio {
        public String minWindow(String s, String t) 
	{
        //Write your code here
		//creating map of character vs its' frq..
		Map<Character,Integer>tmap=new HashMap<>();
		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			tmap.put(ch,tmap.getOrDefault(ch,0)+1);
		}

		int si=0;
		int ei=0;
		Map<Character,Integer> smap=new HashMap<>();
		int ans=s.length();
		String string="";
		while(ei<s.length())
		{
			//Introduce a new person...
			char ch=s.charAt(ei);
			smap.put(ch,smap.getOrDefault(ch,0)+1);
			//check if valid..
			//shrink the window till it is valid..
			while(si<=ei &&isContains(tmap,smap))
			{
				//If it is true then 
				int length=ei-si+1;				
				if(string.length()==0 || length<ans)
				{
					ans=length;				
					string=s.substring(si,ei+1);
				}
				char c=s.charAt(si);
				si++;
				smap.put(c,smap.get(c)-1);
				if(smap.get(c)==0)smap.remove(c);				
			}

			//let's try to include or expand your window..
			ei++;
		}
		return string;
     }
	public boolean isContains(Map<Character,Integer>tmap ,	Map<Character,Integer>smap)
	{
		for(char key: tmap.keySet())
		{
			if(smap.containsKey(key)==false)return false;
			else 
			{
				if(smap.get(key)<tmap.get(key))return false;
			}
		}
		return true;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        Accio Obj = new Accio();
        System.out.println(Obj.minWindow(s,t));
    }
}
