/**************************************************Tc: O(N)------> Sc: O(N) ********************************************/
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
            if (!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        int x = sc.nextInt();
        int y = sc.nextInt();
        Solution g = new Solution();
        Node ans = g.findLCA(root,x,y);
        System.out.println(ans.data);
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

class Solution {
    public static Node findLCA(Node node,int n1,int n2) 
	{
       // write code here
		if(node==null)return null;
		ArrayList<Node> al=pathRootToNode(node,n1);
		
		ArrayList<Node> ls=pathRootToNode(node,n2);
int size=Math.min(al.size(),ls.size());
		int i=0;
		for(;i<size;i++)
		{
			if(al.get(i).data!=ls.get(i).data)return al.get(i-1);
		}
		return  al.get(i-1);
	}

	  public static boolean find(Node root,int b,ArrayList<Node> al)
	{
		if(root==null)return false;
		if(root.data==b){al.add(root); return true;}

		//let's chek if it is prsent ...
		if(find(root.left,b,al)){al.add(root);return true;}
		if(find(root.right,b,al)){al.add(root);return true;}
		return false;
	}
   public static  ArrayList<Node> pathRootToNode(Node root,int b)
	{
        // your code here
		ArrayList<Node> al=new ArrayList<>();
	boolean s=find(root,b,al);
		ArrayList<Node> ans=new ArrayList<>();
		for(int i=al.size()-1;i>=0;i--)
		{
			ans.add(al.get(i));
		}
		al=ans;
		return al;          
    }
}
