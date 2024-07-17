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
    List<TreeNode> res = new ArrayList();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet();
        for(int val : to_delete)
            set.add(val);

        dfs(root, set, true);
        return res;
    }

    void dfs(TreeNode node, Set<Integer> set, boolean isRoot){
        if(node == null)
            return;
        
        if(set.contains(node.val)){
            dfs(node.left, set, true);
            dfs(node.right, set, true);
        }
        else{
            if(isRoot)
                res.add(node);

            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left != null && set.contains(left.val))
                node.left = null;
            
            if(right != null && set.contains(right.val))
                node.right = null;
            
            dfs(left, set, false);
            dfs(right, set, false);
        }
    }
}