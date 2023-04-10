/*********************************************** O(n) Solution I guess... ***************************************************/
import java.io.*;
import java.util.*;

class Solution{
    boolean expBalanced(String str)
	{
        // write code here
		Stack<Character> st=new Stack<>();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);//I have the character...
			if(ch==')')
			{
				if(st.size()==0)
				{
					return false;
				}
				while(st.size()>0 && st.peek()!='(')
				{
					if(st.peek()=='[' || st.peek()=='{'){
						return false;
					}
					st.pop();
				}
				st.pop();
			}
			else if(ch==']')
			{
				if(st.size()==0){
					return false;
				}
				while(st.size()>0 && st.peek()!='[')
				{
					if(st.peek()=='(' || st.peek()=='{'){
						return false;
					}
					st.pop();
				}
				st.pop();
			}
			else if(ch=='}')
			{
				if(st.size()==0){
					return false;
				}
				while(st.size()>0 && st.peek()!='{')
				{
					if(st.peek()=='[' || st.peek()=='(')
					{
						return false;
					}
					st.pop();
				}
				st.pop();
			}
			else
			{
				st.push(ch);
			}
		}
		if(st.size()>0)
		{
			return false;
		}
		return true;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}
