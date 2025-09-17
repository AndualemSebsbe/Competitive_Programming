class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return checkPath(root, head);
    }

    private boolean checkPath(TreeNode node, ListNode head) {
        if (node == null) 
            return false;
        if (dfs(node, head)) 
            return true;

        return checkPath(node.left, head) || checkPath(node.right, head);
    }

    private boolean dfs(TreeNode node, ListNode head) {
        if (head == null) 
            return true; 
        if (node == null) 
            return false; 

        if (node.val != head.val) 
            return false;

        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}