
 import java.util.*;
import java.lang.*;
import java.io.*;
public class Main {
	   public static void main(String args[]) {
		  
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int[][] trips = new int[n][3];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < 3; j++) {
		                trips[i][j] = sc.nextInt();
		            }
		        }
		        int k = sc.nextInt();
	           
	        Solution obj= new Solution();
	        System.out.println(obj.carPooling(trips,k));
	    }
}
class Solution
{ 
    public boolean carPooling(int[][] trips, int capacity) 
{
	/*let's iterate over the trips
	* it contains 1--> no of people onboard 
	* 2----> onboarding  of those people location we can say...
	* 3----> downbrding of those people
	*/
	//as we don't know the size of the stations.. upto how many stattion it can goo..
	int[] station=new int[1008];//as seen in constrains... I got an idea sirji

	for(int[] a:trips)
	{
		int people=a[0];//people onboard or deboard
		int onboardLocation=a[1];
		int deboardLication=a[2];
		station[onboardLocation]+=people;
		station[deboardLication]-=people;		
	}

	/*I've the array or we can say stations where they onboard & where they deboard
	*
	*let's take the prefix sum array to check where at max how many people are there 
	* as it is not possible return false 
	*/
	for(int i=1;i<station.length;i++)
	{
		station[i]+=station[i-1];
		if(station[i]>capacity)return false;
	}

	return true;
	
}
}
