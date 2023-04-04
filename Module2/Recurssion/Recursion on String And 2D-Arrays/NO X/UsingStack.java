import java.util.*;

public class Main {
    static String noX(String s) 
	{
        // Write your code here
		// if(s.length()==0)
		// {
		// 	return "";
		// }
		// if(s.charAt(0)=='x')
		// {
		// 	return noX(s.substring(1));
		// }
  //       return s.charAt(0)+noX(s.substring(1));
		Stack<Character> st=new Stack<>();
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch!='x'){
				st.push(ch);
			}
		}
		StringBuilder sb=new StringBuilder();
		while(!st.isEmpty())
		{
			sb.insert(0,st.pop());
		}
		return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(noX(s));
    }
}
