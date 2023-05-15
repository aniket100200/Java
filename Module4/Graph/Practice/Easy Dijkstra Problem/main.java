import java.util.*;
import java.io.*;

class Node{
    int v, wt;
    Node(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
class nodeComparator implements Comparator<Node>{
    public int compare(Node node1, Node node2){
        return node1.wt - node2.wt;
    }
}
class graph{
	int V;
    ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
    graph(int n){
        for(int i=0; i<n; i++){
            g.add(new ArrayList<Node>());
        }
		V=n;
    }
    void addNode(int u, int v, int wt)
	{
        g.get(u).add(new Node(v, wt));
    }
class flair{
	int node;
	int wt;
	public flair(int node,int wt){
		this.node=node;
		this.wt=wt;
	}
}
    void findPath(int start, int end)
	{
		
        // Write your code here
		PriorityQueue<flair>pq=new PriorityQueue<>((a,b)->{
			return a.wt-b.wt;
		});
		pq.add(new flair(start,0));
		boolean[]visit=new boolean[V];
		while(pq.size()>0)
		{
			flair curr=pq.remove();
			if(curr.node==end){System.out.print(curr.wt); return;}
			if(visit[curr.node])continue;
			//mark;
			visit[curr.node]=true;
			for(Node e: g.get(curr.node)){
				int nbr=e.v;
				if(visit[nbr]==false){
					pq.add(new flair(nbr,curr.wt+e.wt));
				}
			}
		}
		System.out.print("NO");return;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        graph g = new graph(n);
        for(int i=0; i < m; i++){
            int u = input.nextInt(), v = input.nextInt();
            int wt = input.nextInt();
            g.addNode(u-1, v-1, wt);
        }
        int start = input.nextInt(), end = input.nextInt();
        g.findPath(start-1, end-1);
    }
}
