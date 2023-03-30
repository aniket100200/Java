import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) arr[i] = sc.next();
    int k = sc.nextInt();
    sc.close();
    BinaryTreeNode<Integer> tree = levelOrderCreateTree(arr);
    System.out.println(timeToBurnTree(tree, k));
  }

	static void findParent(BinaryTreeNode root,HashMap<BinaryTreeNode,BinaryTreeNode> putParent)
	{
		if(root==null)return;
		if(root.left!=null)putParent.put(root.left,root);
		if(root.right!=null)putParent.put(root.right,root);
		//let's left call...
		findParent(root.left,putParent);
		findParent(root.right,putParent);
	}
	public static BinaryTreeNode<Integer> findSource(BinaryTreeNode<Integer> root,int start)
	{
		if(root==null)return null;
		if(root.data==start)return root;

		BinaryTreeNode<Integer> filc=findSource(root.left,start);
		if(filc!=null)return filc;
		BinaryTreeNode<Integer>  firc=findSource(root.right,start);
		if(firc!=null)return firc;
		return null;
	}
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
{
	if(root==null)return 0;
    // your code here
	//let's have the parent--- child relationship...
	HashMap<BinaryTreeNode,BinaryTreeNode> getParent=new HashMap<>();
	findParent(root,getParent);

	//let's have the src
	BinaryTreeNode<Integer> src=findSource(root,start);
	if(src==null)return 0;
	HashSet<BinaryTreeNode<Integer>> visit=new HashSet<>();

	//let's have the que...
	Queue<BinaryTreeNode<Integer>> que=new ArrayDeque<>();

	que.add(src);
	visit.add(src);
	int level=0;
	while(que.size()>0)
	{
		int size=que.size();
		while(size-->0)
		{
			BinaryTreeNode<Integer> rnode=que.remove();
			if(rnode.left!=null && visit.contains(rnode.left)==false)
			{
				visit.add(rnode.left);
				que.add(rnode.left);
			}

			if(rnode.right!=null && visit.contains(rnode.right)==false)
			{
				visit.add(rnode.right);
				que.add(rnode.right);
			}

			//let's check for parent node....
			if(getParent.containsKey(rnode)==true && visit.contains(getParent.get(rnode))==false)
			{
				visit.add(getParent.get(rnode));
				que.add(getParent.get(rnode));
			}
		}
		level++;
	}
	return level-1;
}

  static void createTree(BinaryTreeNode<Integer> node, int i, String[] arr)
	{
    if (node != null) {
      if (2 * i + 1 < arr.length) {
        if (arr[2 * i + 1].equals("null")) {
          node.left = null;
        } else {
          node.left = new BinaryTreeNode<>(Integer.parseInt(arr[2 * i + 1]));
        }
        createTree(node.left, 2 * i + 1, arr);
      }
      if (2 * i + 2 < arr.length) {
        if (arr[2 * i + 2].equals("null")) {
          node.right = null;
        } else {
          node.right = new BinaryTreeNode<>(Integer.parseInt((arr[2 * i + 2])));
        }
        createTree(node.right, 2 * i + 2, arr);
      }
    }
  }

  static BinaryTreeNode<Integer> levelOrderCreateTree(String[] arr) {
    if (arr.length == 0) return null;
    BinaryTreeNode<Integer> head = new BinaryTreeNode<>(
      Integer.parseInt(arr[0])
    );
    createTree(head, 0, arr);
    return head;
  }
}

class BinaryTreeNode<T> 
{

  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) 
	{
    this.data = data;
  }
}
