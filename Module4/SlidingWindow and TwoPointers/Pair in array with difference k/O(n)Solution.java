import java.io.*;
import java.util.*;
class Main{
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
          a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));		    
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k)
	{
        //Write code here
		if(k!=0)
		{
			HashSet<Integer> set=new HashSet<>();
			HashSet<Integer> ans=new HashSet<>();
			for(int i: nums)
			{
				set.add(i-k);
			}
			for(int i: nums)
			{
				if(set.contains(i))ans.add(i);
			}
			return ans.size();
		}
		else
		{
			HashMap<Integer,Integer>map=new HashMap<>();
			for(int i: nums)
			{
				map.put(i,map.getOrDefault(i,0)+1);
			}
			int count=0;
			for(int i: map.keySet())
			{
				if(map.get(i)>1)count++;
			}
			return count;
		}
    }
}
