import java.util.*;

class Solution
	{
    public int[] asteroidCollision(int[] asteroids)
	{
        ///to solve this we need Stack.. and we have to return the 
		//whol will be the element's will have...
		Stack<Integer> st=new Stack<Integer>();	
		for(int asteroid: asteroids)
		{
			if(asteroid>0)
			{
				//this is moving towards right means it'll not affected by know univers..
				//will be affected by unknown universe...
				st.push(asteroid);
			}
			else
			{
				//means asteroid is coming towards.. left...
				while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(asteroid))
				{
					//this means asteroid is coming towards left is bigger than than 
					//the first asteroid in the stack... 
					//so he will destroy.. present one...
					st.pop();
				}

				if(st.size()>0 && st.peek()>0 && st.peek()>Math.abs(asteroid))
				{
					//if peeked asteroid is bigger than asteroid coming towards know universe..
					//so he will destroyed...
					continue;
				}

				else if(st.size()>0 && st.peek()>0 && st.peek()==Math.abs(asteroid))
				{
					st.pop();
				}
				else
				{
					st.push(asteroid);
				}

				
			}
		}
		int[] ans=new int[st.size()];
		for(int i=ans.length-1;i>=0;i--)
		{
			ans[i]=st.pop();
		}
		return ans;
	}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}
