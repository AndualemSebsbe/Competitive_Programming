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
    public boolean isValidBST(TreeNode root) {
        
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isBST(TreeNode node, long left, long right){
        if(node == null)
            return true;
        
        if(!(node.val > left && node.val < right))
            return false;

        boolean res = isBST(node.left, left, node.val) &&
                isBST(node.right, node.val, right);
        return res;
    }
}