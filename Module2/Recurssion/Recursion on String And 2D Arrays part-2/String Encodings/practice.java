import java.util.*;

public class Main 
{
    public static void printEncodings(String str)
	{
	    f(str,"");		
    }
	public static void f(String ques,String asf)
	{
		if(ques.length()==0)
		{
			System.out.println(asf);return;
		}
		//let's fir conver first character...
		if(ques.charAt(0)=='0')return;
		 int first=ques.charAt(0)-'0';

		//let's convert this integer.. to character...
		char rchar=(char)(first+'a'-1);//upcasting.... automatically...
		f(ques.substring(1),asf+rchar);

		if(ques.length()>1)
		{
			//let's get two cahar at a time..
			String st=ques.substring(0,2);
			//let's convert the string into the number..
			int req=Integer.parseInt(st);
			if(req>0 && req<26)
			{
				char rch=(char)(req+'a'-1);
				f(ques.substring(2),asf+rch);
			}
			
		}
		
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}
