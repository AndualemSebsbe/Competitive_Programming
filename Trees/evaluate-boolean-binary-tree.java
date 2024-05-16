/**
 * Definition for a binary tree root.
 * public class Treeroot {
 *     int val;
 *     Treeroot left;
 *     Treeroot right;
 *     Treeroot() {}
 *     Treeroot(int val) { this.val = val; }
 *     Treeroot(int val, Treeroot left, Treeroot right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null){
            if(root.val == 0)
                return false;
            else
                return true;
        }

        
        if(root.val == 2)
            return evaluateTree(root.left) || evaluateTree(root.right);
        else
            return evaluateTree(root.left) && evaluateTree(root.right);
    }
}