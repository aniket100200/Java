import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

  public static String reverseParentheses(String s)
	{
    // your code here
		Stack<Character> s1=new Stack<>();
		Stack<Character> s2=new Stack<>();
		Stack<Character> s3=new Stack<>();

		//let's go..

		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch!=')')
			{
				s1.push(ch);
			}
			else
			{
				// means it is closing par...
				//Tc: O(N)... and SC: O(n);... here you goo..
				while(s1.size()>0 && s1.peek()!='(')
				{
					s2.push(s1.pop());
				}
				s1.pop();
				while(s2.size()>0)
				{
					s3.push(s2.pop());
				}
				while(s3.size()>0)
				{
					s1.push(s3.pop());
				}
			}
		}
		String ans="";
		while(s1.size()>0)
		{
			ans=""+s1.pop()+ans;
		}
		return ans;
		
  }
}
