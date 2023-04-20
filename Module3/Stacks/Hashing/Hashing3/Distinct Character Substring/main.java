import java.util.*;

public class Main {

    public static long DistinctCharacterSubstring(String s)
	{
        //write code here
		int n=s.length();
		int i=0,j=0;
		int[] arr=new int[26];
		long ans=0;
		while(i<n)
		{
			if(j<n && arr[s.charAt(j)-'a']==0)
			{
				//lete's first increase the frequency of current character to chek 
				//in future..
				arr[s.charAt(j)-'a']++;

				//all the character between i and j are unique..
				ans+=j-i+1;
				j++;
			}
			else
			{
				//chracter at jth index is repeating let's shrink the window...
				//first decrease the frequency of the chracter at ith index..
				arr[s.charAt(i)-'a']--;
				i++;
			}
		}
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
