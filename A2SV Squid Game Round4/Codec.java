import java.util.Queue;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    
    public String preorder(TreeNode root){
        if(root == null)
            return "*";
    
        return root.val + "," + preorder(root.left) + "," + preorder(root.right);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preorder(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));
        
        return deserializeHelper(queue);
    }
    
    public TreeNode deserializeHelper(Queue<String> queue){
        String s = queue.poll();
        if(s.equals("*"))
            return null;
        
        TreeNode res = new TreeNode(Integer.valueOf(s));
        res.left = deserializeHelper(queue);
        res.right = deserializeHelper(queue);
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));