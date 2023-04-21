import java.util.*;

class Solution 
{ 
    @SuppressWarnings("unchecked")
	public int[] canFinish(int n, int[][] prerequisites)
	{
    //Write your code here
		//let's create the graph..
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		for(int i=0;i<n;i++)graph.add(new ArrayList<>());
		int[] indegree=new int[n];
	for(int[] e: prerequisites)
	{
		int bi=e[1];
		int ai=e[0];
		//this graph is directed..
		graph.get(bi).add(ai);//ai...is pointed by bi...
		//means you have to do the course ai after completion of bi
		indegree[ai]++;
	}
		//int It is know as Topological sorting....
		Queue<Integer> que=new ArrayDeque<>();
		//I'll add those courses which needs no prequisites.. here we go...
		for(int i=0;i<n;i++)if(indegree[i]==0)que.add(i);

		ArrayList<Integer> topo=new ArrayList<>();
		while(que.size()>0)
		{
			//remove
			int curr=que.remove();
			//I've done this course
			topo.add(curr);
			for(int nbr: graph.get(curr))
			{
				indegree[nbr]--;
				if(indegree[nbr]==0)que.add(nbr);
			}
		}

		if(topo.size()<n)
		{
			//the graph was not Directed Acyclic Graph(i.e. DAG)...
			//there may be the loop so we're unble to do all the courses...
			return new int[0];
		}
	int[] ans=new int[n];
		for(int i=0;i<n;i++)ans[i]=topo.get(i);
		return ans;

		
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int M= sc.nextInt();

        int prerequisites[][] = new int[M][2];

        for(int i=0; i<M; i++){
            for(int j=0; j<2; j++)
                prerequisites[i][j]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        int []ans=Obj.canFinish(N,prerequisites);
        if(ans.length==0)
            System.out.println(-1);
        else{
            for(int i=0; i<ans.length; i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println("");
        }

    }
}
