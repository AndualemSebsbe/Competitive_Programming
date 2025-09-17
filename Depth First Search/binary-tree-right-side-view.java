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
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        Set<Integer> visited = new HashSet();
        rightView(root, 0, visited);
        return res;
    }

    void rightView(TreeNode root, int level, Set<Integer> visited){
        if(root == null)
            return;
        
        if(!visited.contains(level)){
            res.add(root.val);
            visited.add(level);
        }

        rightView(root.right, level + 1, visited);
        rightView(root.left, level + 1, visited);
    }
}