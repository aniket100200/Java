import java.util.*;

class Solution {
   static boolean areAnagram(String c1, String c2)
	{
		if(c1.length()!=c2.length())
		{
			return false;
		}
       //Write your code here
		HashMap<Character,Integer> map1=new HashMap<>();
		HashMap<Character,Integer> map2=new HashMap<>();
		
		for(int i=0;i<c1.length();i++)
		{
			char ch1=c1.charAt(i);
			char ch2=c2.charAt(i);
			map1.put(ch1,map1.getOrDefault(ch1,0)+1);
			map2.put(ch2,map2.getOrDefault(ch2,0)+1);
				
		}
		for(int i=0;i<c1.length();i++)
		{
			char ch=c1.charAt(i);
			if(map1.get(ch)!=map2.get(ch))
			{
				return false;
			}
		}
		return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
