import java.util.*;

public class Main {
    public static void printEncodings(String str)
	{
        // Write your code here

		f(str,"");
		
    }
	static void f(String str,String asf)
	{
		
		if(str.length()==0)
		{
			System.out.println(asf);
			return;
		}
		if(str.charAt(0)=='0')return;

		//firs take a sing char...

		char ch=str.charAt(0);
		int int_eq=ch-'0';//this will give the char
		char char_equ=(char)('a'+(int_eq-1));
		f(str.substring(1),asf+char_equ);

	//for two char togethr they can form number more than 26 firstly 
		//I'll convert the string int number
		if(str.length()>=2)
		{
			String local=str.substring(0,2);
		int n=Integer.parseInt(local);

		if(n>=1 && n<=26)
		{
			char temp=(char)('a'+n-1);
			f(str.substring(2),asf+temp);
		}
		}
		
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}
