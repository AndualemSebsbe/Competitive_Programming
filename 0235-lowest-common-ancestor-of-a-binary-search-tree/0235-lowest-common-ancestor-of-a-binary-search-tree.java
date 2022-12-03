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
        if(root.val == p.val || root.val == q.val)
            return root;
        
        if((root.val < p.val && root.val > q.val) || (root.val > p.val && root.val < q.val))
            return root;
        
        TreeNode left = null;
        TreeNode right = null;
        
        if(root.val > p.val && root.val > q.val)
           left = lowestCommonAncestor(root.left, p, q);
        else
            right = lowestCommonAncestor(root.right, p, q);
        
        return left == null ? right : left;
    }
}