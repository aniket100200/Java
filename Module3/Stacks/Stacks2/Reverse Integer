import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    public int reverseInteger(int x) 
	{
        // write code here
		Stack<Integer> st=new Stack();
		while(x!=0)
		{
			st.push(x%10);
			x=x/10;
		}
			if(st.size()>9)
		{
			return 0;
		}
		Stack<Integer> st2=new Stack();

		while(st.size()>0)
		{
			st2.push(st.pop());
		}
	
		int i=0;
		while(st2.size()>0)
		{
			i=i*10+st2.pop();
		}

		return i;

    }
}

public class Main
	{	
  public static void main (String[] args)
	{
Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
Solution obj = new Solution();
System.out.println(obj.reverseInteger(x));		
	}
}
