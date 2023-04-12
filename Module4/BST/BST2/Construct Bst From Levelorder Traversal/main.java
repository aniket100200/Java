import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Solution 
{
	class Helper
	{
		Node parent;
		int l;
		int r;
		Helper(Node parent, int l, int r)
		{
			this.parent=parent;
			this.l=l;
			this.r=r;
		}
	}
    Node bstFromLevel(int arr[], int n) 
	{
        // write code here
		//we can say...
		int idx=0;
		Queue<Helper> que=new ArrayDeque<>();
		//let's first initialise the 
		Node root=new Node(arr[idx]);
		que.add(new Helper(root,Integer.MIN_VALUE,root.data-1));
		que.add(new Helper(root,root.data,Integer.MAX_VALUE));
		idx=1;
		while(que.size()>0)
		{
			Helper curr=que.remove();
			if(idx==arr.length)continue;
			if(arr[idx]<curr.l || arr[idx]>curr.r)continue;
			//this may be left or right child...

			Node me=new Node(arr[idx]);
			idx++;
			if(me.data<curr.parent.data)curr.parent.left=me;
			else curr.parent.right=me;			
			//so I'll Insert my potential childs...
			que.add(new Helper(me,curr.l,me.data-1));
			que.add(new Helper(me,me.data+1,curr.r));		
			
		}

		return root;
    }
}
