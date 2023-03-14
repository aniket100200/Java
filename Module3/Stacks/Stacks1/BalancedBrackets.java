import java.util.*;

class Solution{
    public void balancedBrackets(String s, int n)
	{
        Stack<Character> st=new Stack<>();
		Stack<Character> st2=new Stack<>();
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(ch=='(' || ch=='{' || ch=='[')
			{
				st.push(ch);
			}
			else
			{
				st2.push(ch);
			}
		}
		Stack<Character> st3=new Stack<>();
		while(st2.size()>0)
			{
			st3.push(st2.pop());
		}
		st2=st3;

		while(st.size()>0 && st2.size()>0)
		{
			if(st.peek()=='(')
			{
				if(st2.peek()=='}' || st2.peek()==']')
				{
					System.out.print("NO");
					return;
				}
				else
				{
					st.pop();
					st2.pop();
				}
			}
			else if(st.peek()=='{')
			{
				if(st2.peek()==')' || st2.peek()==']')
				{
					System.out.print("NO");
					return;
				}
				else
				{
					st.pop();
					st2.pop();
				}
			}
				else if(st.peek()=='[')
			{
				if(st2.peek()==')' || st2.peek()=='}')
				{
					System.out.print("NO");
					return;
				}
				else
				{
					st.pop();
					st2.pop();
				}
			}
			
		}
		if(st.size()!=0 || st2.size()!=0)
		{
			System.out.print("NO");
		}
		else
		{
			System.out.print("YES");
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
    }
}
