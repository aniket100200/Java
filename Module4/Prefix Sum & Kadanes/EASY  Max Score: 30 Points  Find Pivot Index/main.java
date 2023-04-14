import java.util.*;

class Solution {
    public int pivotIndex(int[] arr)
	{
        //Write code here
		//prefix sum of left 
		int[]left=new int[arr.length];
		int[]right=new int[arr.length];
		left[0]=arr[0];
		right[arr.length-1]=arr[arr.length-1];
		for(int i=1;i<left.length;i++)	left[i]=arr[i]+left[i-1];
		
		for(int i=arr.length-2;i>=0;i--)right[i]=arr[i]+right[i+1];			
		//System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right));
		int i=0;
		int j=0;
		while(j<arr.length)
		{
			if(left[i]==right[j])return i;
			i++;
			j++;
		}
		return -1;
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
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}
