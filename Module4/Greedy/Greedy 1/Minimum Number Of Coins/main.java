import java.io.*;
import java.util.*;
class Solution{
    public void coinChange(int num)
	{
       // your code here
	int[] arr=new int[]{500,100,50,20,10,5,2,1};
		for(int i: arr)
		{
			
			if(num/i>0)
			{
				System.out.println("Number of "+i+" Rupees Notes: "+num/i);
				num%=i;
			}
			else{
				System.out.println("Number of "+i+" Rupees Notes: "+0);
			}
		}
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Solution obj=new Solution();
        obj.coinChange(n);
	}
}
