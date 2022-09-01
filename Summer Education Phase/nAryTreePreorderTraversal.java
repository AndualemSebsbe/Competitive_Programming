import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class nAryTreePreorderTraversal {
    
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
    
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        
        Stack<Node> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()){
           Node cur = st.pop();
           res.add(cur.val);
           
            for(int i = cur.children.size()-1; i >= 0; i--){
                st.add(cur.children.get(i));
            }
        }
        
        return res;
    }
}