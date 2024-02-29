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
    public boolean isEvenOddTree(TreeNode root) {
        boolean res = true;
        boolean isEven = true;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int prevMin = Integer.MAX_VALUE;
            int prevMax = Integer.MIN_VALUE;
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(isEven){
                    if(curr.val > prevMax && (curr.val % 2 == 1)){
                        prevMax = curr.val;
                    }
                    else{
                        res = false;
                        break;
                    }
                } else {
                    if(curr.val < prevMin && (curr.val % 2 == 0)){
                        prevMin = curr.val;
                    }
                    else {
                        res = false;
                        break;
                    }
                }

                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }

            isEven = !isEven;
        }

        return res;
    }
}