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
	}

	void push(int x)
	{
        //Write Code here	
		//how will you push...
		s.push(x);//done>>><<<
    }
	
	int pop()
	{
        //Write Code here
		if(s.isEmpty()){
			return -1;
		}
		return s.pop();
	}

    int getMin()
	{ //O(N)///
		if(s.isEmpty())return -1;
        //Write Code here
		Stack<Integer> temp=new Stack<>();
		int min=Integer.MAX_VALUE;
		while(s.size()>0)
		{
			int val=s.pop();
			min=Math.min(min,val);
			temp.push(val);
		}

		//let's rearrange in the same order... 
		//as it is arranaged in diffrent order...

		while(temp.size()>0)
		{
			s.push(temp.pop());
		}
		return min;
		
	}	
}
