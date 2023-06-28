
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[]visit=new int[V];
        //0-->unvisited..
        //1-->in curr path
        //2-->visited..
        for(int i=0;i<V;i++){
            if(visit[i]==0){
                if(dfs(i,-1,visit,adj))return true;
            }
        }
        return false;
    }
    public boolean dfs(int src,int parent,int[]visit,ArrayList<ArrayList<Integer>>adj)
    {
        visit[src]=1;
        for(int nbr:adj.get(src))
        {
            if(visit[nbr]==1 && nbr!=parent)return true;
            if(visit[nbr]==1)continue;
            if(dfs(nbr,src,visit,adj))return true;
        }
        visit[src]=2;
        return false;
    }
}
