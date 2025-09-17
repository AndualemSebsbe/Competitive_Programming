import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class nAryTreeLevelOederTraversal {
    
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


    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList();
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<Node> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList();
            for(int i = 0; i < size; i++){
                Node cur = q.poll();
                level.add(cur.val);
                for(Node child : cur.children){
                   q.add(child);
                }                
            }
            res.add(level);
        }
        
        return res;
    }
}