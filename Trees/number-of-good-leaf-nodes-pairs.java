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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    Map<Integer, Integer> dfs(TreeNode node, int dis){
        if(node == null)
            return new HashMap();
        
        Map<Integer, Integer> map = new HashMap();
        map.put(1, 1);
        if(node.left == null && node.right == null)
            return map;
        
        Map<Integer, Integer> left = dfs(node.left, dis);
        Map<Integer, Integer> right = dfs(node.right, dis);

        for(int lKey : left.keySet()){
            int leftFreq = left.get(lKey);
            for(int rKey : right.keySet()){
                int rightFreq = right.get(rKey);

                if(lKey + rKey <= dis)
                    count += (leftFreq * rightFreq);
            }
        }

        Map<Integer, Integer> par = new HashMap();
        for(int lKey : left.keySet()){
            int leftFreq = left.get(lKey);
            if(lKey + 1 <= dis)
                par.put(lKey + 1, leftFreq);
        }

        for(int rKey : right.keySet()){
            int rightFreq = right.get(rKey);
            if(rKey + 1 <= dis)
                par.put(rKey + 1, par.getOrDefault(rKey + 1, 0) + rightFreq);
        }

        return par;
    }
}