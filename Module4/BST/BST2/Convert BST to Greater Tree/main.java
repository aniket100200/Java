import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode f = q.poll();
            System.out.print(f.val + " ");
            if (f.left != null)
                q.add(f.left);
            if (f.right != null)
                q.add(f.right);
        }
        System.out.println();
    }

    public TreeNode levelOrder(TreeNode root, int value) {
        if (root == null) {
            TreeNode nnode = new TreeNode(value);
            return nnode;
        }
        if (value <= root.val)
            root.left = levelOrder(root.left, value);

        else
            root.right = levelOrder(root.right, value);
        return root;
    }

    public TreeNode constructBST(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return null;
        TreeNode root = null;
        for (int i = 0; i < n; i++)
            root = levelOrder(root, arr[i]);
        return root;
    }
}
class Solution 
{
	int sum=0;
	Stack<Pair>st;
	class Pair
	{
		int state;
		TreeNode node;
		public Pair(TreeNode node, int state)
		{
			this.node=node;
			this.state=state;
		}		
	}
	Solution()
	{
		st=new Stack<Pair>();
	}
    public TreeNode convertBST(TreeNode root)
	{
		ArrayList<Integer> al=new ArrayList<>();
	     st.push(new Pair(root,1));
		while(st.size()>0)
		{
			Pair top=st.peek();
			if(top.state==1)
			{
				//first time watching that node..
				//let's increase it's potenti..
				top.state++;
				//you need first Inorder and that is reverse..
				if(top.node.right!=null)st.push(new Pair(top.node.right,1));				
			}
			else if(top.state==2)
			{
				al.add(top.node.val);
				top.state++;
				//this the time to do the work...
				top.node.val+=sum;
				sum=top.node.val;
				if(top.node.left!=null)st.push(new Pair(top.node.left,1));
				
				
			}
			else
			{
				st.pop();
			}
		}
		//System.out.print(al);
		return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splited = s.split("\\s+");
        int n = splited.length;
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(splited[i]);
        TreeNode root = new TreeNode();
        root = root.constructBST(input);
        Solution Obj = new Solution();
        root = Obj.convertBST(root);
        root.printTree(root);
        sc.close();
    }
}
