/* Soltino Tc: O(n2) && sc : O(H)*/
import java.util.*;

public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  // function to construct a BST from
  // its level order traversal
  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }
	public static int height(Node root)
	{
		if(root==null)return 0;
		return Math.max(height(root.left),height(root.right))+1;
	}

  public static boolean isBalanced(Node root) {
    // your code here
	  if(root==null)return true;
//a Tree is said to be balaced if an only if.. when diff 
	//of height of left and height of right subtree at each node..
	//|lh-rh|<=1
	int lh=height(root.left);
	int rh=height(root.right);
	boolean isLeftBalce=isBalanced(root.left);
	boolean isRightBalce=isBalanced(root.right);
	int check=Math.abs(lh-rh);
	boolean flag=false;
	  if(check<=1)
	  {
		flag=true; 
	  }
	  if(isLeftBalce&& isRightBalce && flag)
	  {
		  return true;
	  }
	  return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    if (isBalanced(root)) System.out.println("true"); else System.out.println(
      "false"
    );
  }
}

class Node 
{

  int data;
  Node left, right;
}
