import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//you have to print all the 
		int x=32;
		f(x,1,n);
	}
static void f(int x,int mask,int n)
{
	if(x==0)return;
	f(x-1,mask,n>>1);
	System.out.print((n&mask));
}
}
