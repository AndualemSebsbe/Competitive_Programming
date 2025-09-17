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
        if(root == null)
            return new ArrayList();

        Stack<TreeNode> st = new Stack();
        TreeNode curr = root;
        List<Integer> res = new ArrayList();

        while(curr != null || !st.empty()){
            while(curr != null){
                res.add(curr.val);
                st.add(curr);
                curr = curr.left;
            }

            curr = st.pop();
            curr = curr.right;
        }

        return res;
    }
}