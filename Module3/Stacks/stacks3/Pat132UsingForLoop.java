import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums)
	{
        //Write code here
		
		int first=0;
		int second=1;
		int third=2;
		while(third<nums.length)
		{
			if(nums[first]<=nums[third] && nums[third]<=nums[second])
			{
				return(true);
			}
			first++;
			second++;
			third++;
		}
		return(false);
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
        boolean result = Obj.find132pattern(arr);
        if (result)
            System.out.println("true");
        else
            System.out.println("false");
        sc.close();
    }
}
