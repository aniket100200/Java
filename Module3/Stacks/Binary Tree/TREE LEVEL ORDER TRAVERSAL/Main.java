import java.util.*;

public class Main {

  static Node getNode(int data) 
{
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
 }

  // function to construct a BST from
  // its level order traversal
  static Node LevelOrder(Node root, int data) 
{
    if (root == null)
	{
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) 
{
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static List<List<Integer>> levelOrder(Node root) 
{
	List<List<Integer>> ans=new ArrayList<>();
	//let's make a que...
	Queue<Node> que=new ArrayDeque<>();
	que.add(root);
	while(que.size()>0)
	{
		List<Integer> ls=new ArrayList<>();
		int size=que.size();
		while(size-- >0)
		{
			Node rnode=que.remove();
			ls.add(rnode.data);
			if(rnode.left!=null){que.add(rnode.left);}
			if(rnode.right!=null){que.add(rnode.right);}
		}
		ans.add(ls);
	}
	return ans;
		
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
  List<List<Integer>> list=levelOrder(root);
	  for(List<Integer> ls:list)
	  {
		  for(int i: ls)
		  {
			  System.out.print(i+" ");
		  }		 
	  }
	  
  }
}

class Node 
{

  int data;
  Node left, right;
}
