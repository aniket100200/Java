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
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            sc.nextLine();
			String s = sc.nextLine();
            int b=sc.nextInt();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans=tree.solve(root,b);
            for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");

            System.out.println();

            sc.close();			
	}
}
  


class Solution{
    Node find(Node root,int b){
		if(root==null)return null;
		if(root.data==b)return root;
		Node left=find(root.left,b);
		if(left!=null)return left;
		Node right=find(root.right,b);
		if(root.right!=null)return right;
		return null;
	}
	public void setParent(Node root,Node parent,HashMap<Node,Node> map)
	{
		if(root==null)return;
		map.put(root,parent);
		if(root.left!=null)setParent(root.left,root,map);
		if(root.right!=null)setParent(root.right,root,map);
		
	}
   public ArrayList<Integer> solve(Node root,int b)
	{
        // your code here
		//first find the node..
		Node src=find(root,b);
		HashMap<Node,Node> map=new HashMap<>();
		setParent(root,null,map);
		Queue<Node>que=new ArrayDeque<>();
		que.add(src);
		Stack<Integer> st=new Stack<>();
		ArrayList<Integer> al=new ArrayList<Integer> ();
		while(que.size()>0)
		{
			Node curr=que.remove();
			st.push(curr.data);
			if(map.get(curr)!=null)que.add(map.get(curr));
		}
		while(st.size()>0)al.add(st.pop());
		return al;
          
    }
}
