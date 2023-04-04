import java.util.*;
import java.io.*;
public class Main {
    public static void aMazePaths(int n, int m, String psf,int i , int j)
	{
       //Write your code here	
		if(i>n || j>m)return;
		if(i==n && j==m)
		{
			System.out.println(psf);
			return;
		}
		//move horizontally....
		aMazePaths(n,m,psf+"h",i,j+1);

		//now will go vertically
		aMazePaths(n,m,psf+"v",i+1,j);
		
		
		
    }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        inputLine = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        aMazePaths(n, m, "",1,1);
  }
}
