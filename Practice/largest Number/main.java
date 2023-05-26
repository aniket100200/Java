import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    public static String largestNumber(final int[] A) 
	{
        // your code here
		int n=A.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				String s=""+A[i]+A[j];
				String b=""+A[j]+A[i];
				if(Integer.parseInt(s)<Integer.parseInt(b))
				{
					int temp=A[i];
					A[i]=A[j];
					A[j]=temp;
				}
				
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i: A)sb.append(i);
		return sb.toString();
    }
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
        int arr[] =new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print(largestNumber(arr));
	}
}
