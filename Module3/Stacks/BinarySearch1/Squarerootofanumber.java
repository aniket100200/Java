import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A)
	{
		/*** Tc: O(logn) && sc: O(1)   ********/
        // your code here
		//let's find  with the Binary search... 
		//we'll search for the square root...
		long pans=0;
	//let's decide the search space..
		long si=1;
		long ei=A;
	
		while(si<=ei)
		{
			//let's divide... 
			long mid=(si+ei)/2;
			if(mid*mid==A)
			{
				System.out.print(mid);
				
			return;
			}
			else if(mid*mid>A)
			{
				
				//as it greate so move towards left..
				ei=mid-1;				
			}
			else
			{
			//you have to find floor value... here we goo...
				pans=mid;
				si=mid+1;
			}
		}
	
		System.out.println(pans);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}
