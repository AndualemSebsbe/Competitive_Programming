/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// TC : O(logn) SC : O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode left = null;
        TreeNode right = null;
        
        if(root.val > p.val && root.val > q.val)
           left = lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            right = lowestCommonAncestor(root.right, p, q);
        else
            return root;
        
        return left == null ? right : left;
    }
}