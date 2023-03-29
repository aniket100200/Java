/******* O(N)---->  O(H)>>>>> sc*******/
import java.util.*;

class Node {

  int data;
  Node left, right;
}

class Solution{
	static void printLeftWall(Node root)
	{
		//here you'll have to move in left as left as possible 
		//if there is no left then try to go towards the right...
		
		if(root==null)return;

		//let's remove the leaf nodes from the left wall..
		if(root.right==null && root.left==null)return;
		System.out.print(root.data+" ");
		printLeftWall(root.left);
		if(root.left==null)printLeftWall(root.right);
	}

	static void printRightWall(Node root)
	{
		//here you'll have to move in  as right as possible 
		//if there is no right then try to go towards then left...		
		if(root==null)return;
		if(root.right==null && root.left==null)return;
		printRightWall(root.right);
		if(root.right==null)printRightWall(root.left);
		// you have to print in reverse order...
		System.out.print(root.data+" ");
	}
    static void printBoundary(Node node)
    {
        // Your code here
		//let's travel around the boundary...

		//step1: let's print root node..
		System.out.print(node.data+" ");

		//step2: print left walll..
		printLeftWall(node.left);

		//step3: print bottom wall..

		printBottomWall(node);

		//step4 : print the right Wall...
		printRightWall(node.right);
		   }

	static void printBottomWall(Node root)
	{
		if(root==null)return ;
		//you'll have to print all leaf nodes..
		if(root.left==null && root.right==null)
		{
			System.out.print(root.data+" ");
		}
		
		printBottomWall(root.left);
		printBottomWall(root.right);
	}
}
public class Main {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    Solution.printBoundary(root);
  }
}
