
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			  tree.preorderTraversal(root);
	}
}
class Solution 
{	
	static class Pair
	{
		Node node;
		int stage;
		Pair(Node node, int stage)
		{
			this.node=node;
			this.stage=stage;
		}
}
	public static void preorderTraversal(Node root) 
	{
		//I'm here trying an Iterative DFS...
		Stack<Pair> st=new Stack<>();
		ArrayList<Integer> pre=new ArrayList<Integer>();
		ArrayList<Integer> post=new ArrayList<Integer>();
		ArrayList<Integer> In=new ArrayList<Integer>();
		st.push(new Pair(root,1));
		while(st.size()>0)
		{
			Pair p=st.peek();
			if(p.stage==1)
			{
				pre.add(p.node.data);
				p.stage++;
				if(p.node.left!=null)
				{
					st.push(new Pair(p.node.left,1));
				}
			}
			else if(p.stage==2)
			{
				In.add(p.node.data);
				p.stage++;
				if(p.node.right!=null)
				{
					st.push(new Pair(p.node.right,1));
				}
			}
			else
			{
				post.add(p.node.data);
				st.pop();
			}			
		}
	for(int i: pre)
	{
		System.out.print(i+" ");
	}
        
	}
}
