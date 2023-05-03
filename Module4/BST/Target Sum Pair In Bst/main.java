//let's see
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio
	{
		class Pair{
			int s;
			int l;
			public Pair(int s,int l)
			{
				this.s=s;
				this.l=l;
			}
		}
	    public void Traverse(Node node, Node root, int tar,ArrayList<Pair> al)
		{
			if(node==null)return;
			Traverse(node.left,root,tar,al);
			
			//we'll find the compliment..
			int comp=tar-node.data;
			if(node.data<comp)
			{
				if(isFound(comp,root))
				{
					al.add(new Pair(node.data,comp));
				}
			}
			Traverse(node.right,root,tar,al);
		}

		boolean isFound(int data,Node root){
			if(root==null)return false;
			if(data<root.data)return isFound(data,root.left);
			if(data>root.data)return isFound(data,root.right);
			return true;
		}

    public void targetSum(Node root, int tar)
    {
        // your code here
		ArrayList<Pair>al=new ArrayList<>();
		Traverse(root,root,tar,al);
		if(al.size()==0){
			System.out.println(-1);return;
		}
		for(Pair p: al)
		{
			System.out.print(p.s+" "+p.l+" ");
		}
    }

}
