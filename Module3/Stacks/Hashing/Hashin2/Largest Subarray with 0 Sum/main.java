import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
   public int maxLen(int arr[])
	{
		// Write your code here
		HashMap<Integer,Integer> map=new HashMap<>();
		map.put(0,-1);
		int pref=0;
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			pref+=arr[i];
			if(map.containsKey(pref))
			{
				max=Math.max(max,i-map.get(pref));
			}
			else
			{
				map.put(pref,i);
			}
			
		}
		return max;
	}
}

class Main {
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution Obj = new Solution();
		System.out.println(Obj.maxLen(nums));
	}
}
