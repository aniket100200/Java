import java.util.*;
import java.io.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        int ans = Solution.bestTimeToBuyAndSell(n,a);
        System.out.println(ans);
    }
    
}
 
 
class Solution {
  static int bestTimeToBuyAndSell(int n, int[] prices) 
{
	TreeSet<Integer> set=new TreeSet<>();
	int max=0;
	for(int i: prices)
	{
		if(set.size()>0)
		{
			int min=set.first();
			if(min<i)
			{
				max=Math.max(max,i-min);
			}
		}
		set.add(i);
	}
	return max;
}
}
