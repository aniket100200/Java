import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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
            if (i >= ip.length)
                break;
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution {

    public int solve(Node root)
	{
		if(root==null)return 0;
        // your code here
		List<List<Integer>>list=find(root);
		int max=0;
        for(List<Integer> l: list)
		{			
			max=Math.max(max,l.size());
		}
		return max;
    }
	/*** we'll solve this using BFS ******/
	List<List<Integer>> find(Node root)
	{
		List<List<Integer>> al=new ArrayList<>();
		Queue<Node> que=new ArrayDeque<>();
		que.add(root);
		while(que.size()>0)
		{
			int size=que.size();
			List<Integer> list=new ArrayList<>();
			while(size-->0)
			{
				Node rnode=que.remove();
				
				if(rnode.left!=null)que.add(rnode.left);				
				if(rnode.right!=null)que.add(rnode.right);
				list.add(rnode.data);
			}
			al.add(list);
		}
		return al;
	}
}
