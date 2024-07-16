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
    String lcaToStart, lcaToEnd;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lcaNode = lca(root, startValue, destValue);
        StringBuilder path = new StringBuilder();
        dfs(lcaNode, path, startValue, destValue);

        int n = lcaToStart.length();
        String res = "";
        for(int i = 0; i < n; i++)
            res += 'U';
        res += lcaToEnd;
        return res;
    }

    void dfs(TreeNode node, StringBuilder path, int p, int q){
        if(node == null)
            return;

        if(node.val == p)
            lcaToStart = path.toString();
        if(node.val == q)
            lcaToEnd = path.toString();
        
        path.append('L');
        dfs(node.left, path, p, q);
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        dfs(node.right, path, p , q);
        path.deleteCharAt(path.length() - 1);
    }

    TreeNode lca(TreeNode node, int p, int q){
        if(node == null)
            return null;
        
        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);

        if((left != null && right != null) || node.val == p || node.val == q)
            return node;
        
        return (left == null) ? right : left;
    }
}