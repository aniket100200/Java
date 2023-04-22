//Tc call^N.. recurssive time complexity... here we go..

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges))
		{
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution 
{
    boolean dfs(int node,ArrayList<ArrayList<Integer>> graph, boolean[] path, ArrayList<Integer> psf)
	{
		//mark
		path[node]=true;
		
		psf.add(node);
		if(psf.size()==graph.size()-1)
		{

			/*below code is to detect hamiltonion cycle*/
			// int os=psf.get(0);
			// for(int nbr : graph.get(node))
			// {
			// 	if(nbr==os)
			// 	{
			// 		return true;
					
			// 	}
			// }
			psf.remove(psf.size()-1);
			path[node]=false;
			return true;
		}
		

		//work

		//visit unvisit...

		for(int nbr: graph.get(node))
		{
			if(!path[nbr]){if(dfs(nbr,graph,path,psf))return true;};
		}
		path[node]=false;
		psf.remove(psf.size()-1);
	return false;
		
	}
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges)
	{
        // your code here
		//let's create the graph..
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

		for(int i=0;i<=N;i++)graph.add(new ArrayList<Integer>());
		
		for(ArrayList<Integer> e: Edges)
		{
			//undirect graph..			
			int u=e.get(0);
			int v=e.get(1);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		//let's generate all the possible paths..

		boolean[] path=new boolean[N+1];//1based indexing...
		for(int i=1;i<=N;i++){if(dfs(i,graph,path,new ArrayList<Integer>())) return true;}
    return false;
    }
}
