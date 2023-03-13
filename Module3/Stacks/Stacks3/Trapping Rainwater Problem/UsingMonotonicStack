import java.io.*;
import java.util.*;

class Solution {
    public void TappingWater(int[] arr, int n)
	{
              //I'll go with next greater element to right ... 
		//Means using Monotonic stack..

		//let's look for next smaller element to right.. 

		Stack<Integer> st=new Stack<>();
			int totalWater=0;
		for(int i=0;i<arr.length;i++)
		{
			int ele=arr[i];
			
			//this present element can be the next greater element to the right of 
			//element's which are prsent in the stack... here we go.........
			while(st.size()>0 && ele>=arr[st.peek()])
			{
				//I'm here means it has right boundary...
				int rb=ele;

				//let's see height of the peek element..
				int height=arr[st.pop()];

				

				if(st.size()>0)
				{
					//if it has left boundary.. then an only then it can store water...
					int lb=arr[st.peek()];
					int heightOfWater=Math.min(lb,rb);
					//let's fidn the horizontal range..
					int width=i-st.peek()-1;
					totalWater+=(heightOfWater-height)*width;
				}		
				
			}
			st.push(i);
			
		}
	//here means .. as the people left don't have right boundary means they can store water... 
		System.out.print(totalWater);
    }
}       

public class Main 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] arr= new int[n];

      	    for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(arr, n);
            
        
        sc.close();
        
    }
}
