import java.util.*;

class Node 
{
  int data;
  Node left, right;
  Node(int d) 
	{
        data = d;
        left = right = null;
    }
}

class Solution
{
    static void sortedArrayToBST(int arr[], int n)
	{
        // Your code here
		//always let's pick the middle one....		
		int i=0;
		int j=n-1;
		int mid=(j+i)>>1;
		Node root=Construct(arr,0,n-1);
		print(root);
    }
	static class Pair
	{
		Node node;
		int state;
		Pair(Node node,int state)
		{
			this.node=node;
			this.state=state;
		}
	}
	static void print(Node root)
	{
			// Iterative DFS
		//let's we have stack first...
		Stack<Pair> st=new Stack<>();
		st.push(new Pair(root,1));

		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		ArrayList<Integer> l3=new ArrayList<>();
		
		while(st.size()>0)
		{
			Pair p=st.peek();
			if(p.state==1)
			{
				//visiting first time...
				l1.add(p.node.data);
				p.state++;
				if(p.node.left!=null)
				{
					st.push(new Pair(p.node.left,1));
				}
			}
			else if(p.state==2)
			{
				l2.add(p.node.data);
				p.state++;
				if(p.node.right!=null)st.push(new Pair(p.node.right,1));
			}
			else
			{
				l3.add(p.node.data);
				st.pop();
			}
		}
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
	}
	static Node Construct(int[] arr,int l,int r)
	{
		if(l>r)return null;		
		 //first you'll have to find the mid...
		int mid=(l+r)/2;
		Node me=new Node(arr[mid]);
		me.left=Construct(arr,l,mid-1);
		me.right=Construct(arr,mid+1,r);
		return me;
	}
}
public class Main 
{

  static Node getNode(int data)
{
    // Allocate memory
    Node newNode = new Node(data);
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
    Solution.sortedArrayToBST(tree, n);
  }
}
