//This was So Easy ******/
import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val)
	{
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){
        
    }
    BST(Node root){
        root=root;
    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.val == val)
            return root;
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    void print(Node root){
        System.out.print(root.val + " ");
        if(root.left != null){
            print(root.left);
        }
        if(root.right != null){
            print(root.right);
        }
    }
}

class Solution{
	public int min(Node root)
	{
		//min will be left most node..
		if(root.left==null)return root.val;
		return min(root.left);
	}
    public Node deleteNode(Node root, int val)
	{
		if(root==null)return root;
        /*let's delete... the node.. with val... 
		*1) I'll have to search for the node...  
		* 2) will to delete the node...
		  *i) as it is a leaf node it is easy to delete it...
		  *ii) as it has only left child then also easy
		  *iii) as it is only having right child then it is difficult...	
			*iv) if if has Two childs then we'll have decide which one has to delete...
		*/

		if(val<root.val)
		{
			root.left= deleteNode(root.left,val);
		}
			
		else if(val>root.val)
		{
			root.right= deleteNode(root.right,val);
		}

		else
		{
			//I'll be here if an only if it has root.val and val are same or...the node to be deleted..
		
			//It's easy...	
		
			//how can I delete it...

			if(root.left==null && root.right==null)
			{
				//this is leaf node..
				return null;
			}
			else if(root.left!=null && root.right==null)
			{
				//it has left child only... 
				return root.left;
			}
			else if(root.left==null && root.right!=null)
			{
				return root.right;
			}
			else
			{
				/* this means there are bothe the childs ...
				1)I'll have to find the replacement for the node...
			*find the max of left subtree || find the min of right subtree
			*/
				int minInRightSubTree=min(root.right);
				//this is replacement.. let's say...
				root.val=minInRightSubTree;
				//I'll have to delete the that node as we don't want duplicates....
				root.right=deleteNode(root.right,minInRightSubTree);
			}
		}
		return root;
		
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        Solution obj=new Solution();
        t.root= obj.deleteNode(t.root, k);
        t.print(t.root);
    }
}
