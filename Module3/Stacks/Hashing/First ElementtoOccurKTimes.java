import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] arr, int n, int k)
	{
        // Your code here
		//I can see wich one is we have to see k times...
		HashMap<Integer,Interger> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
			if(map.get(arr[i])==k)
			{
				System.out.println(arr[i]);
				return;
			}
		}
		System.out.println(-1);
        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}
