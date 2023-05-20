import java.util.*;

class Solution {
    static void minShippingWeight(int a[], int n,int D)
    {
        //Write your code here
		int si=0;
		int ei=0;
		for(int i: a)
		{
			si=Math.max(si,i);
			ei+=i;
		}
		int pans=0;
		while(si<=ei)
		{
			int mid=si+ei>>1;
			if(isPossible(a,mid,D))
			{
				//if it is possible to shift with this weight..mid 
				//within D day's
				pans=mid;
				ei=mid-1;
			}
			else
			{
				//as it is not possible then increase the weight..
				si=mid+1;
			}
		}
       System.out.println(pans);
    }
	public static boolean isPossible(int[] p,int wt,int d)
	{
		int days=1;
		int curr=0;
		
		for(int i: p)
		{
			if(curr+i<=wt)
			{
				curr+=i;
				
			}
			else
			{
				//we'll something called left..
				days++;
				curr=i;
			}			
		}
		return days<=d;
	}

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int D= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.minShippingWeight(array,n,D);
    }
}
