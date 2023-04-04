import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) 
	{
       // your code here
		ArrayList<String> ans=new ArrayList<>();
		if(sr>dr || sc>dc)return ans;
		if(sr==dr && sc==dc)
		{
			ans.add("");
			return ans;
		}

		//first move horizontally... here we go..

		ArrayList<String> a1=getMazePaths(sr,sc+1,dr,dc);
		//this is shows that you have taken horizontal move 
		for(String p: a1)
		{
			ans.add("h"+p);
		}
		ArrayList<String> a2=getMazePaths(sr+1,sc,dr,dc);
		//that above arraylist is for vertical moves here we go..
		for(String a: a2)
		{
			ans.add("v"+a);
		}
		return ans;
    }
}


                        
                        
                        
                        
                        
                                

                        
                                
