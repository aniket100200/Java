import java.util.*;

class Solution {

    public int solve(int arr[],int n) 
	{
        // Your code here
		int max=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]<=arr[j])
				{
					max=Math.max(j-i,max);
				}
			}
		}
		return max;
	}
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}
