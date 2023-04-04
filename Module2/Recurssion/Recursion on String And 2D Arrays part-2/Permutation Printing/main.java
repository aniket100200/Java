import java.util.*;
  
public class Main{
  
   public static void main(String[] args) 
	{
      Scanner scn = new Scanner(System.in);
      String s=scn.nextLine();
      String asf="";
      permutationPrint(s,asf);
   }
   public static void permutationPrint(String ques, String asf)
    {
        // your code here
		//this will be my base condition
		if(ques.length()==0)
		{
			System.out.println(asf);
			return;
		}
		// abc;
		//there may be possiblity to selction of each characher
		// in this permutation all the charachter should be present the in the anserwer string 
		// firstly we will select the char and question string to be soved okay
		//here we go

		//it gives the sense of for loop
		for(int i=0;i<ques.length();i++)
		{
			char c=ques.charAt(i);// this will give the char to be added in the answer string
			String ques2=ques.substring(0,i)+ques.substring(i+1);
			// this will give the ques and char to be added int eh string 
		permutationPrint(ques2,asf+c);
			
		}

		
    }
  }
