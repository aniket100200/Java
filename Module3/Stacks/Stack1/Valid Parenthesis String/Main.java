//Tc: O(N);
//Sc: O(:1)
import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s)
	{
        //write code here
		//let's try to do it in O(N) with constatnct space time complexity.../
	    //and O(1 ) space complexity...
		//let's first elemintate all the closing parenthesis.. if you can...
		int cnt=0;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='(' || ch=='*')
			{
				cnt++;
			}
			else 
			{
				cnt--;
			}
			if(cnt<0)return false;
		}
		if(cnt<0)return false;
		cnt=0;
		for(int i=n-1;i>=0;i--)
		{
			char ch=s.charAt(i);
			if(ch==')' || ch=='*')cnt++;
			else cnt--;
			if(cnt<0)return false;
		}
		if(cnt<0)return false;
		return true;
		
	}
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
