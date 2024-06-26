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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedVals = new ArrayList();
        inorder(root, sortedVals);
        int n = sortedVals.size();
        TreeNode balancedBST = buildBalancedBST(sortedVals, 0, n - 1);
        return balancedBST;
    }

    void inorder(TreeNode node, List<Integer> sortedVals){
        if(node == null)
            return;
        
        inorder(node.left, sortedVals);
        sortedVals.add(node.val);
        inorder(node.right, sortedVals);
    }

    TreeNode buildBalancedBST(List<Integer> sortedVals, int l, int r){
        if(l > r)
            return null;
            
        int mid = l + (r - l) / 2;

        TreeNode node = new TreeNode(sortedVals.get(mid));
        node.left = buildBalancedBST(sortedVals, l, mid - 1);
        node.right = buildBalancedBST(sortedVals, mid + 1, r);

        return node;
    }
}