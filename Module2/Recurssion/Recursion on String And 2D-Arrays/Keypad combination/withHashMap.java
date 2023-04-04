import java.io.*;
import java.util.*;

public class Main {
    static void printKPC(String ques)
	{
        //Write your code here
		//let's map all the keys with index
		HashMap<Character,String> map=new HashMap<>();
		map.put('0',".;");
		map.put('1',"abc");
		map.put('2',"def");
		map.put('3',"ghi");
		map.put('4',"jkl");
		map.put('5',"mno");
		map.put('6',"pqrs");
		map.put('7',"tu");
		map.put('8',"vwx");		
		map.put('9',"yz") ; 
		f(ques,"",map);
	}

	public static void f(String ques,String asf,HashMap<Character,String> map)
	{
		if(ques.length()==0){System.out.println(asf);return;}
		//let's get first character...
		char ch=ques.charAt(0);
		//let's see in map....
		String key=map.get(ch);
		//I've the so we'll have take all the possible combinations of the key..
		for(int i=0;i<key.length();i++)
		{
			f(ques.substring(1),asf+key.charAt(i),map);
		}
		
	}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        printKPC(str);
    }
}
