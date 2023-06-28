class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int n=graph.length;
        int[]visited=new int[n];
        int[]path=new int[n];
        int[]ans=new int[n];
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,graph,visited,path,ans);      
                
            }
        }
      for(int i=0;i<n;i++){
          if(ans[i]>0)list.add(i);
      }
      
        return list;
        
    }

    public boolean dfs(int src,int[][]graph,int[]visit,int[]path,int[]ans)
    {
        
        path[src]=1;
        visit[src]=1;
        for(int i: graph[src])
        {
           
            if(path[i]==1)return true;
            if(visit[i]==0)
            {
                if(path[i]==1)return true;
                if(dfs(i,graph,visit,path,ans))return true;
            }
        }
       ans[src]++;
        path[src]=0;
        return false;
    }
}
