import java.util.*;
class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			int p[] = new int[n];
			int d[] = new int[n];
			
			for(int i=0; i<n; i++)
			{
				p[i]=sc.nextInt();
			}

		for(int i=0; i<n; i++)
			{
				d[i]=sc.nextInt();
				
			}
			System.out.println(new Solution().tour(p,d));
	}
}
class Solution
{
		int tour(int petrol[], int distance[])
	{
		Queue<Integer> q=new LinkedList<>();
		int sum=0;
		int count=0;
		int n=petrol.length;
		int j=0;
		while(q.size()<n && count<2*n)
		{
		//>>>>>>>>>>>>>><<<<<<<<<<
			int diff=petrol[j]-distance[j];
			q.add(diff);
			sum+=diff;
			while(sum<0 && q.size()>0)
			{
				sum-=q.poll();
			}
			j=(j+1)%n;
			count++;
		}
		if(count>=2*n)
		{
			return -1;
		}
		return j;
	}
}
