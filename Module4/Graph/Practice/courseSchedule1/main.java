class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        //we have to detect a cycle only 
        //if cycle is not htere it is the answer..
            int n=numCourses;
        ArrayList<Integer>[]graph=new ArrayList[n];
        //this is directed graph... brother...
    
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[]course : prerequisites)
        {
            int ai=course[0];
            int bi=course[1];
            graph[bi].add(ai);
        }
    int[]visit=new int[n];
        for(int i=0;i<n;i++)
        {
          if(visit[i]==0){  if(dfs(i,graph,visit))return false;}
        }
        return true;
    }
    public boolean dfs(int v,  ArrayList<Integer>[]graph,int[]visit)
    {
        visit[v]=1;
        for(int nbr:graph[v])
        {
            if(visit[nbr]==1)return true;
            else if(visit[nbr]==0)
            {
                if(dfs(nbr,graph,visit))return true;
            }
        }
        visit[v]=2;
        return false;
    }
}
