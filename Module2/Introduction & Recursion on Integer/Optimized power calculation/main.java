import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int X,N;
        X = sc.nextInt();        
        N = sc.nextInt();

        System.out.println(power(X,N));		
    }

	public static long power(int x, int y)
    {
		//Write code here
		if(y==0)return 1;

		//if your power is Even then what will you do
		if(y%2==0)
		{
			return power(x,y/2)*power(x,y/2);
		}

		//if your power is odd mean value of y then

		return x*power(x,y/2)*power(x,y/2);
    }
}
