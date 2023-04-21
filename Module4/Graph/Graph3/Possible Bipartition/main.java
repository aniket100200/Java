import java.util.*;

class Solution {

	class Pair
	{
		int node;
		int color;
		Pair(int node,int color)
		{
			this.node=node;
			this.color=color;
			/*there will two color
			1---> blue colored
			2--> Red colored 
			0---> yet to be colored..*/
		}
	}
    public int possibleBipartition(int n, int[][] edges)
	{
        // Write your code here
	//step 1: create a Graph //1based Indexing...
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

		//based on One based Indexing..
	for(int i=0;i<=n;i++)graph.add(new ArrayList<>());

		for(int[] e: edges)
		{
			int u=e[0];
			int v=e[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
	//graph is created success fully..
/**********************************************||***********************************************************************************************/
			//lets apply BFS..
		int visit[]=new int[n+1];//n+1..for one based indexing...	

			Queue<Pair> que=new LinkedList<>();
	for(int i=0;i<=n;i++)
	{
		if(visit[i]!=0)continue;		
		que.add(new Pair(i,1));
		while(que.size()>0)
		{
			//remove
			Pair curr=que.remove();
			int node=curr.node;
			if(visit[node]!=0)continue;
			//mark...
			visit[node]=curr.color;

			//work
			int oppCol= curr.color==1 ? 2:1;

			//visit unvisited neighbour..
			for(int nbr: graph.get(node))
			{
				if(visit[nbr]==0)que.add(new Pair(nbr,oppCol));					
				else if(visit[nbr]==visit[node])return 0;
				else continue;
			}
			
		}
	}

		return 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int dislike[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                dislike[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.possibleBipartition(N,dislike));

    }
}
