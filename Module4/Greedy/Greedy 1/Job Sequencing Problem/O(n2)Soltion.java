//this is N* for traverasal on array...
//In worst case I'll have to traverl in boolean array n no. of times..
//Tc will be O(n2)...<<<<>>>>>
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n)
    {
       Arrays.sort(arr,(a,b)->{
		   //write this lambda function...
		   //let's sort on the basis of profict..
		   //but tell the java lie..
		   return b.profit-a.profit;
	   });

		//let's do the job...
		boolean[] deadLine=new boolean[5005];
int totalProfit=0;
		int count=0;
		for(Job j: arr)
		{
			int id=j.id;
			int profit=j.profit;
			int dl=j.deadline;
			int i=dl;
			while(i>0 && deadLine[i]==true)i--;
			if(i==0)continue;
			deadLine[i]=true;
			totalProfit+=profit;
			count++;
		}
		return new int[]{count,totalProfit};

    }
}
