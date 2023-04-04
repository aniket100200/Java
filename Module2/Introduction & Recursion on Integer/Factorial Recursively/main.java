import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial_recursive(n));
        sc.close();
    }

    public static long factorial_recursive(int n) {
        // your code here
		if(n==1)return 1;
		return n*factorial_recursive(n-1);
    }
}
