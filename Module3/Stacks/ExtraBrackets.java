import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp)
	{
       Stack<Character> st=new Stack();
		for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);
			//if you are not encoutering with ) brac.. means push you char..
			if(exp.charAt(i)!=')')
			{
				st.push(ch);//pushing char....
			}
			else
			{
				// as you encountered with a closing bracket means check if you have... an openening bracket in top of the stack... st.
				
				if(st.peek()=='(')
				{
					//if yes then return true;;;;
					return true;
				}
				else
				{
					//In this else condition you'll have to remove the char upto.. opening bracket...
					while(st.size()>0 && st.peek()!='(')
					{
						st.pop();
					}
					st.pop();
				}
			}
			
		}
		return false;
       
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
	    Solution Obj = new Solution();
        if(Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
