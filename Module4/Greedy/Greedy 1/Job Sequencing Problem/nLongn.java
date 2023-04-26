//this is optimised using TreeSet.. which offers.. obj.floor value to get nearest value to perticular value.. understood..
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
		// boolean[] deadLine=new boolean[5005];
		TreeSet<Integer> deadLine=new TreeSet<>();
		for(int i=1;i<=5005;i++)
		{
			deadLine.add(i);
		}
int totalProfit=0;
		int count=0;
		for(Job j: arr)
		{
			int id=j.id;
			int profit=j.profit;
			int dl=j.deadline;
			Integer i=deadLine.floor(dl);
		if(i==null)continue;
			deadLine.remove(i);
			totalProfit+=profit;
			count++;
		}
		return new int[]{count,totalProfit};

    }
}
