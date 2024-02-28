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
    public int findBottomLeftValue(TreeNode root) {
        int val = root.val;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            val = q.peek().val;
            
            while(size-- > 0){
                TreeNode curr = q.poll();
                
                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);
            }
        }

        return val;
    }
}