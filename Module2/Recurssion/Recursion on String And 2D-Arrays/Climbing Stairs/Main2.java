import java.util.*;
import static java.lang.Math.ceil;

class Accio 
{
    public int ClimbingStairs(int n) 
	{
		    if(n==1)return 1;
			if(n==2)return 2;
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
