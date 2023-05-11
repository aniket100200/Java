//Is Graph Tree?
/*Steps to solve
1] check is there a single component or not..
2] if there is mulitiple compoenent then it is not possible..
3]check for the cycle in the graph... 
4] it is undirected graph
*/
import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        for(int i=0;i<m;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<2;j++) {
                arr.add(sc.nextInt());
            }
            edgeList.add(arr);
        }
        boolean ans = Solution.isGraphTree(n, edgeList);
        if(ans) {
            System.out.print("1\n");
        }
        else {
            System.out.print("0\n");
        }
    }
}
class Solution 
{
    static boolean isGraphTree(int n, ArrayList<ArrayList<Integer>> edgeList) 
    {
       //we have edge list... 
		ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
		for(int i=0;i<n;i++)graph.add(new ArrayList<>());
		for(ArrayList<Integer> e:edgeList)
		{
			int src=e.get(0);
			int dest=e.get(1);
			graph.get(src).add(dest);
			graph.get(dest).add(src);
		}

		boolean isCycle=isCycle(n,graph);
		if(isCycle)return false;
		//chekck if componets are present or not..

		int[]visit=new int[n];
		comp(0,graph,visit);
		for(int i: visit)if(i==0)return false;
		return true;
    }
	public static void comp(int v,ArrayList<ArrayList<Integer>>graph,int[]visit)
	{
		visit[v]=1;
		for(int nbr: graph.get(v))
		{
			if(visit[nbr]==0)comp(nbr,graph,visit);
		}
	}
	  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
	{
       // Your code here
		boolean[]visit=new boolean[V];
		for(int i=0;i<V;i++)
		{
			if(!visit[i])
			{
			if(dfs(i,-1,adj,visit))return true;
			}
		}
		return false;
    }


		public static boolean dfs(int v,int par,ArrayList<ArrayList<Integer>> adj,boolean[]visit)
	{
		//after entering the vertex...
		visit[v]=true;

		//let's see the childrens..
		for(int ch: adj.get(v)){
			if(ch==par)continue;

			if(visit[ch])return true;
			if(dfs(ch,v,adj,visit))return true;
			
		}
		return false;
	}
}
