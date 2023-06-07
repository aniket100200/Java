import java.util.*;

public class Main
{
	static boolean isAlphanumeric(String str){
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)>='0' && str.charAt(i)<='9')return true;
		}
		return false;
	}
    static int evalRPN(String[] tokens)
	{
       //Write your code here
		Stack<String>st=new Stack<>();
		for(int i=0;i<tokens.length;i++){
			if(isAlphanumeric(tokens[i]))
			{
				st.push(tokens[i]);
			}
			else 
			{
				char c=find(tokens[i]);
				int v2=Integer.parseInt(st.pop());
				int v1=Integer.parseInt(st.pop());
				int ans=eval(v1,v2,c);
				st.push(ans+"");
			}
		}
		return Integer.parseInt(st.pop());
    }
	static char find(String st){
		if(st.equals("+"))return '+';
		if(st.equals("-"))return '-';
		if(st.equals("*"))return '*';
		if(st.equals("/"))return '/';
		return '%';
	}
	static int eval(int v1,int v2,char ch)
	{
		switch(ch)
		{
			case '+': return v1+v2;
			case '-': return v1-v2;
			case '*':return v1*v2;
			case '/':return v1/v2;
				default : return 0;
		}
		
	}
	public static void main(String[] args) 
	{
	  Scanner input = new Scanner(System.in);
	  int n = input.nextInt();
	  String[] arr = new String[n];
	  for(int i=0; i<n; i++)
	  {
	      arr[i] = input.next();
	  }
	  System.out.println(evalRPN(arr));
	}
}
