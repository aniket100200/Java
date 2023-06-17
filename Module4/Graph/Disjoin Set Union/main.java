import java.util.*;
import java.lang.*;
import java.io.*;
class DSU
{
	private int[] parent,size;
	public DSU(int n)
	{
		parent=new int[n+1];
		size=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
			size[i]=1;							
		}
		
		
	}

	public int find(int node)
	{
		if(node==parent[node])return node;
		return parent[node]=find(parent[node]); //now find of ultimate parent will take the o(1) time..
	}
	//but this find function will take o(n) time complexity at worst... so what will you do.. 

	public void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a==b)return;
		else if(size[a]<size[b])
		{
			parent[a]=b;
			size[b]+=size[a];
		}
		else
		{
			parent[b]=a;
			size[a]+=size[b];
		}
	}
}
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		DSU ds=new DSU(7);
		ds.union(0,1);
		ds.union(2,3);
		ds.union(0,2);
		ds.union(4,5);
		ds.union(6,7);
	System.out.print(ds.find(3));
	}
}
