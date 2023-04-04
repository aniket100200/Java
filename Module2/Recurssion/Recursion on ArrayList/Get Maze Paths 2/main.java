import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> allPossiblePaths(int n, int m)
	{
        // write code here
		ArrayList<String> ans=new ArrayList<String>();
		if(n<0 || m<0)return ans;
		if(n==1 && m==1)
		{
			ans.add("");
			return ans;
		}

		//lets move one cell to right
		ArrayList<String> h1=allPossiblePaths(n,m-1);
		for(String s: h1)
		{
			ans.add(s+"h1");
		}
		//lets move tow cell to right 

		ArrayList<String> h2=allPossiblePaths(n,m-2);
		for(String s: h2)
		{
			ans.add(s+"h2");
		}

		//let's move one cell down
		ArrayList<String> v1=allPossiblePaths(n-1,m);
		for(String s: v1)
		{
			ans.add(s+"v1");
		}

		//let's move tow cell down

		ArrayList<String> v2=allPossiblePaths(n-2,m);
		for(String s: v2)
		{
			ans.add(s+"v2");
		}

		///let's move onc cell digonally;
		
		ArrayList<String> d1=allPossiblePaths(n-1,m-1);
		for(String s: d1)
		{
			ans.add(s+"d1");
		}

		ArrayList<String> d2=allPossiblePaths(n-2,m-2);
		for(String s: d2)
		{
			ans.add(s+"d2");
		}
		return ans;
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
