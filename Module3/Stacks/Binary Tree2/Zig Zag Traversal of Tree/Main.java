import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        g.binaryTreeZigZagTraversal(root1);
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution
	{
    public static void binaryTreeZigZagTraversal(Node root) 
	{
        // Your code here
		//lets have a que...
		Queue<Node> que=new ArrayDeque<>();
		que.add(root);
		int level=0;
		while(que.size()>0)
		{
			ArrayList<Integer> al=new ArrayList<>();
			int size=que.size();
			while(size-->0)
			{
				Node rnode=que.remove();
				al.add(rnode.data);
				if(rnode.left!=null)que.add(rnode.left);
				if(rnode.right!=null)que.add(rnode.right);
			}
			if(level%2==0)
			{
				for(int i: al)
				{
					System.out.print(i+" ");
				}
			}
			else
			{
				print(al,0);
			}
			level++;
			
		}
    }
		public static void print(ArrayList<Integer> al, int i)
		{
			if(i==al.size())return;
			print(al,i+1);
			System.out.print(al.get(i)+" ");
		}
		
}
