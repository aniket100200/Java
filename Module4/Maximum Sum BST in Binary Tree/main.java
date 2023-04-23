import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

//https://course.acciojob.com/idle?question=504e980e-fbca-4776-9612-7c0d4dd7cc2c
class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution g = new Solution();
        sc.close();
        int ans = g.maxSumBST(root);
        System.out.print(ans);
    }
}

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

class Solution 
{
    class Helper
    {
        int mini;
        int maxi;
        int sum;
        int maxSum;
        boolean isBST;
        Helper(boolean isBST,int mini,int maxi,int sum,int maxSum)
        {
            this.mini=mini;
            this.maxi=maxi;
            this.sum=sum;
            this.maxSum=maxSum;
            this.isBST=isBST;
        }
    }
    public Helper maxSumBST_(Node root)
    {
        if(root==null)return new Helper(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);

        Helper left=maxSumBST_(root.left);
        Helper right=maxSumBST_(root.right);

        //when it is bst...
        if(left.isBST && right.isBST && root.data>left.maxi && root.data<right.mini)
        {
            int myMini=Math.min(root.data,left.mini);
            int myMaxi=Math.max(root.data,right.maxi);
            int sum=left.sum+right.sum+root.data;
            int maxSum=Math.max(sum,Math.max(left.maxSum,right.maxSum));
            return new Helper(true,myMini,myMaxi,sum,maxSum);
        }

        //agar bst hi nhi hai toh kehl khtm... here we go..
        return new Helper(false,0,0,0,Math.max(left.maxSum,right.maxSum));
    }

    public int maxSumBST(Node root) 
    {
        return maxSumBST_(root).maxSum;
    }
}
