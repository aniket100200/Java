import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] intervals, int a, int b) 
	{
        // Write your code here
		Arrays.sort(intervals,(a1,a2)->{
			return a1[0]-a2[0];
		});
		
		for(int[] inter: intervals)
		{
			while(inter[0]<=a && a<=inter[1])a++;
			if(a>b)return true;
		}
		
		return false;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
	    Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
