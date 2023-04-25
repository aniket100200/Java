import java.util.*;

class Solution{
    public static int countBitsFlip(int a, int b)
	{
       // Your code here
		int ans=(a^b);
		//let's count 
		//no of set bits..
		int count=0;
		int x=32;
		int mask=1;
		while(ans!=0)
		{
			count++;
			ans&=(ans-1);			
		}
		return count;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(Solution.countBitsFlip(a,b));
    }
}
