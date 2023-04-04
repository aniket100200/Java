import java.io.*;
import java.util.*;
public class Main {
  public static void multiplyRecursively(int n, int m) 
	{
    //Write code here and print output
	  f(n,m,0);
  }
	public static void f(int n, int m, int sum)
	{
		if(n==0)
		{
			System.out.println(sum);return;
		}
	
		f(n-1,m,sum+m);
	}
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    multiplyRecursively(n, m);
  }
}
