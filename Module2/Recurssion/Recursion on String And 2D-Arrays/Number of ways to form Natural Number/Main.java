import java.io.*;
import java.util.*;
public class Main {
    public static long ways(int n, int i)
	{
//Write your code here
		
		return solve(n,n);
    }
	static long solve(int target, int digit)
{
	if(target==0 )
	{
		
		return 1;
	}
	if(target<0  || digit==0)return 0;
	
long ans=0;
	//first take the digit 	
	ans+=solve(target-digit,digit-1);

	//possible subsequences we'll have the 
	//do not take then present digit
	ans+=solve(target,digit-1);
	return ans;
}
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(ways(n, 1));
    }
}
