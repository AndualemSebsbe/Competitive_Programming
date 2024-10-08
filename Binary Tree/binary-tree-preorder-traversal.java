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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null)
            return res;
        
        Stack<TreeNode> st = new Stack();
        st.add(root);
        while (!st.isEmpty()) {
            TreeNode curNode = st.pop();
            res.add(curNode.val);

            if (curNode.right != null)
                st.add(curNode.right);
            
            if (curNode.left != null)
                st.add(curNode.left);
        }

        return res;
    }
}