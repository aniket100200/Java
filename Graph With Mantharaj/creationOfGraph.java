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
	   
	   for(ArrayList<Integer> al: adj){
	    System.out.println(al);
	   }
	}
}
