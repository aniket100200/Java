import java.util.*;
import java.lang.*;
import java.io.*;

public class Main 
{

    public static String largestNumber(final int[] A)
	{
        // your code here
		String[]arr=new String[A.length];
		for(int i=0;i<A.length;i++)
		{
			arr[i]=String.valueOf(A[i]);
		}

		//let's sort these guys..
		Arrays.sort(arr,new Comparator<String>(){
			public int compare(String a,String b){
				String x=a+b;
				String y=b+a;
				return y.compareTo(x);
			}
		});
		StringBuilder sb=new StringBuilder();
		for(String i: arr){
			sb.append(i);
		}
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
