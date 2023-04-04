import java.io.*;
import java.util.*;

public class Main {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf)
	{
        //Write your code here
		if(sr>dr || sc>dc)
		{
			return;
		}
		if(sc==dc && sr==dr){
			System.out.println(psf);
			return;
		}

		//wanted to take one or more jump horizontally.... but how many jumps can i make 
		//dc-sc;
		for(int i=1;i<=dc-sc;i++)
		{
			printMazePaths(sr,sc+i,dr,dc,psf+"h"+i);
		}

		//now how many vertical jumps can i make
		// lets say your present row is sr and destination is dr =dr-sr
		 for(int i=1;i<=dr-sr;i++)
		 {
			 printMazePaths(sr+i,sc,dr,dc,psf+"v"+i);
		 }


		///as I have to move digonally then how it is possible to make it
		// as you are standing in the sr row and sc colom but you can move digonally with min(dr-sr,dc-sc);

		for(int i=1;i<=Math.min(dr-sr,dc-sc);i++)
		{
			printMazePaths(sr+i,sc+i,dr,dc,psf+"d"+i);
		}
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}
