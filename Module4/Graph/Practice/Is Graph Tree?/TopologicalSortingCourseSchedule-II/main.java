class Solution {
    class Edge{
        int src;
        int dest;
        Edge(int src,int dest)
        {
            this.src=src;
            this.dest=dest;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
         int v=numCourses;
        //this is know as topological sort..
        ArrayList<Edge>[]adj=new ArrayList[v];
       
        for(int i=0;i<v;i++)adj[i]=new ArrayList<>();
        for(int[] course:prerequisites )
        {
            //this is used in directed graph only...
            int ai=course[0];
            int bi=course[1];
            adj[bi].add(new Edge(bi,ai));
        }

        int[]visit=new int[v];
        Stack<Integer>st=new Stack<>();
       for(int i=0;i<v;i++)
       {
           if(visit[i]==0)
           {
               //modified dfs we'll use here 
              if( dfs(i,adj,visit,st)==false)return new int[0];
           }
       }
       int[]ans=new int[v];
       int i=0;
       while(!st.isEmpty())
       {
           ans[i++]=st.pop();
       }
       return ans;
    }
    boolean dfs(int v,ArrayList<Edge>adj[],int[]visit,Stack<Integer>st)
    {
        //mark kr..
        visit[v]=1;

        //first visit all neighbours...
        for(Edge e: adj[v])
        {
            if(visit[e.dest]==1)return false;
            if(visit[e.dest]==0)if(!dfs(e.dest,adj,visit,st))return false;
        }
        visit[v]=2;
        st.push(v);
        return true;
    }
}
