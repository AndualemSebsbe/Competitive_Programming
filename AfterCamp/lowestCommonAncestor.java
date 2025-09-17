package AfterCamp;
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
class lowestCommenAncestor {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
         if(height(root.left) == height(root.right))
             return root;
        else if(height(root.left) > height(root.right))
            return lcaDeepestLeaves(root.left);
        else if(height(root.left) < height(root.right))
            return lcaDeepestLeaves(root.right);
        
       return root; 
    }
    
    public int height(TreeNode root){
         if(root == null)
             return 0;
        int max = 0;
        int left = height(root.left);
        int right = height(root.right);
        max = Math.max(left, right);
        return max + 1;
    }
}