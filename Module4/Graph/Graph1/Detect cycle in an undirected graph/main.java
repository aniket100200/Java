import java.io.*;
import java.util.*;

class Solution {
	public static boolean cycleFound(int src,ArrayList<ArrayList<Integer>> graph,boolean[] visit)
	{
		//for every source we'll call BFS...
		Queue<Integer> que=new ArrayDeque<>();
		que.add(src);

		//let's apply basic dfs...
		while(que.size()>0)
		{
			int front=que.remove();
			//Mark..
			if(visit[front])return true;
			visit[front]=true;
			//work 
			for(int neb: graph.get(front))
			{
				//visit unvisited neb...
				if(!visit[neb])
				{
					que.add(neb);
				}
			}
		}

		return false;//this means cycle is not found the graph..
	}
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph)
	{
       // Your code here
		boolean[] visit=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(visit[i])continue;//this means it is visited in previous calls...  let's continue...
			boolean found=cycleFound(i,graph,visit);
			if(found)return true;
		}
		return false;
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
