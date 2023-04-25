import java.util.*;

class Accio{
    static int HammingDistance(int a,int b)
	{
        //write code here
		int count=0;
		int c=(a^b);
		while(c!=0)
		{
			count++;
			c&=(c-1);
		}
		return count;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.HammingDistance(a,b);
        System.out.println(ans);
    }
}
