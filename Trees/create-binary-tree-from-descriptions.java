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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap();
        Map<Integer, Boolean> hasParent = new HashMap();
        for(int[] desc : descriptions){
            int parVal = desc[0], childVal = desc[1], isLeft = desc[2];
            if(!map.containsKey(parVal))
                map.put(parVal, new TreeNode(parVal));
            
            if(!map.containsKey(childVal))
                map.put(childVal, new TreeNode(childVal));

            TreeNode parNode = map.get(parVal);
            TreeNode childNode = map.get(childVal);

            if(isLeft == 1)
                parNode.left = childNode;
            else
                parNode.right = childNode;
            
            hasParent.put(childVal, true);
        }


        for(int key : map.keySet()){
            if(!hasParent.containsKey(key))
                return map.get(key);
        }

        return null;
    }
}