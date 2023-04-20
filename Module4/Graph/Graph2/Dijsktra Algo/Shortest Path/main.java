import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
	public static class Pair
	{
		int src;
		String psf;
		int wsf;
		public Pair(int src,String psf,int wsf)
		{
			this.src=src;
			this.psf=psf;
			this.wsf=wsf;
		}
	}
  public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> graph, int S)
  {
     // Write your code here
	  //apply BFS.. here we go
	   int[] ans=new int[V];
	  Arrays.fill(ans,-1);
	  PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{return a.wsf-b.wsf;});
       pq.add(new Pair(S,""+S,0));
	  boolean[] visit=new boolean[V];
	  while(pq.size()>0)
	  {
		  //remove
		  Pair f=pq.remove();
		  int src=f.src;
		  String psf=f.psf;
		  int wsf=f.wsf;		
		  if(visit[src])continue;
		  
		    

		  //mark
		  visit[src]=true;

		  //work
		  ans[src]=wsf;
		 // System.out.println(psf+"@"+wsf);
		  //add unvisited neighbours...><
		  for(ArrayList<Integer> al: graph.get(src))
		  {
			  int nbr=al.get(0);
			  int wt=al.get(1);
			  if(!visit[nbr]){				  
				  pq.add(new Pair(nbr,psf+nbr,wsf+wt));
			  }
		  }
		  
	  }
	  return ans;
  }

  public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            int[] ptr = dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    

}
