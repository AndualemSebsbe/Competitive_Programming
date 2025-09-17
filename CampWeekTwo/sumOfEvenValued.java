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
class sumOfEvenValued {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        //base case
        if(root == null) return 0;
        dfs(root, null, null);
        return sum;
    }
    
    public void dfs(TreeNode root, TreeNode parent, TreeNode grandparent){
       if(root == null) return;
        
        if((grandparent != null) && (grandparent.val % 2 == 0))
            sum += root.val;
        if(root.left != null)
            dfs(root.left, root, parent);
        if(root.right != null)
            dfs(root.right, root, parent);
       
    }
}