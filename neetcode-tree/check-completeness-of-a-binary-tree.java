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
  public boolean isCompleteTree(TreeNode root) {
    if (root == null)
      return true;

    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));
    
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      
      if(node != null){
          q.offer(node.left);
          q.offer(node.right);
      }
      else{
          while(!q.isEmpty()){
              if(q.poll() != null)
                return false;
          }
      }
    }

    return true;
  }
}