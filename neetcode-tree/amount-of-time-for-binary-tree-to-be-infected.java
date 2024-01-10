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
    Map<Integer, List<Integer>> graph = new HashMap();
    public int amountOfTime(TreeNode root, int start) {
        buildAdjacent(root, null);

        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet();
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : graph.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize -= 1;
            }
            minute += 1;
        }

        return minute - 1;
    }

    void buildAdjacent(TreeNode root, Integer parent){
        if(root == null)
            return;
        
        graph.put(root.val, new ArrayList());
        if(parent != null)
            graph.get(root.val).add(parent);
        if(root.left != null)
            graph.get(root.val).add(root.left.val);
        if(root.right != null)
            graph.get(root.val).add(root.right.val);

        buildAdjacent(root.left, root.val);
        buildAdjacent(root.right, root.val);
    }
}