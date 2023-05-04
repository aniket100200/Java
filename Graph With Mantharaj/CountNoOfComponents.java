//there are always components in the undirected graph only... remember..
//n--> No of Edges
//m--> No of verteces...
import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int m=sc.nextInt();
	    ArrayList<Integer>[] adj=new ArrayList[n+1];
	   // let's initialise all the arrayLists..
	   for(int i=0;i<=n;i++)adj[i]=new ArrayList<Integer>();
	   
	   //let's create the graph..
	   for(int i=0;i<m;i++)
	   {
	       int u=sc.nextInt();
	       int v=sc.nextInt();
	       //this represents the there is Edge between u and v-->
	       adj[u].add(v);
	       adj[v].add(u);
	   }
	   
	   // for(ArrayList<Integer> al: adj)
	   //{
	   // System.out.println(al);
	   //}
	   
	   //you have to count no of components..
	   boolean[]visit=new boolean[n+1];//1 based indexing..
	   int count=0;
	   for(int i=1;i<=n;i++)
	   {
	       if(!visit[i])
	       {
	           count++;
	           dfs(i,visit,adj);
	       }
	   }
	   System.out.print(count);
	}
	
	public static void dfs(int V,boolean[] visit,ArrayList<Integer>[] adj)
	{
	    //1)Take action after entering the vertex..
	    
	    //mark..
	    visit[V]=true;
	    
	    for(int nbr: adj[V])
	    {
	        //2] Take action before entering the child..
	        
	        if(visit[nbr]==false)dfs(nbr,visit,adj);
	        
	        //3] take action after coming from the child...
	        
	    }
	    
	    //4] Take action before exiting the Vertex... here we go.. 
	}
}
