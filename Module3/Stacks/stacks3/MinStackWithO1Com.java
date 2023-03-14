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
	int minEle;
	Stack<Integer> s;
    
	Solution()
	{
		s = new Stack<Integer>();
		// minEle=Integer.MAX_VALUE;
	}

	void push(int x)
	{
        if(s.isEmpty())
		{
			minEle=x;
			s.push(x);
		}
		else if(x<minEle)
		{
			
			s.push(x-minEle);
			minEle=x;			
		}
		else
		{
			s.push(x);
		}
    }
	
	int pop()
	{
       if(s.isEmpty())
		{ 
			return -1;
		}
		else if(s.peek()<minEle)
		{
			int prevMin=minEle-s.peek();
			s.pop();
			int val=minEle;
			minEle=prevMin;
			return val;
		}
		else
		{
			return s.pop();
		}
	}

    int getMin(){
		///O(1)...
        //Write Code here
		if(s.isEmpty())
		{		
			return -1;
					  
		}
		return minEle;
	}	
}
