import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(int item){
        val = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)return null;
        int mid=(start+end)/2;
        if(root==null)root=new Node(arr[mid]);
        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);
        return root;
    }
}

class Solution{

    public static boolean checkTarget(Node root, int k)
	{
        //write code here
		ArrayList<Pair> al=new ArrayList<>();
		Traverse(root,root,k,al);		
		return al.size()==0?false :true;
    }
		static class Pair
	{
		int f;
		int l;
		Pair(int f,int l)
		{
			this.f=f;
			this.l=l;
		}
	}
   
	static void Traverse(Node root,Node node,int target,ArrayList<Pair> al)
	{
		if(node==null)return;
		Traverse(root,node.left,target,al);
		//need to find the compliment for the present node...
		int compliment=target-node.val;
		if(node.val<compliment)
		{
			if(find(root,compliment))
			{
				al.add(new Pair(node.val,compliment));
			}
		}

		Traverse(root,node.right,target,al);
	}
	static boolean find(Node root,int val)
	{
		if(root==null)return false;
		if(root.val==val)
		{
			return true;
		}
		return find(root.left,val)||find(root.right,val);
	}

}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt(); 
        }
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
        Solution A = new Solution();
        boolean ans = A.checkTarget(root,k);
        if(ans==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
