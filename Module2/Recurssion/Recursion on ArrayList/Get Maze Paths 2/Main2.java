import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<String> allPossiblePaths(int n, int m)
	{
        // write code here
		ArrayList<String> ans=new ArrayList<String>();
		if(n==1 && m==1){ans.add("");return ans;}

		//yehi kaam kr skti hai...
		if(m>0)
		{
			ArrayList<String> a1=allPossiblePaths(n,m-1);
			for(String s: a1)
			{
				ans.add(s+"h1");
			}
		}		
		if(m>1)
		{
			ArrayList<String> a1=allPossiblePaths(n,m-2);
			for(String s: a1)
			{
				ans.add(s+"h2");
			}
		}

		if(n>0)
		{
			ArrayList<String> a1=allPossiblePaths(n-1,m);
			for(String s: a1)
			{
				ans.add(s+"v1");
			}
		}
		if(n>1)
		{
			ArrayList<String> a1=allPossiblePaths(n-2,m);
			for(String s: a1)
			{
				ans.add(s+"v2");
			}
		}

		if(n>0 && m>0)
		{
			ArrayList<String> a1=allPossiblePaths(n-1,m-1);
			for(String s: a1)
			{
				ans.add(s+"d1");
			}
		}
		if(n>1 && m>1)
		{
			ArrayList<String> a1=allPossiblePaths(n-2,m-2);
			for(String s: a1)
			{
				ans.add(s+"d2");
			}
		}
		
		return ans;
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) 
		{
            System.out.println(str);
        }

    }
}
