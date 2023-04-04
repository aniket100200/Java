import java.util.*;

class Main {
	public static long xPowerN(int x, int n)
	{	/*** Log(n) Solution *****/
		if(n==0)return 1;
		if(n==1)return x;

		if(n%2!=0)
		{
			return x*xPowerN(x,n/2)*xPowerN(x,n/2);
		}
		return xPowerN(x,n/2)*xPowerN(x,n/2);
		
	}
	public static void main(String[] args)
	{
    		Scanner sc = new Scanner(System.in);
    		int x = sc.nextInt();
    		int n = sc.nextInt();
		System.out.println(xPowerN(x, n));
	}
}
