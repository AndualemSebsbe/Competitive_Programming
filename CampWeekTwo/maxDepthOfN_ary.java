import java.util.List;

public class maxDepthOfN_ary {

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int max = 0;
        for(Node child : root.children)
            max = Math.max(max, maxDepth(child));
        return max + 1;
    }

    class Node{
        public int val;
        public List<Node> children;
        public Node(int val){
            this.val = val;
        }

        public Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }
}