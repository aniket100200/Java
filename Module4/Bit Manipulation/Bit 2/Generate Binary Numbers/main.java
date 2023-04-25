import java.util.*;

class Solution {
	public void toBinary(int n)
	{
		if(n==0)return;
		toBinary(n>>1);
		System.out.print((n&1));
		
	}
    public void binaryRepresentation(int n)
	{
        //Write code here and print output
		for(int i=1;i<=n;i++){toBinary(i); System.out.print(" ");}
	
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Solution Obj = new Solution();
        Obj.binaryRepresentation(n);
        sc.close();
    }
}


