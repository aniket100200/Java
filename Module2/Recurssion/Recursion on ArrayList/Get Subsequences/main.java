import java.io.*;
import java.util.*;

public class Main {
	public static ArrayList<String> generateSubsequences(String str)
	{
		ArrayList<String> ans=run(str);
		ans.remove("");
		Collections.sort(ans);
		return ans;
	}
    public static ArrayList<String> run(String str)
    {
        // write your code here  
		ArrayList<String> ans=new ArrayList();
		if(str.length()==0){
			ans.add("");
			return ans;
		}
	// call the 
		ArrayList<String> operation=run(str.substring(1));
		for(String s: operation)
		{
			ans.add(str.charAt(0)+s);
			ans.add(s);
		}
		return ans;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        ArrayList<String> res = generateSubsequences(s);
		// res.remove("");
		// Collections.sort(res);
        for(int i=0;i<res.size();i++)
		{
            System.out.println(res.get(i));
        }
    }
}
