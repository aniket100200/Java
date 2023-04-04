import java.util.*;

public class Main {
	static long NumberSum(long N)
	{
        //Write your code here
		long ans=N;
		if(N==1)return ans;
		return ans+NumberSum(N-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        System.out.println(NumberSum(N));
    }
}
