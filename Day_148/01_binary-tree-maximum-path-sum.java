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
     public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        res[0] = root.val;
        maxBranchSum(root, res);
        return res[0];
    }
          
    public static int maxBranchSum(TreeNode root, int[] res) {
        if (root == null) return 0;
        
        int leftB = maxBranchSum(root.left, res);      // left fork without root
        int rightB = maxBranchSum(root.right, res);  // right fork without root

        int maxB = root.val + Math.max(leftB, rightB); 
        maxB = Math.max(root.val, maxB);               // max fork with root

        int maxPath = Math.max(maxB, root.val + leftB + rightB);   // max between max fork and the  arch

        res[0] = Math.max(res[0], maxPath); // update the final result
        return maxB;
    }
}