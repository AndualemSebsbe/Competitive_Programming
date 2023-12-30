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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;

        int val1 = 0, val2 = 0;
        TreeNode left1 = null, right1 = null;
        TreeNode left2 = null, right2 = null;
        if(root1 != null){
            val1 = root1.val;
            left1 = root1.left;
            right1 = root1.right;
        }

       if(root2 != null){
           val2 = root2.val;
           left2 = root2.left;
           right2 = root2.right;
        }

        TreeNode res = new TreeNode(val1 + val2);
        res.left = mergeTrees(left1, left2);
        res.right = mergeTrees(right1, right2);

       return res;
    }
}