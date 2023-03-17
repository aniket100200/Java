import java.io.*;
import java.util.*;

class Solution {
    public void mostFrequent(String []arr, int n)
	{
        // write your code here
		HashMap<String,Integer> map=new HashMap<>();
		int mx=0;
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
			mx=Math.max(mx,map.get(arr[i]))
;		}
		String ans="";
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i])==mx)
			{
				ans=arr[i];
				map.put(arr[i],0);
			}
		}
		System.out.println(ans);
	
		
		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String []arr = new String[n];
        for(int i=0;i<n;++i){
                arr[i] = sc.next();
        }
        Solution Obj = new Solution();
        Obj.mostFrequent(arr,n);  
        System.out.println('\n');
    }
}
