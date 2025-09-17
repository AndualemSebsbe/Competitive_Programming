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
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap();
        backtrack(root, map);
        return res;
    }

    void backtrack(TreeNode root, Map<Integer, Integer> map){
        if(root == null)
            return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if(root.left == null && root.right == null){
            if(isPalindrome(map))
                res += 1;
        }

        backtrack(root.left, map);
        backtrack(root.right, map);

        map.put(root.val, map.get(root.val) - 1);
    }

    boolean isPalindrome(Map<Integer, Integer> map){
        int count = 0;
        for(int i = 1; i <= 9; i++){
            if(map.containsKey(i) && map.get(i) % 2 == 1)
                count += 1;
        }

        return count <= 1;
    }
}