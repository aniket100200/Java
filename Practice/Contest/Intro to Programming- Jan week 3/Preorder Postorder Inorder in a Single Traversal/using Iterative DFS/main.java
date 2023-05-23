
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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    Scanner sc = new Scanner(System.in);
            
			String s = sc.nextLine();
            
            //System.out.print(s);
			Node root = buildTree(s);
			Solution tree = new Solution();
			tree.allTraversal(root);
            
		
	}
}
  


class Solution {

	static class Pair{
		Node node;
		int state;
		public Pair(Node node,int state)
		{
			this.node=node;
			this.state=state;
		}
	}
	public static void allTraversal(Node root)
	{
		//Write your code here 
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		ArrayList<Integer> pre=new ArrayList<Integer>();
		ArrayList<Integer> in=new ArrayList<Integer>();
		ArrayList<Integer> post=new ArrayList<Integer>();

		//we'll use Interative dfs..
		Stack<Pair> st=new Stack<Pair>();
		st.push(new Pair(root,1));
		while(st.size()>0)
		{
			//
			Pair curr=st.peek();
			if(curr.state==1)
			{
				curr.state=2;
				//visiting the node for first time..
				pre.add(curr.node.data);
				//and we'll try to go left as left possible..
				if(curr.node.left!=null)
				{
					st.push(new Pair(curr.node.left,1));
				}
			}
			else if(curr.state==2){
				//you are visiting the node for second time.. 
				in.add(curr.node.data);
				curr.state=3;
				if(curr.node.right!=null)
				{
					st.push(new Pair(curr.node.right,1));
				}
			}
			else
			{
				//you are visiting to the node for third time..
				post.add(st.pop().node.data);
				
			}
		}
		al.add(pre);
		al.add(in);
		al.add(post);
		for(ArrayList<Integer> i: al){
			for(int j: i)System.out.print(j+" ");
			System.out.println();
		}

	}
}
