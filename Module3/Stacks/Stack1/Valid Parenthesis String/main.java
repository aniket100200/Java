import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s)
	{
        //write code here
		Stack<Integer> st=new Stack<>();
		Stack<Integer> st2=new Stack<>();
		for(int i=0;i<n;i++)
		{
			
			char ch=s.charAt(i);
			// if(i==n-1 && ch=='(' )
			// {
			// 	return false;
			// }
			if(ch=='(')
			{
				st.push(i);
			}
			else if(ch=='*')
			{
				st2.push(i);
			}
			else
			{
				if(st.size()>0)
				{
					st.pop();
				}
				else if(st2.size()>0)
				{
					st2.pop();
				}
				else
				{
					return false;
				}
			}			
		}
		
		if(st.size() > st2.size())
		{
			return false;
		}
		else 
		{
			while(st.size()>0)
			{
				if(st.peek()>st2.peek())
				{
					return false;
				}
				else
				{
					st.pop();
					st2.pop();
				}
				
			}
		}
		
		return true;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String s = sc.next();
        Solution obj = new Solution();
        boolean ans = obj.checkValidString(n,s);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
