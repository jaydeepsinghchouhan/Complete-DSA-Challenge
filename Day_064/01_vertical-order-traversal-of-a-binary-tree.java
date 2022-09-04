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
/*
    Approach:
    
    Store list of nodes according to the levels
    Nodes first should be stored by separating through vertical level, and then further these vertically separated nodes should be separated by rows(as nodes within same row and column should be sorted)
    
    So to store the nodes according to the above strategy, use HashMap as TreeMap so that the resultant list will be sorted by vertical level
    HashMap -> { verticalLevel, { horizontalLevel, List<Integers> nodes } }
    
    Understand through the example
    root = [1,2,3,4,6,5,7]
    
    Now the map will contain data like
    {
        -2 ->  { 
                 2 -> [4]
               }
        -1 ->  { 
                 2 -> [2]
               }
        0  -> {
                0 -> [1]
                2 -> [6,5]  // This will need to sort when generating resultant list i.e, [5,6]
              }
        1  -> {
                1 -> [3]
              }
        2  -> {
                2 -> [7]
              }
    }
    
	Then at last extract the resultant list from this map structure and return it
*/
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Map<Integer, Map<Integer,List<Integer>>> store = new TreeMap<>();
        
        solve(store,root,0,0);
        
        // Creating the resultant list using the maps structure 
        // along with sorting of the list of the nodes that have same row and column
        for(Integer key : store.keySet()){
            Map<Integer,List<Integer>> map = store.get(key);
            List<Integer> sub = new ArrayList<>();
            for(Integer mK : map.keySet()){
                List<Integer> e = map.get(mK);
                Collections.sort(e);
                sub.addAll(e);
            }
            res.add(sub);
        }
        
        return res;
    }
    
    private void solve(Map<Integer, Map<Integer,List<Integer>>> store, TreeNode root, int level, int hLevel){
        if(root == null) return;
        
        // Get the inner map from the outer map using vertical level
        Map<Integer,List<Integer>> map = (store.containsKey(level)) ? store.get(level) : new TreeMap<>();
        
        // Get the list of nodes from the inner map using horizontal level
        List<Integer> value = (map.containsKey(hLevel)) ? map.get(hLevel) : new ArrayList<>();

        // Add node in the list of nodes and update the list in the inner map and then
        // update the inner map in the outer map
        value.add(root.val);
        map.put(hLevel,value);
        store.put(level,map);
        
        // Call for left and right subtrees 
        solve(store,root.left,level-1,hLevel+1);
        solve(store,root.right,level+1,hLevel+1);
    }
}