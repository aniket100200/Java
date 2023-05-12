import java.util.*;

class Solution
{
	static class Edge
	{
		int src;
		int dest;
		int wt;
		public Edge(int src,int dest,int wt)
		{
			this.src=src;
			this.dest=dest;
			this.wt=wt;
		}
		
	}
	static class Pair
	{
		int node;
		int wt;
	public Pair(int node,int wt)
	{
		this.node=node;
		this.wt=wt;
	}

		
	}
    public static ArrayList<Integer> dijkstra(ArrayList <ArrayList<Integer >> vec, int vertices, int edges, int source)
	{  	
        //Write your code here
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		for(int i=0;i<vertices;i++)graph[i]=new ArrayList<>();
		for(ArrayList<Integer> v:vec)
		{
			int src=v.get(0);
			int dest=v.get(1);
			int wt=v.get(2);
			graph[src].add(new Edge(src,dest,wt));
			graph[dest].add(new Edge(dest,src,wt));
		}
		int[]dist=new int[vertices];
		for(int i=0;i<vertices;i+=1)
		{
			if(i!=source)
			{
				dist[i]=Integer.MAX_VALUE;
			}
		}
		boolean[]visit=new boolean[vertices];
		PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
			return a.wt-b.wt;
		});
		pq.add(new Pair(source,0));

		while(pq.size()>0)
		{
			Pair curr=pq.remove();
			if(visit[curr.node])continue;

			
			visit[curr.node]=true;
			for(Edge e: graph[curr.node])
			{
				int u=e.src;
				int v=e.dest;
				int wt=e.wt;
				//perform relaxation...
				if(dist[u]+wt<dist[v])
				{
					dist[v]=dist[u]+wt;
					pq.add(new Pair(v,dist[v]));
				}
			}
			
		}
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i: dist)ans.add(i);
		return ans;
		
    }
}

class Main{
        public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int v,e;
            v = sc.nextInt();
            e = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i=0;i<e;i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                ArrayList<Integer> node = new ArrayList<>();
                node.add(x);
                node.add(y);
                node.add(w);
                arr.add(node);
            }
            ArrayList<Integer> result = Solution.dijkstra(arr, v, e, 0);
            for(int i=0;i<result.size();i++)
            System.out.print(result.get(i)+" ");
            System.out.println("");
        }
    }
}

