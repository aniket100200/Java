import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    sc.close();
    System.out.println(countEncodings(str));
  }

  public static int countEncodings(String str)
{
    // your code here
	if(str.length()==0){return 1;}
	if(str.charAt(0)=='0')
	{
		return 0;
	}

	//for every single char he will return 
	int ans=0;
	ans+=countEncodings(str.substring(1));
	// two number char
	if(str.length()>=2){int n=Integer.parseInt(str.substring(0,2));
	if(n>=1 && n<=26)
	{
		ans+=countEncodings(str.substring(2));
	}}
	return ans;
}
}
