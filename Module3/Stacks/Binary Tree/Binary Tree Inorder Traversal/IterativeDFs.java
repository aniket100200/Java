
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
			  tree.inorderTraversal(root);
            
		
	}
}
  


class Solution 
{
	static class Pair
	{
		Node node;
		int state;
		public Pair(Node node, int state)
		{
			this.node=node;
			this.state=state;
		}
	}
	public static void inorderTraversal(Node root) 
	{
		//let's use Iterative DFS...
			ArrayList<Integer> al=new ArrayList<Integer>();
		// W'll need a stack...
		Stack<Pair> st=new Stack<>();
		st.push(new Pair(root,1));
		while(st.size()>0)
		{
			Pair p=st.peek();
			if(p.state==1)
			{
				//preOrder..
				p.state++;
				if(p.node.left!=null)
				{
					st.push(new Pair(p.node.left,1));
				}
			}
			else if(p.state==2)
			{
				al.add(p.node.data);
				p.state++;
				if(p.node.right!=null)
				{
					st.push(new Pair(p.node.right,1));
				}
			}
			else
			{
				st.pop();
			}
		}
		for(int i: al)
		{
			System.out.print(i+" ");
		}
	}
}
