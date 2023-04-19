import java.util.*;
import java.io.*;
 
class Graph {
    public int vertices;
    public ArrayList<Integer>[] adjList;
 
    Graph(int v) 
	{
        this.vertices = v+1;
        adjList = new ArrayList[v+1];
        
        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w)
	{
        adjList[v].add(w);
     
    }
 
    void BFS(int x)
	{
      //let's do the BFS on the Graph...
		//here we go...
	Queue<Integer> que=new LinkedList<>();
		que.add(x);
		boolean[] visit=new boolean[vertices];
		while(que.size()>0)
		{
			//let's remove it..			
				int front=que.remove();
				//if it is already visited
				if(visit[front])continue;
				//mark
				visit[front]=true;				
				//work
				System.out.print(front+" ");
				//neighbours
				for(int nbr: adjList[front])
				{
					if(visit[nbr]==false){que.add(nbr);}
				}
			
		}
    }
}
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
