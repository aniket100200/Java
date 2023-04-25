import java.util.Scanner;

class Solution{
	public static int setBit(int n,int k)
	{
		int mask=1<<k;
		return (n|mask);
	}
public static int findComplement(int num)
	{
	//Write your code here
		int mask=1;
		int ans=0;
		int count=0;
		while(num>=mask)
		{
			if((num&mask)==0)ans=setBit(ans,count);
				count++;
			mask<<=1;
		}
		return ans;
    }
}
public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	System.out.println(Solution.findComplement(num));
	sc.close();
    }
}
