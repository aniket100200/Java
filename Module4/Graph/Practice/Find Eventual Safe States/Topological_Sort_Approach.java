
// User function Template for Java
//you can also sove this using DFS...
//but to solve this using topological sort 
//1]--> Reverse Graph and then apply topological sorting.. that if there is 
//cycle you'll not consider those part...
//I'll solve that using the DFS.. here it was applied using Topological sorting...
// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) 
    {
        // Your code here
        ArrayList<Integer>[]graph=new ArrayList[V];
        int[]indegree=new int[V];
    for(int i=0;i<V;i++)graph[i]=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
          
            for(int nbr:adj.get(i))
            {
                //u-->
                int u=i; int v=nbr;
                graph[v].add(u);
                indegree[u]++;
            }
        }
        List<Integer>al=new ArrayList<Integer>();
        Queue<Integer>que=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                que.add(i);
            }
        }
        while(que.size()>0){
            int curr=que.remove();
            al.add(curr);
            for(int nbr:graph[curr])
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)que.add(nbr);
            }
        }
        Collections.sort(al);
        return al;
    }
}
