import java.util.*;

public class Main
{
    static int[] avoidFlood(int[] rains)
    {
		//Write your code here
		int n=rains.length;
		int[] ans=new int[n];
		
HashMap<Integer,Integer> lastRain=new HashMap<>();
		TreeSet<Integer>dry=new TreeSet<>();
		for(int i=0;i<n;i++)
		{
			int lake=rains[i];
			if(lake==0)
			{
				//dry day..
				dry.add(i);
				ans[i]=1;
			}
			else
			{
				//it's raining...
				if(lastRain.containsKey(lake)==false)
				{
					//first time it is raining...
					lastRain.put(lake,i);
				}
				else
				{
					//this is Second time it's raining...
					//lets find the dry day for this..
					int last=lastRain.get(lake);
					Integer dryDay=dry.higher(last);
					if(dryDay==null)return new int[0];
					ans[dryDay]=lake;
					lastRain.put(lake,i);
					dry.remove(dryDay);
				}
				ans[i]=-1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] rains = new int[n];
		for(int i=0; i<n; i++)
		{
		    rains[i] = input.nextInt();
		}
		int[] ans = avoidFlood(rains);
		for(int i=0; i<ans.length; i++)
		{
		    System.out.print(ans[i]);
		    System.out.print(" ");
		}
if(ans.length==0)
System.out.print(" ");
	}
}
