//That was brutz force approach... well do getMIN in O(1) complexity..
import java.util.*;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			Solution g = new Solution();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
        sc.close();
		
	}
}

class Solution
{
	public class pair
	{
		int val;
		int minEle;
		pair(int val , int minEle)
		{
			this.val=val;
			this.minEle=minEle;
		}
	}
	Stack<pair> s;
    
	Solution()
	{
		s = new Stack<pair>();
	}

	void push(int x)
	{
        //Write Code here	
			//I've to push min as well as element..
		if(s.isEmpty())
		{		
			s.push(new pair(x,x));
	    }
		else
		{
			s.push(new pair(x,Math.min(x,s.peek().minEle)));
		}
	}
	
	int pop()
	{
        //Write Code here
		if(s.size()>0)
		{
			return s.pop().val;
		}
		return -1;
	
	}
	

    int getMin()
	{
        //Write Code here
		if(s.size()>0)
		{
			return s.peek().minEle;
		}
		return -1;
	}	
}
