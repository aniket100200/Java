
class Solution {
    public  class DSU
    {
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
    public int[] findRedundantConnection(int[][] edges) 
    {
        DSU dsu=new DSU(edges.length);
        int a=0;int b=0;
        for(int[]e: edges)
        {
            int src=e[0];
            int dest=e[1];
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
