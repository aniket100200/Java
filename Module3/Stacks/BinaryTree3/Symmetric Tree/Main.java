import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Solution {
    public static void isSymmetrical(Node root)
	{
        //Write your code here and print output here
		if(root==null)return;
		ArrayList<Integer> al=Traverse(root.left);
		
		ArrayList<Integer> list=Traverse(root.right);	

		if(al.size()!=list.size())
		{
			System.out.println("NO");
			return;
		}
		for(int i=0;i<al.size();i++)
		{
			if(al.get(i)!=list.get(i))
			{
				System.out.println("NO");
			return;
			}
		}
		System.out.println("YES");
			return;

    }
	public static ArrayList<Integer> Traverse(Node root){
		ArrayList<Integer> al=new ArrayList<>();
		if(root==null)return al;
		al.add(root.data);
		ArrayList<Integer> a=Traverse(root.left);
		ArrayList<Integer> b=Traverse(root.right);
		for(int i: a)
		{
			al.add(i);
		}
		for(int i: b)
		{
			al.add(i);
		}
		return al;
	}
	static boolean isTreeSymmetrical(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.data != right.data) {
            return false;
        }
        return isTreeSymmetrical(left.left, right.right) && isTreeSymmetrical(left.right, right.left);
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
        g.isSymmetrical(root1);
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
