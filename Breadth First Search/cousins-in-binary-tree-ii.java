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

    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<Integer> levelSums = new ArrayList<>();

        // First BFS: Calculate sum of nodes at each level
        while (!nodeQueue.isEmpty()) {
            int levelSum = 0;
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode cur = nodeQueue.poll();
                levelSum += cur.val;
                if (cur.left != null) nodeQueue.offer(cur.left);
                if (cur.right != null) nodeQueue.offer(
                    cur.right
                );
            }
            levelSums.add(levelSum);
        }

        // Second BFS: Update each node's value to sum of its cousins
        nodeQueue.offer(root);
        int levelIndex = 1;
        root.val = 0; // Root has no cousins
        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            for (int i = 0; i < levelSize; ++i) {
                TreeNode cur = nodeQueue.poll();

                int siblingSum =
                    (cur.left != null ? cur.left.val : 0) +
                    (cur.right != null ? cur.right.val : 0);

                if (cur.left != null) {
                    cur.left.val = levelSums.get(levelIndex) -
                    siblingSum;
                    nodeQueue.offer(cur.left);
                }

                if (cur.right != null) {
                    cur.right.val = levelSums.get(levelIndex) -
                    siblingSum;
                    nodeQueue.offer(cur.right);
                }
            }
            ++levelIndex;
        }

        return root;
    }
}