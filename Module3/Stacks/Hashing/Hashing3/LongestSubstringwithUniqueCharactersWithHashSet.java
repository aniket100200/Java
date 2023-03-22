import java.util.*;

class Solution {
    public int longestSubstring(String s)
	{
		s=s.trim();       
		//let's Have the Hash
		int inc=-1;
		int exc=-1;
		int ans=0;	
	HashSet<Character> set=new HashSet<>();
		
		while(true)
		{
			//let's include the  peole..
			boolean f1=false,f2=false;
				//let's include th people..
			while(inc+1<s.length() && set.contains(s.charAt(inc+1))==false)
			{
				//let's include itk..
				inc++;
				char ch=s.charAt(inc);						
				set.add(ch);
				//let's calculate the substring...
				int pans=inc-exc;
				if(set.size()>ans)
				{
					ans=set.size();
				}
				f1=true;
				
			}

			//let's exclude the peole..
			if(exc<inc)
			{
				exc++;
				set.remove(s.charAt(exc));
				f2=true;
			}
			if(!f1&&!f2){break;}
		}
		return ans;
    }
}

public class Main {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        Solution ob = new Solution();
        int ans=ob.longestSubstring(s);
        System.out.println(ans);
    }
}
