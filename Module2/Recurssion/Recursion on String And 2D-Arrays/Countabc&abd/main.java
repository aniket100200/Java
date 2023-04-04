import java.util.*;

public class Main
{
    static int CountABC(String str, int i)
	{
        // Write your code here
		if(str.length()<3)
		{
			return 0;
		}
		if(str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba"))
		{
			return 1+CountABC(str.substring(1),i);
		}
		return CountABC(str.substring(1),i);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(CountABC(s, 0));

    }
}
