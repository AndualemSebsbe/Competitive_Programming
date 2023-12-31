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
    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap();
        res = new ArrayList();
        traverse(root);
        return res;
    }
    
    public String traverse(TreeNode node){
        if(node == null) return "&";
        
        String subpath = node.val + "," + traverse(node.left) + "," + traverse(node.right);
        map.put(subpath, map.getOrDefault(subpath, 0) + 1);
        
        if(map.get(subpath) == 2)
            res.add(node);
        return subpath;
    }
}