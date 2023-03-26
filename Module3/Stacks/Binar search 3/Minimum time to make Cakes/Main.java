import java.util.*;

class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
			int t=sc.nextInt();
			while(t>0){
				int n=sc.nextInt();
				int []A=new int[n];
				int m=sc.nextInt();
				int k=sc.nextInt();
				for(int i=0;i<n;i++){
					A[i]=sc.nextInt();
				}
				Solution ob =new Solution();
				int ans = ob.minDays(A,n,m,k);
				System.out.println(ans);
				t--;
			}
		}
	}

}
class Solution 
{
    public int minDays(int[] bloomDay,int n, int m, int k)
	{
			//k--> is consecative flavers...
			//m--> no. of cackes to be made...
			//whose range do you have..

		int si=1;
		int ei=Integer.MIN_VALUE;
		for(int b: bloomDay)
		{
			ei=Math.max(b,ei);
		}
		//I've lower and upper limit...
		int pans=-1;
		while(si<=ei)
		{
			int mid=(si+ei)/2;
			if(isPossible(bloomDay,m,k,mid))
			{
				pans=mid;
				ei=mid-1;
				
				
			}
			else
			{
				si=mid+1;
				
			}
		}
		return pans;
	}
	static boolean isPossible(int[] days,int numOfCakes, int flavours,int mid)
	{
		int cakeCount=0;
		int flavour=0;
		for(int i=0;i<days.length;i++)
		{
			if(days[i]<=mid)
			{
				flavour++;
				if(flavour==flavours)
				{
					cakeCount++;
					flavour=0;
				}
			}
			else
			{
				flavour=0;
			}
			
		}
	return cakeCount>=numOfCakes;
		
	}
}
