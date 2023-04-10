import java.util.*;

class Solution{
    public static boolean checkValidString(int n, String s)
	{
        //write code here
		/*** this solution has O(N) Tc and O(N) Sc****/
		//1)Ways....
		Stack<Integer> st=new Stack<>();
		Stack<Integer> star=new Stack<>();
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(ch=='(')
			{
				st.push(i);
			}
			else if(ch=='*')
			{
				star.push(i);
			}
			else
			{
				if(st.size()==0 && star.size()==0)return false;
				else if(st.size()>0)
				{
					st.pop();
				}
				else
				{
					star.pop();
				}
			}
		}
		//stack has element's ....
	if(st.size()>star.size())return false;

		while(st.size()>0)
		{
			if(st.pop()>star.pop())return false;
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
