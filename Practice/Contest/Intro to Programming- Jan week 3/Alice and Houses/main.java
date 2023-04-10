/*O2(N) Solution */
/*as we are travelling in an array takes O(n) time and for every element we'll also O(n) time to find whether it is leader or not*/
import java.io.*;
import java.util.*;

class Solution{
    static ArrayList<Integer> leaders(int arr[], int n){
        //Write your code here
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			if(isLeader(arr[i],i,arr))
			{
				ans.add(arr[i]);
			}
		}
		return(ans);
    }
	static boolean isLeader(int ele, int pos,int[] a)
	{
		for(int i=pos+1;i<a.length;i++)
		{
			if(a[i]>ele){
				return(false);
			}
		}
		return(true);
	}
}
public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int arr[] = new int[n];
        String inputLine[] = br.readLine().trim().split(" ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(inputLine[i]);
        }    
        Solution obj = new Solution();  
        StringBuffer str = new StringBuffer();
        ArrayList<Integer> res = new ArrayList<Integer>();        
        res = obj.leaders(arr, n);
        for(int i=0; i<res.size(); i++){
            str.append(res.get(i)+" ");
        }
        System.out.println(str);  
    }
}
