import java.io.*;
import java.util.*;

public class Main 
{
   public static void main(String[] args)
	{
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++)
	  {
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution 
{
	class Edge implements Comparable<Edge>
	{
		int nbr;
		int wt;
		Edge(int nbr,int wt)
		{
			this.nbr=nbr;
			this.wt=wt;
		}
		public int compareTo(Edge other)
		{
			return this.wt-other.wt;
		}
	}
	public int networkDelayTime(int[][] times, int N, int K)
	{
       //let's create a graph ...

		//1 based Indexing..
		ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
		for(int i=0;i<=N;i++)graph.add(new ArrayList<>());
		for(int[] arr: times)
		{
			int u=arr[0];
			int v=arr[1];
			int w=arr[2];
			graph.get(u).add(new Edge(v,w));//directed graph...
		}
			/* Graph creation done*/
		PriorityQueue<Edge> que=new PriorityQueue<>((a,b)->{return a.wt-b.wt;});//this will keep smaller people upwards..

		//dijkstra Algorithm give shortest path from the source node to any node...
		que.add(new Edge(K,0));

		//let's have visited array..
		boolean[] visit=new boolean[N+1];//1 based indexing...
		int maxi=0;
		//
		while(que.size()>0)
		{
			//remove 
			Edge curr=que.remove();
			int node=curr.nbr;
			int wt=curr.wt;
			if(visit[node])continue;
			maxi=Math.max(maxi,wt);

			//mark
			visit[node]=true;
			for(Edge e: graph.get(node))
			{
				int nbr=e.nbr;
				int nwt=e.wt;
				if(!visit[nbr])que.add(new Edge(nbr, nwt+wt));
			}
			
		}
		for(int i=1;i<=N;i++)
		{
			if(visit[i]==false)return -1;
		}
		return maxi;
    }
}
