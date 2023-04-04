import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairPaths(int n)
	{
        // your code here
		ArrayList<String> ans=new ArrayList<>();
		
		if(n<0){return ans;}
		if(n==0)
		{
			ans.add("");
			return ans;		
		}

		//lets take a jump of single stair

		ArrayList<String> j1=getStairPaths(n-1);
		for(String a: j1)
		{
			ans.add("1"+a);
		}

		//lets take a jump of two stairs 

		ArrayList<String> j2=getStairPaths(n-2);
		for(String a: j2)
		{
			ans.add("2"+a);
		}

		//lets'take a jump of three steps at once

		ArrayList<String> j3=getStairPaths(n-3);
		for(String a: j3)
		{
			ans.add("3"+a);
		}
		return ans;
    }
}


                        
                                
