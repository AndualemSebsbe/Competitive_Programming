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
    int preLen = 0;
    Map<Integer, Integer> inorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int right = inorder.length;
         inorderIdx = new HashMap();
         for(int i = 0; i < right; i++)
            inorderIdx.put(inorder[i], i);

         return build(inorder, 0, right - 1, preorder);
    }

    TreeNode build(int[] inorder, int l, int r, int[] preorder){
        if(l > r)
            return null;
        
        int rootVal = preorder[preLen++];
        TreeNode node = new TreeNode(rootVal);

        int nodeIdx = inorderIdx.get(rootVal);
        node.left = build(inorder, l, nodeIdx - 1, preorder);
        node.right = build(inorder, nodeIdx + 1, r, preorder);

        return node;
    }
}