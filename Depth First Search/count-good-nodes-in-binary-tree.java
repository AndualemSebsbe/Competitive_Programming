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
    public int goodNodes(TreeNode root) {      
        return countGoodNodes(root, root.val);
    }

    int countGoodNodes(TreeNode root, int max){
        if(root == null)
            return 0;

        int res = root.val >= max ? 1 : 0;
        
        max = Math.max(max, root.val);
        
        res += countGoodNodes(root.left, max);
        res += countGoodNodes(root.right, max);
        return res;
    }    
}