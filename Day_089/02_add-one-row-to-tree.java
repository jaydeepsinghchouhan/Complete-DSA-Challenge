/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {TreeNode temp=new TreeNode(val);
             temp.left=root;
         return temp;// first edge case;
        }
        return helper(root,val,depth-1);}
        
        
  public TreeNode helper(TreeNode root, int val , int depth)
    {    if(depth<1)
           return root;
        
        if(root==null)
            return null;
        if(depth==1)
        {
            TreeNode temp1= new TreeNode(val);
            TreeNode temp2= new TreeNode(val);
            temp1.left=root.left;
            temp1.right=null;
            temp2.right=root.right;
            temp2.left=null;
            root.left=temp1;
            root.right=temp2;
              
        }
        
     else
     { helper(root.left,val,depth-1);
         helper(root.right,val,depth-1);
     }
   return root; }
}