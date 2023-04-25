import java.util.*;
 
class Solution {
 public boolean isSet(int n, int k)
{
	 int mask=1<<k;
	return (mask&n)!=0;
 }
    public int Opposite(int n) 
	{
        // write code here
		int[] a=new int[32];
		for(int i=0;i<32 ;i++)
		{
			if(isSet(n,i))a[i]++;
		}
		int leftMostBit=-1;
		for(int i=0;i<32;i++)
		{
			if(a[i]==1)leftMostBit=i;
		}
		if(leftMostBit==-1)return 0;
int ans=0;
		for(int i=0;i<=leftMostBit;i++)
		{
			if(a[i]==0)ans|=(1<<i);
		}
		return ans;
    }
}
 
 
public class Main {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.Opposite(n));
    }
}
