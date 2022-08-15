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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        int level = 0;
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        while(qu.size() > 0){
            int sz = qu.size();
            int[] levelAns = new int[sz];
            ArrayList<Integer> al = new ArrayList<Integer>();
            
            while(sz-- > 0){
                TreeNode node = qu.remove();
                if(level % 2 == 1) levelAns[sz] = node.val;
                else al.add(node.val);
                
                if(node.left != null) qu.add(node.left);
                if(node.right != null) qu.add(node.right);
            }
            if(level % 2 == 1){
                for(int e: levelAns) al.add(e);
            }
			
			ans.add(al);
            level++;
        }
        
        return ans;
    }
}