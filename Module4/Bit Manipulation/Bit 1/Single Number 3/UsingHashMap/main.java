import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums)
	{
        // write code here
		Map<Integer,Integer> map=new HashMap<>();
		for(int i: nums){
			map.put(i,map.getOrDefault(i,0)+1);
		}
		int[] ans=new int[2];
		int i=0;
		for(int key: map.keySet())
		{
			if(map.get(key)==1)ans[i++]=key;
		}
		if(ans[0]>ans[1])
		{
			int temp=ans[0];
			ans[0]=ans[1];
			ans[1]=temp;
		}
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}
