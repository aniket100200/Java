import java.util.*;
import java.lang.*;
import java.io.*;
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class Main
{
	static Node construct(int[] in,int l,int r)
	{
		if(l>r)return null;
		//first we'll find the 
		int mid=(l+r)>>1;
		Node me=new Node(in[mid]);
		me.left=construct(in,l,mid-1);
		me.right=construct(in,mid+1,r);
		return me;
	}
	static void display(Node root)
	{
		if(root==null)return ;
		
		
		display(root.left);
		display(root.right);
	System.out.print(root.data+" ");
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		  Scanner scn = new Scanner(System.in);

    int[] inorder = { 10, 20, 30, 40, 50, 60, 70, 80 };
    Node root = construct(inorder, 0, inorder.length - 1);
    display(root);
    scn.close();
	}
}
