import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt();
        boolean ans = Solution.isPossibleToSurvive(n, x, d);
        if(ans) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
class Solution {
    
    static boolean isPossibleToSurvive(int n, int x, int d )
    {
        // Your code here
		int shopOpen=1;
		int food=0;
		//you need x unit of food per day..
// count of Days?
		int count=0;
		while(d-->0)
		{
			count++;
			if(count%7==1 && food>=0)
			{
				//I can buy new food.
				food+=n;
				count=0;
			}
			
			food-=x;
			if(food<0)return false;
		}
		return true;
    }  
}
