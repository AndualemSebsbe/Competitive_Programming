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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    void traverse(TreeNode node, int val){
        if(node == null)
            return;

        val = val*10 + node.val;

        if(node.left == null && node.right == null)
            res += val;
        
        traverse(node.left, val);
        traverse(node.right, val);
    }
}