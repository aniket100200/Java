import java.io.*;
import java.util.*;

public class Main {
    static void printKPC(String ques)
	{
        //Write your code here
		String[] arr={".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
		f(ques,"",arr);
    }
	static void f(String ques,String asf, String[] arr)
	{
		if(ques.length()==0)
		{
			System.out.println(asf);
			return;
		}


		//firstly I'll get char at 0th position here we go
		char ch=ques.charAt(0);
		//I'll convert this char to an integer;
		int int_eq=ch-'0';
		//and i'll get My string corresponding to int_equ
		String First=arr[int_eq];
		
		//
		for(int i=0;i<First.length();i++)
		{
			//here I'm selceting a single char
			//because we have to find the combination of the keypad so we have to take a single char form signel number of keypad
			f(ques.substring(1),asf+First.charAt(i),arr);		
		}
	}

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        printKPC(str);
    }
}
