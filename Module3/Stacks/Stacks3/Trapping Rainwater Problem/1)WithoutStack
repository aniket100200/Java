
import java.io.*;
import java.util.*;

class Solution 
{

    public void TappingWater(int[] arr, int n)
	{      
        //1) I'll solve without the Stacks.. 
		//let's see how..
		//step 1: get Max on left side..
		int[] lmax=FindLeftMax(arr);		

		//step 2: get Max on rigth side...

		int[] rmax=FindRightMax(arr);
		
		//I've fidn rigth and left boundary for each and every element ...
		//Step 3: Calculate total water unit or blocks..
		int totalWater=0;//this will be total count of blocks...

		for(int i=0;i<n;i++)
		{
			int heightOfBuilding=arr[i];//this is the heigth of the building...
			
			int heightOfWater=Math.min(lmax[i],rmax[i]);//this is the height of the building..

			int heightOfWaterAbove=0;

			if(heightOfWater!=-1)
			{
				heightOfWaterAbove=heightOfWater-heightOfBuilding;
			}
			int waterAboveMe=heightOfWaterAbove*1;
			totalWater+=waterAboveMe;
		}
		System.out.println(totalWater);
       
    }
}

public class Main {
    public static void main(String[] args) {
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
