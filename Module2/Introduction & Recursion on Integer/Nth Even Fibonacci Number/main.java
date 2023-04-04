import java.util.*;
import static java.lang.Math.ceil;

public class Main {
	static int mod=1000000007;
	private static int count=0;
	static long f(long n) 
	{
        Write your code here
		if(n<1)
		{
			return 0;
		}
		if(n== 1)
		{
			return 2;
		}
		return ((4*(f(n-1)%mod))+(f(n-2)%mod))%mod;
		if(count==n)
		
    }
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(f(n));
    }
}
