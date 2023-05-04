/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
//n--> No of Edges
//m--> No of verteces...
import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the no of vertces");
	    int n=sc.nextInt();
	    int[][] matrix=new int[n+1][n+1];
	    //this matirx is know as adj.. matrix..
	    
	      System.out.println("Enter the Binary Matrix>>-->");
	    for(int i=0;i<=n;i++)
	    {
	        for(int j=0;j<=n;j++)
	        {
	            matrix[i][j]=sc.nextInt();
	        }
	    }
	    
	    //I've binary matrix or can say Adjacency Matrix... Okay..
	    ArrayList<Integer>[] adj=new ArrayList[n+1];
	    for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
	    
	    //let'creat graph with travelling with matrix..
	    for(int i=0;i<=n;i++)
	    {
	        for(int j=0;j<=n;j++)
	        {
	            if(matrix[i][j]==1)
	            {
	                adj[i].add(j);
	            }
	        }
	    }
	    
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
