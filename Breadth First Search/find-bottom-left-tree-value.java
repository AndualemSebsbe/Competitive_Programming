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
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            value = queue.peek().val;
            while(size-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }

        return value;
    }
}