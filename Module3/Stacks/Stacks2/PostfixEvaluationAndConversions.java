import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluation(exp);
  }
}

class Solution{
	public int evaluate(int a,int b, char o)
	{
		
		switch(o)
		{
			case '+': return a+b;
			case '-': return a-b;
			case '*': return a*b;
			case '/': return a/b;

			default: return -1;
		}
	}
    public void evaluation(String exp)
	{
        //Write code here
		//let's evaluate....
		//to evaluate need a stack...
		Stack<Integer> pEval=new Stack<>();

		//for conversion we'll need a stack.. of string...

		Stack<String> infix=new Stack<>();

		Stack<String> prefix=new Stack<>();

		//for postfix evalution.. we have to traverse from left to right..

		for(int i=0;i<exp.length();i++)
		{
			char ch=exp.charAt(i);
			if(Character.isDigit(ch))
			{
				pEval.push(ch-'0');
				infix.push(""+ch);
				prefix.push(ch+"");
			}
			else
			{
				//this means it is operator and precedence doesn't matter yess....

				//let's evaluate first.. this postfix..
				int v1=pEval.pop();
				int v2=pEval.pop();
				pEval.push(evaluate(v2,v1,ch));

				//evalution is donee.. 
				//let's convert...
//1) to infix...
				String s1=infix.pop();
				String s2=infix.pop();
				infix.push("("+s2+ch+s1+")");

				//conversion to infix is done...
//2) let's convert to prefix...
				String a=prefix.pop();
				String b=prefix.pop();
				//as the second oprand present first and vice versa...
				prefix.push(ch+b+a);
			}
		}

				System.out.println(pEval.pop());
				System.out.println(infix.peek());
				System.out.println(prefix.peek());
    }
}                         
