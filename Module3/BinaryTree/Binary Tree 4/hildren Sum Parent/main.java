//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root==null)return 1;
        if(root.left==null && root.right==null)return 1;
        
        int leftIsFollowing=isSumProperty(root.left);
        int rightIsFollowing=isSumProperty(root.right);
        
        int myChild=0;
        if(root.left!=null)myChild+=root.left.data;
        if(root.right!=null)myChild+=root.right.data;
        
       int isFollowed=0;
       if(root.data==myChild)isFollowed=1;
       if(isFollowed==1 && leftIsFollowing==1 && rightIsFollowing==1)return 1;
        return 0;
        
    }
}
