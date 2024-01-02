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
        TreeNode cur = root;
        int n = 0;
        Stack<TreeNode> st = new Stack();
        while(cur != null || !st.isEmpty()){
            while(cur !=  null){
                st.add(cur);
                cur = cur.left;
            }

            cur = st.pop();
            n += 1;
            if(n == k)
                return cur.val;
            
            cur = cur.right;
        }

        return root.val;
    }
}