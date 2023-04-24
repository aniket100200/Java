import java.util.*;

class Solution 
{ 
    @SuppressWarnings("unchecked")
    
    public int canFinish(int n, int[][] prerequisites) 
	{
        //write your code here
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

		//1 bsed indexing...
		for(int i=0;i<n;i++)graph.add(new ArrayList<Integer>());
		int indegree[]=new int[n];
		for(int[] arr: prerequisites)
		{
			int ai=arr[0];
			int bi=arr[1];
			graph.get(bi).add(ai);
			indegree[ai]++;
		}
		//let's insert all the pre courses you wanted to do firs..
		Queue<Integer> que=new ArrayDeque<>();
		for(int i=0;i<n;i++)if(indegree[i]==0)que.add(i);

		//I've all the courses I've to do them firs... 

		//here we go..
		while(que.size()>0)
		{
			//remove
			int curr=que.remove();
			//I've completed this course.. 
			//so need to do other course..
			for(int nbr: graph.get(curr))
			{
				indegree[nbr]--;
				if(indegree[nbr]==0)que.add(nbr);
			}
		}
		for(int i=0;i<n;i++)
		{
			if(indegree[i]!=0)return 0;
		}
		return 1;
		
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
        System.out.println(Obj.canFinish(N,prerequisites));

    }
}
