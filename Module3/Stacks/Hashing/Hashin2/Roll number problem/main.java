import java.util.*;

class Solution 
{
    static int[] findRepeatingAndMissingNumbers(int[] nums) 
    {
        //Write code here and print output
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		//I've mapped RollNO. with frequency...
		
		for(int i=0;i<nums.length;i++)
		{
			hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
		}
		ArrayList<Integer> dup=new ArrayList<>();
		ArrayList<Integer> miss=new ArrayList<>();
		for(int i=1;i<=nums.length;i++)
		{
			if(hm.containsKey(i) && hm.getOrDefault(i,0)>=2)
			{
				dup.add(i);
			}
			else if(!hm.containsKey(i))
			{
				miss.add(i);
			}
		}
		int[] ans=new int[dup.size()+miss.size()];
		{
			int i=0;
		while(dup.size()>0)
		{
			ans[i++]=dup.remove(0);
		}
			while(miss.size()>0)
		{
			ans[i++]=miss.remove(0);
		}
		}
		return ans;
		
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans = Solution.findRepeatingAndMissingNumbers(nums);
        System.out.print(ans[0] + " " + ans[1] + "\n");
    }
}
