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
		//let's chek if it is valid to travel or not..

		int tPet=0;
		int tDis=0;
		for(int i=0;i<petrol.length;i++){
			tPet+=petrol[i];
			tDis+=distance[i];
		}
		if(tPet<tDis)return -1;
		//this means ans does exists..

		//let's find the ans..
		int idx=-1;
		int total=0;
		for(int i=0;i<petrol.length;i++)
		{
			int diff=petrol[i]-distance[i];
			total+=diff;
			if(total<0)
			{
				idx=-1;
				total=0;
			}
			else
			{
				if(idx==-1)idx=i;
			}
		}
		return idx;
	}
}
