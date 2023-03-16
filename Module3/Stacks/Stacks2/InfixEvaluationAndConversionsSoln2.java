import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluate(exp);
  }
}

class Solution
{
	Stack<String> prefix;
	Stack<String> postfix;
	public Solution()
	{
		prefix=new Stack<String>();
		postfix=new Stack<String>();
	}
	//let's we have solve function which will evaluate and conver...
	public int solve(int a, char o, int b)
	{
		//let's first convert to prefix..
		{String s1=prefix.pop();
		String s2=prefix.pop();
		prefix.push(o+s2+s1);}

		//let's convert to postfix..
	{	String s2=postfix.pop();
		String s1=postfix.pop();
		postfix.push(s1+s2+o);}

		switch(o)
		{
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;
			default : return -1;
		}
	}

	//let's get precedance...
	public int getPrec(char o)
	{
		if(o=='+' || o=='-')
		{
			return 1;
		}
		else if(o=='*' || o=='/')
		{
			return 2;
		}
		return -1;
	}
    public void evaluate(String exp)
	{
        //let's we have two stacks.. which are..
		Stack<Character>opr=new Stack<>();
		Stack<Integer> opd=new Stack<>();

		for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);

			if(ch=='(')
			{
				//operator..
				opr.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				opd.push(ch-'0');
				prefix.push(""+ch);
				postfix.push(""+ch);
			}
			else if(ch==')')
			{
				//we have to solve the bracke.. first...
				while(opr.size()>0 && opr.peek()!='(')
				{
					char o=opr.pop();
					int v2=opd.pop();
					int v1=opd.pop();

					//let's solve and push..
					opd.push(solve(v1,o,v2));
				}
				opr.pop();
			}
			else
			{
				//here means this is operator....
				//let's check if stack have morecedance opertor.. if it has we'll sove it... firs. and then add this..

				while(opr.size()>0 && opr.peek()!='(' && getPrec(ch)<=getPrec(opr.peek()))
				{
					char o=opr.pop();
					int v2=opd.pop();
					int v1=opd.pop();

					//let's solve and push..
					opd.push(solve(v1,o,v2));
				}
				opr.push(ch);
				
			}
		}

		//here after for loop there may be the operators in the stack... 
		//if they have.. let's go..
		while(opr.size()>0)
		{
			char o=opr.pop();
					int v2=opd.pop();
					int v1=opd.pop();

					//let's solve and push..
					opd.push(solve(v1,o,v2));
		}
System.out.println(opd.peek());
System.out.println(postfix.peek());	
System.out.println(prefix.peek());
    }
}               
