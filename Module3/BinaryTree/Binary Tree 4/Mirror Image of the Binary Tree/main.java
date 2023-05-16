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
        if(val > root.val){
            root.right = insert(root.right, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }
    Node mirror(Node mainRoot, Node mirrorRoot)
	{
        //Write code here
		//we'll use dfs.. here we go..
		if(mainRoot==null)return null;
		Node t1=mainRoot.right;
		mainRoot.right=mirror(mainRoot.left,mirrorRoot);
		mainRoot.left=mirror(t1,mirrorRoot);
		return mainRoot;
		
    }
}

public class Main {
    public static void traversal(BST t, Node curr){
        if(curr == null)
            return;
        traversal(t, curr.left);
        System.out.print(curr.val + " ");
        traversal(t, curr.right);
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        BST mirror = new BST();
        mirror.root = t.mirror(t.root, mirror.root);
        traversal(mirror, mirror.root);
    }
}
