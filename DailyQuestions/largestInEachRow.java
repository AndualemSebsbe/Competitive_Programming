import java.util.ArrayList;
import java.util.List;

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
class largestInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return list;
    }
    public void helper(TreeNode root, List<Integer> list, int level){
        if(root == null) return;
        
        if(level == list.size())
            list.add(root.val);
        else
            list.set(level, Math.max(list.get(level), root.val));
        
        helper(root.left, list, level + 1);
        helper(root.right, list, level + 1);
    }
}