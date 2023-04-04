import java.util.*;

public class Main {
    static String PairStar(String str)
	{
        //Write your code here
		//StringBuilder sb=new StringBuilder();
		if(str.length()==0)
		{
			return "";
		}
		if(str.length()>1)
		{
			if(str.charAt(0) == str.charAt(1))
			{
				return str.substring(0,1)+"*"+PairStar(str.substring(1));
			}
		}
		return str.substring(0,1)+PairStar(str.substring(1));
		
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(PairStar(s));
    }
}
