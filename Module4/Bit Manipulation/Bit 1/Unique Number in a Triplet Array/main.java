import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	
	static boolean  isSet(int n,int k)
	{
			int mask=1<<k;
			return (mask&n)!=0;
	}
    public static  int singleNumber(int[] nums) 
		{
        int[] fre=new int[32];
				for(int x:nums)
				{
						for(int i=0;i<32;i++)
						{
								if(isSet(x,i))fre[i]++;
						}
						
				}
				//I've the frequencies of all the bits.. '
				int ans=0;
				for(int i=0;i<32;i++)
				{
					if(fre[i]%3!=0)ans|=(1<<i);
				}
				return ans;
    }
}
public class Main {
  public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Solution.singleNumber(nums));
	}
}
