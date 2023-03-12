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
	public  int getPrece(char ch)
	{
		//need a oprator precedance.. getter.. or who will dicide..
		if(ch=='+' || ch=='-')
		{
			return 1;
		}
		else if(ch=='*'|| ch=='/')
		{
			return 2;
		}
		else
		{
			return -1;
		}
	}

	public  int solve(int v1, int v2, char o)
	{
		switch(o)
		{
			case '+': return v1+v2;
			case '*': return v1*v2;
			case '-': return v1-v2;
			case '/': return v1/v2;
			default: return -1;
		}
	}
	public void InfixSolve(String str)
	{
		  //I'll need oprator and oprand stack...

		Stack<Character> oprator=new Stack();
		Stack<Integer> oprand=new Stack();

		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='(')
			{
				oprator.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				oprand.push(ch-'0');
			}
			else if(ch==')')
			{
				while(oprator.peek()!='(')
				{
					char o=oprator.pop();
					int v2=oprand.pop();
					int v1=oprand.pop();
					oprand.push(solve(v1,v2,o));
				}
				oprator.pop();
			}
			else
			{
				//here means those are oprators....
				while(oprator.size()>0 && oprator.peek()!='(' && getPrece(ch)<=getPrece(oprator.peek()))
				{
					char o=oprator.pop();
					int v2=oprand.pop();
					int v1=oprand.pop();
					oprand.push(solve(v1,v2,o));
				}
				oprator.push(ch);
			}
			
		}

		//here after for loopp there may be elements' in the oprator stack...
		while(oprator.size()>0)
		{
			char o=oprator.pop();
					int v2=oprand.pop();
					int v1=oprand.pop();
					oprand.push(solve(v1,v2,o));
		}

		System.out.println(oprand.peek());
	}
   
	public void PrefixSolver(String str)
	{
		//to solve the prefix fix.. we will need two stack one is operator.. and another is prefix
		Stack<Character> opr=new Stack<>();

		Stack<String> prefix=new Stack<>();
		for(int i=0;i<str.length();i++)
		{	
			char ch=str.charAt(i);
			if(ch=='(')
			{
				opr.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				prefix.push(""+ch);
			}
			else if(ch==')')
			{
				while(opr.peek()!='(')
				{
					char o=opr.pop();
					String v2=prefix.pop();
					String v1=prefix.pop();
					prefix.push(o+v1+v2);
				}
				opr.pop();
			}
			else
			{
				while(opr.size()>0 && opr.peek()!='(' && getPrece(ch)<=getPrece(opr.peek()))
				{
					char o=opr.pop();
					String v2=prefix.pop();
					String v1=prefix.pop();
					prefix.push(o+v1+v2);
					
				}
				opr.push(ch);
			}
		}

		while(opr.size()>0)
		{
			char o=opr.pop();
					String v2=prefix.pop();
					String v1=prefix.pop();
					prefix.push(o+v1+v2);
		}
		System.out.println(prefix.peek());
	}
	public void evaluate(String str)
	{
	     //I need to solve the expression first.. okay..
		
		InfixSolve(str);//will solve and print...

		//that one is solve successfully.. okay... here you go.. bro..

		//let's convert into postFix first...
		PostfixSolve(str); //this will print too..

		//now need to solve prefix.. 

		PrefixSolver(str);
    }

	public void PostfixSolve(String str)
	{
		//to solve the post fix.. we will need two stack one is operator.. and another is post
		Stack<Character> opr=new Stack<>();

		Stack<String> post=new Stack<>();
		for(int i=0;i<str.length();i++)
		{	
			char ch=str.charAt(i);
			if(ch=='(')
			{
				opr.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				post.push(""+ch);
			}
			else if(ch==')')
			{
				while(opr.peek()!='(')
				{
					char o=opr.pop();
					String v2=post.pop();
					String v1=post.pop();
					post.push(v1+v2+o);
				}
				opr.pop();
			}
			else
			{
				while(opr.size()>0 && opr.peek()!='(' && getPrece(ch)<=getPrece(opr.peek()))
				{
					char o=opr.pop();
					String v2=post.pop();
					String v1=post.pop();
					post.push(v1+v2+o);
					
				}
				opr.push(ch);
			}
		}

		while(opr.size()>0)
		{
			char o=opr.pop();
					String v2=post.pop();
					String v1=post.pop();
					post.push(v1+v2+o);
		}
		System.out.println(post.peek());
	}
}               
