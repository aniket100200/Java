import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static long longestConsecutiveSequence(int A[], long n) 
    { 
       //your code here
		Set<Integer> set=new HashSet<>();
		for(int i: A)set.add(i);

		//
		long ans=0;
	
		for(int i: A){
			if(set.contains(i-1)==false)
			{
				int x=i;
				long curr=1;
				while(set.contains(x+1)){
					curr++;
					x++;
				}
				ans=Math.max(ans,curr);
			}
		}
		return ans;
    } 
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        System.out.println(longestConsecutiveSequence(arr, n));
		
	}
}



