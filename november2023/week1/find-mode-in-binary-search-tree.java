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
    public int[] findMode(TreeNode root) {
        List<Integer> values = new ArrayList();
        inorderTraversal(root, values);

        int max = 0, count = 0, curNum = 0;
        List<Integer> ans = new ArrayList();
        for(int val : values){
            if(curNum == val){
                count += 1;
            }
            else{
                count = 1;
                curNum = val;
            }

            if(count > max){
                ans = new ArrayList();
                max = count;
            }
            
            if(count == max){
                ans.add(val);
            }
        }

        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        
        return res;
    }

    // inorder traversal visits the node in sorted order
    void inorderTraversal(TreeNode node, List<Integer> values){
        if(node == null)
            return;

        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
    }
}