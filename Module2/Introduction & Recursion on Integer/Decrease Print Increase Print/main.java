import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
	int n = scn.nextInt();
    printDI(n);
  }

  public static void printDI(int n)
	{
    // your code here
		Dp(n,1);
		Ip(1,n);
		
  }
	static void Dp(int n, int dest)
	{
		if(n==dest)
		{
			System.out.println(dest);
			return;
		}
		System.out.println(n);
		Dp(n-1,dest);
	}
	static void Ip(int n, int dest)
	{
		if(n==dest)
		{
			System.out.println(dest);
			return;
		}
		System.out.println(n);
		Ip(n+1,dest);
	}
}
