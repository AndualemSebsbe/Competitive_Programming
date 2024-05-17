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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode res = null;
        for(int i = 0; i < 3000; i++){
            if(root.left == null && root.right == null){
                if(root.val == target)
                    return null;
                else
                    return root;
            }

            res = removeLeaves(root, target);
            root = res;
        }
        return res;
    }

    TreeNode removeLeaves(TreeNode node, int target){
        if(node.left != null){
            if(node.left.left == null && node.left.right == null){
                if(node.left.val == target)
                    node.left = null;
                // return node;
            }
            else
                removeLeaves(node.left, target);
        }

        if(node.right != null){
            if(node.right.left == null && node.right.right == null){
                if(node.right.val == target)
                    node.right = null;
                // return node;
            }
            else
                removeLeaves(node.right, target);
        }

        return node;
    }
}