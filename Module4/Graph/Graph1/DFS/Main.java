import java.util.*;

class Solution 
{
	public static void dfs(int node,ArrayList<ArrayList<Integer>> graph,boolean visit[])
	{
		//step 1: Mark the present node visited...
		visit[node]=true;
		//Step 2: do your Work...
		System.out.print(node+" ");
		//call unvisited neighbour of node....
		for(int nbr: graph.get(node))
		{
			if(!visit[nbr])dfs(nbr,graph,visit);
		}
	}
    public static void DFSTraversal(List<List<Integer>> edges, int n) {
        //Write your code here
		//first of let's create the graph..
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

		//add empty arraylist to create the graph..
		for(int i=0;i<n;i++)
		{
			graph.add(new ArrayList<Integer>());
		}
		//let's create the graph..
		for(List<Integer> edge: edges)
		{
			int u=edge.get(0);
			int v=edge.get(1);
			//let's create the undirected graph...
			graph.get(u).add(v);
			graph.get(v).add(u);
		}


		//this is fighting with portal not part of DFS..
		for(int i=0;i<n;i++)Collections.sort(graph.get(i));
			
		boolean visit[]=new boolean[n];
		dfs(0,graph,visit);
    }
}

public class Main
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++)
		{
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}
