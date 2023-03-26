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
	public static class Pair
	{
		boolean bool;
		int height;
		Pair(boolean bool,int height)
		{
			this.bool=bool;
			this.height=height;
		}
	}

	public static Pair isBalanced_(Node root)
	{
		//let's talf about the base case...
		if(root==null) return new Pair(true,0);
		//here we go..
		Pair dlst=isBalanced_(root.left);
		Pair drst=isBalanced_(root.right);
		boolean isLeftBal=dlst.bool;
		boolean isRightBal=drst.bool;

		//let's calculate diffrece of |lh-rh|<=1... or not..
		int lh=dlst.height;
		int rh=drst.height;

		//int..
		int check=Math.abs(lh-rh);
		boolean isBal=false;
		if(check<=1){isBal=true;}
		if(isBal && (isLeftBal && isRightBal)){return new Pair(true,(Math.max(lh,rh)+1));}
		return new Pair(false,Math.max(lh,rh)+1);
	}

  public static boolean isBalanced(Node root)
	{
    // your code here
		return isBalanced_(root).bool;
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

class Node {

  int data;
  Node left, right;
}
