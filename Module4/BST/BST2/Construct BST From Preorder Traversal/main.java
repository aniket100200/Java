import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
static int idx;
    public static TreeNode CreateTree(int n,int[] preOrder)
	{
		idx=0;
        // Write Your Code here
		//1)observation is that 1)st node is root node...

		TreeNode root=construct(preOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);
		return root;
    }
	static TreeNode construct(int[] arr, int l, int r)
	{
		if(idx==arr.length)return null;
		if(l>r)return null;
		if(arr[idx]<l || arr[idx]>r)return null;
		TreeNode me=new TreeNode(arr[idx]);
		idx++;
		me.left=construct(arr,l,me.val-1);
		me.right=construct(arr,me.val+1,r);
		return me;
	}
	

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
