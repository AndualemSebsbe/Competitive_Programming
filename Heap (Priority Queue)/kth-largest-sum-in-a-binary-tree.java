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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }

            maxHeap.add(sum);
        }

        if (maxHeap.size() < k)
            return -1;
        while (k-- > 1)
            maxHeap.poll();
        return maxHeap.peek();
    }
}