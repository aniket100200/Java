/*O(n) Solution....<<<>><><><><><><><><>*/
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
   int minPrice=Integer.MAX_VALUE;
	int maxProfit=0;
	for(int i=0;i<n;i++)
	{
		if(minPrice>prices[i])
		{
			minPrice=prices[i];
		}
		else
		{
			maxProfit=Math.max(maxProfit,prices[i]-minPrice);
		}
	}
	return maxProfit;
}
}
