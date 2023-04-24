import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = Solution.findEquilibriumIndex(a);
        System.out.println(ans);
    }
}

class Solution {
    static int findEquilibriumIndex(int[] a)
	{
        //Write code here
		int tSum=0;
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			tSum+=a[i];
		}
	int left=0;
		for(int i=0;i<n;i++)
		{
			//let's see a prsent index is equillibrium or not..
			tSum-=a[i];
			if(left==tSum)
			{
				return i;
			}
			left+=a[i];
		}
		return -1;
		
    }
}
