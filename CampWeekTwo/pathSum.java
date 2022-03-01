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
class pathSum {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node == null) return false;

        targetSum -= node.val;
        if(node.left == null && node.right == null)
        {
            if(targetSum == 0) return true;
            return false;
        }
        boolean left = hasPathSum(node.left, targetSum);
        boolean right = hasPathSum(node.right, targetSum);
        return (left || right);
    }
    
}