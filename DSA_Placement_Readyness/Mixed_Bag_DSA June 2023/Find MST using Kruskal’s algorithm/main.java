import java.util.*;
class Edge  {
	int src,dest,wt;
	public Edge(int src,int dest,int wt)
	{
		this.src=src;
		this.dest=dest;
		this.wt=wt;
	}
	
}
class compareEdge implements Comparator<Edge>
{
	public int compare(Edge e1,Edge e2)
	{
		if(e1.wt==e2.wt)return 0;
		else if(e1.wt>e2.wt)return 1;
		else return -1;
	}
}
class Solution 
{
    List<Edge> edgeList;
    int V;

    public Solution(int V)
	{
        this.V = V;
        edgeList = new ArrayList<>();
    }

    public void addEdge(int x, int y, int w) {
        edgeList.add(new Edge(x, y, w));
    }

    public void kruskalsMST() 
	{
       // Your code here
		Collections.sort(edgeList,new compareEdge());
		DSU dsu=new DSU(edgeList.size());
		int ans=0;
		for(Edge e: edgeList)
		{
			int src=e.src;
			int dest=e.dest;
			int wt=e.wt;
			if(dsu.find(src)!=dsu.find(dest))
			{
				dsu.union(src,dest);
				ans+=wt;
			}
		}
		System.out.print(ans);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        Solution g = new Solution(v);
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            g.addEdge(src, dest, wt);
        }

        // Function call
        g.kruskalsMST();
    }
}

class DSU
{
	int[]parent,size;
	public DSU(int n)
	{
		parent=new int[n+1];
		size=new int[n+1];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			size[i]=1;
		}
	}
	public int find (int node)
	{
		if(node==parent[node])return node;
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
