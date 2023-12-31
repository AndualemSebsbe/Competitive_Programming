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
    int postLen = 0;
    Map<Integer, Integer> inorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        postLen = postorder.length-1;
        inorderIdx = new HashMap();
        for(int i = 0; i < inLen; i++)
            inorderIdx.put(inorder[i], i);

        return build(inorder, 0, inLen-1, postorder);
    }

    TreeNode build(int inorder[],int inStart,int inEnd,int postorder[]){
        if(inStart > inEnd)
            return null;
        
        int rootval = postorder[postLen--];
        TreeNode root = new TreeNode(rootval);

        int rootIdx = inorderIdx.get(root.val);
        root.right = build(inorder, rootIdx+1, inEnd, postorder);
        root.left = build(inorder, inStart, rootIdx-1, postorder);
        return root;
    }
}

