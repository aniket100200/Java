import java.util.*;

class Solution {
    public int setBits(int n)
	{
        // write code here	
		int count=0;
		int x=1;
		while(x<=n)
		{
			int y=n&x;
			if(y!=0)count++;
			x<<=1;
		}
		return count;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setBits(n));
    }
}
