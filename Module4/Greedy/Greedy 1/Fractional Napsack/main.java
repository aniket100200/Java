import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        Item arr[] = new Item[n];
        for(int i=0;i<n;i++) {
            int value = sc.nextInt();
            arr[i] = new Item(value,0);
        }
        for(int i=0;i<n;i++) {
            arr[i].weight = sc.nextInt();
        }
        double ans = (new Solution()).fractionalKnapsack(w,arr,n);
        System.out.println(String.format("%.2f",ans));
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/


class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
       // Write your code here

		//as we want to fill our bag with max value..
		//we'll sort the Items.. on the basis of Profit per unit of weight...

		Arrays.sort(arr,(a,b)->{

			double d1=(1.0*a.value/a.weight);
				double d2=(1.0*b.value/b.weight);
			if(d1>d2)
			{
				return -1;
			}
			return 1;
		});

		//now just iterate over it...
		
int cap=W;
		double totalProfit=0;
		for(Item i: arr)
		{
			int w=i.weight;
			int val=i.value;
			if(cap>=w)
			{
				totalProfit+=val;
				cap-=w;
			}
			else
			{
				//I'll have some space just...
				//calculate ratio...
				double ratio=1.0*val/w;
				totalProfit+=ratio*cap;	
				cap=0;
				break;
			}
		}
		return totalProfit;
    }
}
