import java.util.*;
import java.lang.*;
import java.io.*;

class Solution 
{
	public static boolean dfs(int src,ArrayList<Integer>[] graph,boolean[] visit,boolean[] path)
	{
		
		visit[src]=true;
		path[src]=true;
		for(int nbr: graph[src])
		{
			if(path[nbr])return true;
			else if(visit[nbr]==false)
			{				
				boolean ans=dfs(nbr,graph,visit,path);
				if(ans)return true;
			}
		}
		path[src]=false;
		return false;
	}
public boolean isCyclic(int V, ArrayList<Integer>[] adj)
{
    // Your code here
	//we'll use simply DFS.. because BFS not work here..
	boolean[] visit=new boolean[V];
	boolean[] path=new boolean[V];
	for(int i=0;i<V;i++)
	{
		if(visit[i])continue;
		boolean isFound=dfs(i,adj,visit,path);
		if(isFound)return true;
	}
	return false;
}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V, E;
        V = sc.nextInt();
        E = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u].add(v);
        }
        Solution obj = new Solution();
        boolean ans = obj.isCyclic(V, adj);
        if (ans == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
