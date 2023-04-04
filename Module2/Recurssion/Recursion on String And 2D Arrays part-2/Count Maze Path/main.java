import java.io.*;
import java.util.*;

public class Main{
    static int countMazePath(int n, int m)
    {
        //Write your code here
		if(n<1 || m<1)return 0;
		if(n==1 && m==1)
		{
			return 1;
		}
		int ans =0;
		ans+=countMazePath(n-1,m);
		ans+=countMazePath(n,m-1);
		return ans;
    }
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(countMazePath(n, m));
    }
}
