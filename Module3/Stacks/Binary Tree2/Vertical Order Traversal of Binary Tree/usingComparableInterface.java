import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution 
{
	int leftMost ;
	int rightMost ;
	void solve(TreeNode root,int x)
	{
		if(root==null)return;
		//let's go left..
		leftMost=Math.min(x,leftMost);
		rightMost=Math.max(x,rightMost);
		solve(root.left,x-1);
		solve(root.right,x+1);
	}

	 class Pair implements Comparable<Pair>
    {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level)
        {
            this.node=node;
            this.level=level;
        }

        //every class has compareTo method
      
    //if your are not overrideing the compareTo Method it'lll comapre addresses only... I guess and it'll works as default...
    //let's override it that Priority que will give you the smallest value firs...
 @Override
    public int compareTo(Pair other)
    {
        if(this.level==other.level)
        {
            //this gives smaller person first..
            return this.node.data-other.node.data;
        }
        else
        {
            //as level is not same it'll give lower leve elemetn first...
            return this.level-other.level;
        }
    }
	}
    List<List<Integer>> VerticalTraversal(TreeNode root)
	{
		
		leftMost=Integer.MAX_VALUE;
		rightMost=Integer.MIN_VALUE;
		//let's try to travel vertically...>>>><<<<
		List<List<Integer>> list=new ArrayList<>();
		if(root==null)return list;
		solve(root,0);
		//I've the range left most and right most...

		int nOfLevel=rightMost-leftMost+1;
		int rootIndex=-leftMost;
		//let's create list of list of int... 
		// and intialise it with nOfLevels..
		for(int i=1;i<=nOfLevel;i++)
		{
			List<Integer> al=new ArrayList<>();
			list.add(al);
		}

		//it is created with empty arrayList...
		PriorityQueue<Pair> que=new PriorityQueue<>();

		que.add(new Pair(root,rootIndex));
		while(que.size()>0)
		{
			int size=que.size();
			PriorityQueue<Pair> cque=new PriorityQueue<>();
			while(size-->0)
			{
				Pair rnode=que.remove();
				list.get(rnode.level).add(rnode.node.data);
				if(rnode.node.left!=null)
				{
					cque.add(new Pair(rnode.node.left,rnode.level-1));
				}
				if(rnode.node.right!=null)
				{
					cque.add(new Pair(rnode.node.right,rnode.level+1));
				}
				
			}
			que=cque;
		}
		
return list;
    }
}

class Main {

    static TreeNode buildTree(String str) {
        if(str.length()==0 || str.charAt(0)=='N')
            return null;

        String ip[] = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            TreeNode currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new TreeNode(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            TreeNode root = buildTree(s);
            Solution ob = new Solution();
            List<List<Integer>> ans = ob.VerticalTraversal(root);
            for(int i = 0; i < ans.size(); i++) {
                for(int a : ans.get(i)) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
         
            t--;
        }
    }
}
