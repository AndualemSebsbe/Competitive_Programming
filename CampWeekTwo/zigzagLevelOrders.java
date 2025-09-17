import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class zigzagLevelOrders {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> aList = new ArrayList<List<Integer>>();
        if(root == null) return aList;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverselist = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
              
                     if(curr.left != null)
                        queue.add(curr.left);
                     if(curr.right != null)
                        queue.add(curr.right);
            }
             if(reverselist) Collections.reverse(list);
            aList.add(list);
            reverselist = !reverselist;
        }
        return aList;
    }
}