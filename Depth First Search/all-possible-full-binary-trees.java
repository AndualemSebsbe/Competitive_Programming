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
    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> memo = new HashMap();
        return backtrack(n, memo);
    }

    List<TreeNode> backtrack(int n, Map<Integer, List<TreeNode>> memo){
        if(n == 0)
            return new ArrayList();
        
        if(n == 1){
            List<TreeNode> list = new ArrayList();
            list.add(new TreeNode());
            return list;
        }

        if(memo.containsKey(n))
            return memo.get(n);
        
        List<TreeNode> res = new ArrayList();
        for(int l = 0; l < n; l++){
            int r = n - l - 1;
            List<TreeNode> leftTrees = backtrack(l, memo);
            List<TreeNode> rightTrees = backtrack(r, memo);

            for(TreeNode t1 : leftTrees){
                for(TreeNode t2 : rightTrees){
                    res.add(new TreeNode(0, t1, t2));
                }
            }
        }

        memo.put(n, res);
        return res;
    }
}