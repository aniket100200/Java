import java.io.*;
import java.util.*;
  class Edge 
  {
      int src;
      int nbr;

      Edge(int src, int nbr)
	  {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
    public static int perfectStudents(int vtces,  ArrayList<Edge>[] graph)
{
       // Your code here
	ArrayList<Integer> components=new ArrayList<>();
	boolean[]visit=new boolean[vtces];
	for(int i=0;i<vtces;i++)
	{
		if(visit[i])continue;
		components.add(dfs(i,graph,visit));
	}
int ans=0;
	for(int i=0;i<components.size();i++)
	{
		for(int j=i+1;j<components.size();j++)
		{
			ans+=components.get(i)*components.get(j);
		}
	}
	return ans;

}

	static int dfs( int node,ArrayList<Edge>[] graph,	boolean[]visit)
	{
		//mark..
		visit[node]=true;
		//let's visit the components...
		int count=1;
		for(Edge e: graph[node])
		{
			if(!visit[e.nbr]) count+=dfs(e.nbr,graph,visit);
		}
		return count;
	}
}
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
