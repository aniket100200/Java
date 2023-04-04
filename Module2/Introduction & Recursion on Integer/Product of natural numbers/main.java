import java.util.*;

public class Main {
	static long product(int n)
	{
		//Write code here
		long ans=n;
		if(n==1){return ans;}
		return ans*product(n-1);
		
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(product(n));
    }
}
