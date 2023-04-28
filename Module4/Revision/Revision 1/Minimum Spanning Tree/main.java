import java.util.*;

public class Main {
static class Pair{
	int node;
	int wt;
	Pair(int node,int wt)
	{
		this.node=node;
		this.wt=wt;
	}
}
  static int primMST(int graph[][], int V)
{
	/*Adjecentcy Matrix---> graph*?*/
    // your code here
	PriorityQueue<Pair> que=new PriorityQueue<>((a,b)->
	{
		return a.wt-b.wt;
	});
	//dixtra Algorithm with single edge weight...
	//we have give an 
	boolean[]visit=new boolean[V];
	que.add(new Pair(0,0));
	int ans=0;
	while(que.size()>0)
	{
		//first remove
		Pair curr=que.remove();
		if(visit[curr.node]) continue;
		//mark it curr...
		ans+=curr.wt;
		visit[curr.node]=true;
		for(int i=0;i<V;i++)
		{
			//i ---> nbr... 
			//and this is ajcency matrix...
			
			if(graph[curr.node][i]==0)continue;//because there is no edge between  them..

			int edgeWt=graph[curr.node][i];
			que.add(new Pair(i,edgeWt));
			
		}
	}
	return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int vertices = sc.nextInt(), edges = sc.nextInt();
    int[][] graph = new int[vertices][vertices];
    for (int i = 0; i < edges; i++) {
      int src = sc.nextInt(), dest = sc.nextInt(), dist = sc.nextInt();
      graph[src][dest] = dist;
      graph[dest][src] = dist;
    }
    sc.close();

    System.out.println(primMST(graph, vertices));
  }
}
