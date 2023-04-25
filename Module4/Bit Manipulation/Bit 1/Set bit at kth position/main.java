import java.util.*;

class Solution {
    public int setKBit(int n, int k) 
	{
        // write code here
		//we have to set... well do or operation...
		int mask=(1<<k);
		n=n|mask;
		return n;
    }
}

public class Main {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        sc.close();
        System.out.println(Obj.setKBit(n, k));
    }
}
