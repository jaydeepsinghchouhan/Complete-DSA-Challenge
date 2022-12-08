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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> s1 = getSequence(root1);
        List<Integer> s2 = getSequence(root2);
        if (s1.size() != s2.size()) {
            return false;
        }
        for (int i = 0; i < s1.size(); i++) {
            if (s1.get(i) != s2.get(i)) {
                return false;
            }
        }
        return true;
    }
    private List<Integer> getSequence(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }
    private void dfs(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        dfs(root.left, result);
        dfs(root.right, result);
    }
}