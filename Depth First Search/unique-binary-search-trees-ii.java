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
    public List<TreeNode> generateTrees(int n) {
        return allPossibleBST(1, n);
    }

    List<TreeNode> allPossibleBST(int start, int end){
        List<TreeNode> list = new ArrayList();

        if(start > end){
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubtrees = allPossibleBST(start, i - 1);
            List<TreeNode> rightSubtrees = allPossibleBST(i + 1, end);

            for(TreeNode lRoot : leftSubtrees){
                for(TreeNode rRoot : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = lRoot;
                    root.right = rRoot;
                    list.add(root);
                }
            }
        }

        return list;
    }
}