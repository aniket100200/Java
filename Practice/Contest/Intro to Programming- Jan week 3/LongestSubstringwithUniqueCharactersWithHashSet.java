import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        // Your code here
		HashSet<Character> hs=new HashSet<>();
		int i=0;
		int j=0;
		int max=0;
		while(j<str.length())
		{
			char ch=str.charAt(j);
			
			while(!hs.add(ch))
			{
				hs.remove(str.charAt(i));
				i++;
			}

			//let's calculate the the answer...
			max=Math.max(max,j-i+1);
				j++;		
		}
		return max;
    }
}

public class Main {
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

