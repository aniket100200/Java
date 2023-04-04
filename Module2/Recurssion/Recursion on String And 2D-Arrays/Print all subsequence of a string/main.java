import java.util.*;
import java.util.Scanner;

public class Main{
    static void printSubsequence(String s)
	{
        //Write your code here
		f(s,"");
    }
	static void f(String ques,String asf)
	{
		if(ques.length()==0)
		{
			System.out.print(asf+" ");
			return;
		}

		//as I have string first I'll select the first char 
		f(ques.substring(1),asf+ques.charAt(0));

		//now I'm not taking the first char due to this a range of char will be created

		f(ques.substring(1),asf);
			
		
	}
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubsequence(s);
    }
}
