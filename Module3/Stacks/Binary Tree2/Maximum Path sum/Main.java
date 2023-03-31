import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            Node currNode = queue.peek();
            queue.remove();
                
            String currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
                
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String s= br.readLine();
	            Node root = buildTree(s);
	            
	            Solution tr=new Solution();
	            int sum=tr.findMaxSum(root);
	            System.out.println(sum);
	        }
	}
}

class Solution
{
	class Pair
	{
		int maxSum;
		int bestPathToAttach;
		public Pair(int maxSum, int bestPathToAttach)
		{
			this.maxSum=maxSum;
			this.bestPathToAttach=bestPathToAttach;
		}
		
	}
	Pair findMaxSum_(Node root)
	{
		//let's solve it recurssively... here we go...
		if(root==null)return new Pair(0,0);
		Pair left=findMaxSum_(root.left);
		Pair right=findMaxSum_(root.right);

		int SumThroughMe=root.data;
		if(left.bestPathToAttach>0)
		{
			SumThroughMe+=left.bestPathToAttach;
		}
		if(right.bestPathToAttach>0)
		{
			SumThroughMe+=right.bestPathToAttach;
		}
	int maxSum=Math.max(SumThroughMe,Math.max(left.maxSum,right.maxSum));
	int Attached=Math.max(0,Math.max(root.data,Math.max(root.data+left.bestPathToAttach,root.data+right.bestPathToAttach)));
		return new Pair(maxSum,Attached);

		
	}
    int findMaxSum(Node node)
	{
       //let's say we'll have pair..
		return findMaxSum_(node).maxSum;
    }   
}
