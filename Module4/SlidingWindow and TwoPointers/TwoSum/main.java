import java.util.*;
import java.lang.*;
import java.io.*;

//Linear Solution O(N)-----<<<>>> 
//tell the interviewver direct approach... here we go....
class Main {
    
    public static int[] twoSum(int[] A, int target)
	{
       // Your code here
		//target..
	int i=0;
		int j=A.length-1;
		while(i<j)
		{
			if(A[i]+A[j]==target)
			{
				return new int[]{i+1,j+1};
			}
			else if(A[i]+A[j]<target)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		return new int[0];
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}



