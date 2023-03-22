import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr)
	{
		int n=arr.length;
        // write code here
		//we'll map their diffrece .. i.e. d1#d2,with starting index..
		HashMap<String,Integer> map=new HashMap<>();
		int c0=0;
		int c1=0;
		int c2=0;
		int d1=0;//c1-c0
		int d2=0;//c2-c1
		int max=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==0)
			{
				c0++;
			}
			else if(arr[i]==1)
			{
				c1++;
				
			}
			else if(arr[i]==2)
			{
				c2++;
			}
		d1=c1-c0;
		d2=c2-c1;
			String key=d1+"#"+d2;
		if(map.containsKey(key))
		{
			int index=map.get(key);
			int length=i-index;
			max=Math.max(max,length);
		}
		else
		{
			map.put(d1+"#"+d2,i);
		}
			
		}
		return max;
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
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
