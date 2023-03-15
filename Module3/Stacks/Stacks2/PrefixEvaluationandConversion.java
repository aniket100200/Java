import java.util.*;
  
public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        valueOfExpression(str);

    }

	public static void evaluatePrefix(String str)
	{
		//I'll need a stack here..
		Stack<Integer> st=new Stack<>();
		for(int i=str.length()-1;i>=0;i--)
		{
			char ch=str.charAt(i);
			if(Character.isDigit(ch))
			{
				st.push(ch-'0');
			}
			else
			{
				//means it is operator...
				int v1=st.pop();
				int v2=st.pop();
				int value=1;
				switch(ch)
				{
					case '+': {	value=v1+v2;	break;}					
					case '-': {	value=v1-v2;break;}
					case '*':{ value=v1*v2;break;}
					case '/': {value=v1/v2;break;}
					default : value=-1;				
					
				}
				st.push(value);
			}
		}
		System.out.print(st.peek());
		
	}
    public static void valueOfExpression(String str)
    {
        // your code here

		//first wanted to evaluate the str.. or prefix...

		evaluatePrefix(str);
		//evaluation is done.. 
		//let's go for Conversion...
		System.out.println();

		conversion(str);
        
    }
	public static void conversion(String str)
	{
		//for conversion I'll need stacks one for infix and other 
		//for postfix...
		Stack<String> infix=new Stack<>();
		Stack<String> postFix=new Stack<>();

		for(int i=str.length()-1;i>=0;i--)
		{
			char ch=str.charAt(i);
			if(Character.isDigit(ch))
			{
				infix.push(""+ch);
				postFix.push(""+ch);
			}
			else
			{
				//means it is operator.. 
				//let's put out two operand.. and we have operator in ch
				String v1=postFix.pop();
				String v2=postFix.pop();
				postFix.push(v1+v2+ch);

				//.et's do for postfix also... here we go..
				String V1=infix.pop();
				String V2=infix.pop();
				infix.push("("+V1+ch+V2+')');
			}
		}
	
	System.out.println(infix.pop());
		System.out.println(postFix.pop());
}
}
