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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        traverse(root, list);
        return list.get(k-1);
    }

    void traverse(TreeNode node, List<Integer> list){
        if(node == null)
            return;
        
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}