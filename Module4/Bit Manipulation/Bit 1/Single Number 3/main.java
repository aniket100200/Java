import java.util.*;

class Solution {
	public boolean isSet(int n, int k)
	{
		int mask=1<<k;
		return (n&mask)>0;
	}
    public int[] singleNumber3(int n, int[] nums)
	{
        // write code here
		//here are two single number.. let's do the 
		int xOr=0;
		for(int i: nums)
		{
			xOr^=i;
		}
		//this xOr conists of two elements..
		int k=0;
		int mask=1;
		while((mask&xOr)==0)
		{
			mask<<=1;
			k++;
		}

		//let's see as the kth bit is set we found in the xor of all..

		//let's divide in the two groupd...
		int kThBitSet=0;
		int kThBitNSet=0;
		for(int x: nums)
		{
			if(isSet(x,k))kThBitSet^=x;
			else kThBitNSet^=x;
		}
		int[] ans=new int[2];
		if(kThBitSet>kThBitNSet)
		{
			ans[0]=kThBitNSet;
			ans[1]=kThBitSet;return ans;
		}
		return new int[]{kThBitSet,kThBitNSet};
		
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
