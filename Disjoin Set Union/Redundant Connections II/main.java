import java.util.*;

//this problem can be solve using DSU..
//as this is Directed graph adding an extra edges will lead in Three problems..
	/*
	*1] There may cycle form
	 *2] There may be two parents of single node..
  *3] There may be two parents as well as Cycle as it is directed graph...
	*/
class DSU
{
	int[]parent;
	public DSU(int n)
	{
		parent=new int[n+1];		
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;			
		}
	}
	int find(int node)
	{
		if(node==parent[node])return node;
		return find(parent[node]);
	}
	void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a==b)return;
		parent[b]=a;
	}
}
class Solution 
{
    public static int[] findRedundantDirectedConnection(int[][] edges)
	{	
		//let's have the indegree of all the  node..
		int n=edges.length;
		int[]parent=new int[n+1];
		Arrays.fill(parent,-1);
		int b1=-1;//blacklist edge 1
		int b2=-1;//blacklist edge 2
		//this blacklisted edges will help us if there are two parent then we'll see for cycle is present or not..
		for(int i=0;i<n;i++)
		{
			int u=edges[i][0];
			int v=edges[i][1];
			if(parent[v]==-1)
			{
				// u--- src and v-- dest so it has indegree due to ith row..
				parent[v]=i;
			}
			else{
				//means it has two indegrees
				b1=i;//it has 2nd indegree because of this ith row put it into blacklist..
				b2=parent[v];//this was the row because it got his first parent..
				break;
			}
		}
		//System.out.println("b1="+b1+"-->b2="+b2);
		DSU dsu=new DSU(n);	
		
		for(int i=0;i<n;i++)
		{
			if(b1==i)continue;
			int u=edges[i][0];
			int v=edges[i][1];
			if(dsu.find(u)!=dsu.find(v))dsu.union(u,v);
			else
			{
				//cyle is found means you can remove this edge...
				//cycle found..
				if(b1==-1)return new int[]{u,v};
				else return new int[]{edges[b2][0],edges[b2][1]};
			}
		}
		//as there is no cycle you can return directly...
		return new int[]{edges[b1][0],edges[b1][1]};
    }
	
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int m = sc.nextInt();
        int[][] edges = new int[n][2] ; 
        for(int i = 0 ; i < n ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int[] ans = Solution.findRedundantDirectedConnection(edges);
        for(int i = 0 ; i < 2 ; ++i){
            System.out.print(ans[i] + " ");
        }
    }
}
