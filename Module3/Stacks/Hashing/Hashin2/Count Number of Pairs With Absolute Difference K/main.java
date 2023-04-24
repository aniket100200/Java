import java.io.*;
import java.util.*;

class Solution {
    public long pairDifference(int []A, int n, int k) 
	{
       // write code here
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i: A)
		{
			map.put(i,map.getOrDefault(i,0)+1);
		}

		int count=0;
		if(k==0)
		{		
			for(int key: map.keySet())
			{
				if(map.get(key)>1)count++;
			}
		}
		else 
		{
		for(int key: map.keySet())
			{
				if(map.containsKey(key-k))count++;
			}		
		}
		return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
