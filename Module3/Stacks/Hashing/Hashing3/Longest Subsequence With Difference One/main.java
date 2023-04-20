import java.util.*;

class Accio {
    public int longestSubsequence(int[] nums) 
	{   
			int d=1;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i: nums)
		{
			map.put(i,1+Math.max(map.getOrDefault(i-d,0),map.getOrDefault(i+d,0)));
		}
		int max=0;
		for(int key: map.keySet())
		{
			//System.out.println(key+"-->"+map.get(key));
			max=Math.max(max,map.get(key));
		}
		
		return max;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
    	for(int i=0;i<N;i++)
	    nums[i] = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestSubsequence(nums));
    }
}
