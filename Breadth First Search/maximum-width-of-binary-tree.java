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
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList();
        root.val = 1;
        q.add(root);

        while(!q.isEmpty()){
            int left = q.peek().val; 
            int right = left;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    curr.left.val = 2 * curr.val - 1;
                    q.add(curr.left);
                }
                
                if(curr.right != null){
                    curr.right.val = 2 * curr.val;
                    q.add(curr.right);
                }

                if(i == size-1)
                    right = curr.val;
            }

            max = Math.max(max, right-left+1);
        }

        return max; 
    }
}