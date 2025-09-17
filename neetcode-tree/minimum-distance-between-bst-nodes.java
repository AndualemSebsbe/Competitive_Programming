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
    Integer res = Integer.MAX_VALUE, prev = null;
    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return res; 
        
        minDiffInBST(root.left);

        if (prev != null) 
            res = Math.min(res, root.val - prev);           
        prev = root.val;

        minDiffInBST(root.right);
        return res;
    }
}