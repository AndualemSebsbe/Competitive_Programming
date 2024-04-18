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
    String smallestStr = "";
    public String smallestFromLeaf(TreeNode root) {
        listOfString(root, "");
        
        return smallestStr;
    }

    void listOfString(TreeNode node, String currStr){
        if(node == null)
            return;
        
        currStr = (char)(node.val + 'a') + currStr;
        if(node.right == null && node.left == null){
            if(smallestStr.isEmpty() || smallestStr.compareTo(currStr) > 0)
                smallestStr = currStr;
        }
        
        listOfString(node.left, currStr);
        listOfString(node.right, currStr);
    }
}