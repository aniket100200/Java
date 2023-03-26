import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        // Your code here
		//you'll have to include first node at each level...
		List<List<Integer>> list=new ArrayList<>();
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
				al.add(rnode.val);
				if(rnode.left!=null)
				{
					que.add(rnode.left);
				}
			if(rnode.right!=null)
				{
					que.add(rnode.right);
				}
			}
			list.add(al);
		}
		for(List ls: list)
		{
			System.out.print(ls.get(0)+" ");
		}
    }
    
}
