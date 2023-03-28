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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> arr = tree.topView(root);
			for(int x : arr)
			System.out.print(x +" ");
			System.out.println();  
		}
	}
}
  

class qObj
{
    Node node;
    int level;
    qObj(Node n,int l)
    {
        node=n;
        level=l;
    }
}

class Solution
{
	int leftMax;
	int rightMax;
	class Pair
	{
		Node node;
		int level;
		Pair(Node node,int level)
		{
			this.node=node;
			this.level=level;
		}
	}
	public void getLevels(Node root,int idx)
	{
		if(root==null)return;
		leftMax=Math.min(idx,leftMax);
		rightMax=Math.max(idx,rightMax);
		getLevels(root.left,idx-1);
		getLevels(root.right,idx+1);
		
	}
    public ArrayList<Integer> topView(Node root)
	{
		leftMax=Integer.MAX_VALUE;
		rightMax=Integer.MIN_VALUE;
       //let's travel in vertical order....
		List<List<Integer>> list=new ArrayList<>();
		//if(root==null)return list;
		//let's first find the position of first and last Node 
		//NO.of levels in vertical order traversal...
		//here we...
		getLevels(root,0);
		//as it is calculated no. of levels... 
		int totalLevel=rightMax-leftMax+1;//these are totalLevels..

		//let's initialise all the levels with empty arrayLIst...
		for(int i=1;i<=totalLevel;i++){
			List<Integer> al=new ArrayList<>();
			list.add(al);
		}
		int rootIdx=-leftMax;
		//let's make a que...
		Queue<Pair> que=new ArrayDeque<>();
		
		que.add(new Pair(root,rootIdx));
		while(que.size()>0)
		{
			int size=que.size();
			while(size-->0)
			{
				//let's do somethind...
				Pair rnode=que.remove();
				list.get(rnode.level).add(rnode.node.data);
				if(rnode.node.left!=null)
				{
					que.add(new Pair(rnode.node.left,rnode.level-1));
				}
				if(rnode.node.right!=null)
				{
					que.add(new Pair(rnode.node.right,rnode.level+1));
				}
			}
		}
		ArrayList<Integer> al=new ArrayList<>();
		for(List<Integer> ls:list)
		{
			al.add(ls.get(0));
		}
		return al;
    }
}

