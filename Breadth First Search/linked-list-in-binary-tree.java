class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == head.val && bfs(cur, head))
                return true;

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

        return false;
    }

    private boolean bfs(TreeNode node, ListNode head) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isValid = false;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (head.next == null)
                    return true;
                
                if (cur.left != null && cur.left.val == head.next.val) {
                    queue.add(cur.left);
                    isValid = true;
                }

                if (cur.right != null && cur.right.val == head.next.val) {
                    queue.add(cur.right);
                    isValid = true;
                }

            }
            
            if (isValid)
                head = head.next;
        }

        return false;
    }
}