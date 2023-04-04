import java.io.*;
import java.util.Scanner;

public class Main {

    static boolean isPalindrome(String str)
	{
        // Write your code here
		return f(str,0,str.length()-1);
    }
	static boolean f(String str,int i, int j)
	{
		if(i>j)return true;
		if(str.charAt(i)!=str.charAt(j)){return false;}

		return f(str,i+1,j-1);
		
	}
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        boolean result=isPalindrome(str);
        if(result)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
