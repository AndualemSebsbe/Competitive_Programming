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
    boolean res = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return res;

        if(root.val == subRoot.val)
            res = res || isSameTree(root, subRoot);

        isSubtree(root.left, subRoot);
        isSubtree(root.right, subRoot);
        return res;
    }

    boolean isSameTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        
        if(root == null || subRoot == null)
            return false;
        
        if(root.val != subRoot.val)
            return false;
        
        boolean left = isSameTree(root.left, subRoot.left);
        boolean right = isSameTree(root.right, subRoot.right);

        return left && right;
    }
}