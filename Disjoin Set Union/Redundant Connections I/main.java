import java.util.*;
class Solution{

public static class DSU{
	int parent[],size[];
	public DSU(int n)
	{
		size=new int[n+1];
		parent=new int[n+1];
	
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
			size[i]=1;
		}
	}
	public int find(int node)
	{
		if(parent[node]==node)return node;
		return parent[node]=find(parent[node]);
	}
	public void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a==b)return;
		if(size[a]>size[b])
		{
			parent[b]=a;
			size[a]+=size[b];
		}
		else
		{
			parent[a]=b;
			size[b]+=size[a];
		}
	}
}
    public static int[] findRedundantConnection(int[][] edges){
        //write your code here
		int a=0;
		int b=0;
		DSU dsu=new DSU(edges.length);
		for(int[]edge: edges)
		{
			int src=edge[0];
			int dest=edge[1];
			if(dsu.find(src)!=dsu.find(dest))
			{
				dsu.union(src,dest);
			}
			else{
				a=src;
				b=dest;
			}
		}
		return new int[]{a,b};
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
        int[] ans = Solution.findRedundantConnection(edges);
        for(int i = 0 ; i < 2 ; ++i){
            System.out.print(ans[i] + " ");
        }
    }
}
