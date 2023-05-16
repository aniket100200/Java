import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean splitOdd10(int[] nums) 
{
        // your code here
	return isPossible(nums,0,0,0) ? true : false;
}
	boolean isPossible(int[] nums,int i,int grp1,int grp2)
	{
		if(i==nums.length)
		{
			if((grp1%10==0 && grp2%2==1)|| (grp2%10==0 && grp1%2==1))return true;
			return false;
		}
		if(isPossible(nums,i+1,grp1+nums[i],grp2))return true;
		if(isPossible(nums,i+1,grp1,grp2+nums[i]))return true;
		return false;
	}

}
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[]=new int[N];
        for(int i = 0; i < N; i++)
        {
            arr[i] = sc.nextInt();
        }

        Solution obj=new Solution();

        if(obj.splitOdd10(arr))
         System.out.println("YES");
         else
         System.out.println("NO");
    }
}
