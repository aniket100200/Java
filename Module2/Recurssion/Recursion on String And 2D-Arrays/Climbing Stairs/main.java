import java.util.*;
import static java.lang.Math.ceil;

class Accio {
    public int ClimbingStairs(int n)
	{
        // Write your code here
		if(n==2 || n==1)
		{
			return n;
		}
		
//let's climb 1 step.. at time..

		return ClimbingStairs(n-1)+ClimbingStairs(n-2);
		
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.ClimbingStairs(n));
    }
}
