
import java.util.*;

class Main{
	public static void main(String[] args){
		Solution ob = new Solution();
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int []nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            int[] ans=ob.singleNumber(nums);
            System.out.println(Math.min(ans[0],ans[1])+" "+Math.max(ans[1],ans[0]));
		}
			
	}
}


class Solution {
	int find(int x)
	{
		int count=0;
		while(x>0)
		{
			if((x^1)==0)return count;
			count++;
			x>>=1;
		}
		return -1;
	}
    public int[] singleNumber(int[] nums) {
		// Your Code Here
		//always there will two answers... we'll use xor operator..
		int ans=0;
		for(int i: nums)
		{
			ans^=i;
		}
		//System.out.print(ans);
		//as I've to find the answer.. 
			int xth=find(ans);//xth bit is fixed..>><<
	
		// we'll group those individuals having the xth bit is set>
		int xthSet=0;
		int xthNset=0;
		for(int i: nums)
		{
			if(setOrNot(i,xth))
			{
				xthSet^=i;
			}
			else xthNset^=i;
		}
		return new int[]{xthSet,xthNset};

    }
	public boolean setOrNot(int i,int x)
	{
		if((i&(1<<x))==0)return true;
		return false;
	}
}
