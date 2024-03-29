import java.util.ArrayList;
import java.util.List;

public class nAryTreePreorderTraversalDFS {
    
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};



    List<Integer> list = new ArrayList();
    public List<Integer> preorder(Node root) {
        if(root == null) return new ArrayList();
        
            list.add(root.val);
            for(Node child : root.children){     
                preorder(child);
            }
        
        return list;
    }
}