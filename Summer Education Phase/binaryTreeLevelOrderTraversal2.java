import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal2 {
//  Definition for a binary tree node.
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
         this.right = right;
      }
  }
 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList();
        
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList(); 
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
                
                level.add(cur.val);
            }
            res.add(level);
        }
        
        int l = 0, r = res.size()-1;
        while(l < r){
            List<Integer> temp = res.get(l);
            res.set(l++, res.get(r));
            res.set(r--, temp);
        }
        
        return res;
    }
}