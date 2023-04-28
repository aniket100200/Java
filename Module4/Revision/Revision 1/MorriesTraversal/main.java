class Solution {
    public List<Integer> inorderTraversal(TreeNode root)
    {
       List<Integer> pre=new ArrayList<>();
       List<Integer> in=new ArrayList<>();
       //Morries Traversal...
       TreeNode curr=root;
       while(curr!=null)
       {

           if(curr.left==null)
           {
                //this is special case...
                in.add(curr.val);
                pre.add(curr.val);
                curr=curr.right;
           }
           else
           {
                         TreeNode rmn=curr.left;
                    while(rmn.right!=null && rmn.right!=curr)
                    rmn=rmn.right;

                    //for second time..
                    if(rmn.right==curr)
                    {
                        in.add(curr.val);
                        rmn.right=null;
                        curr=curr.right;
                    }
                    else
                    {
                            pre.add(curr.val);
                            rmn.right=curr;
                            curr=curr.left;
                    }
           }
       }
       return in;
}
}
