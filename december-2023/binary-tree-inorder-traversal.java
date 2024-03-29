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
    public List<Integer> inorderTraversal(TreeNode root) { 
        Stack<TreeNode> st = new Stack();
        TreeNode curr = root;
        List<Integer> res = new ArrayList();

         while(curr != null || !st.empty()){
             while(curr != null){
                 st.add(curr);
                 curr = curr.left;
             }

             curr = st.pop();
             res.add(curr.val);
             
             curr = curr.right;
         }

         return res;
    }
}