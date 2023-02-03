import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

class Solution {
    int left = 0, right = 0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> map = new HashMap();
        
        traverse(root, 0, 0, map);
        
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        List<int[]> li = new ArrayList();
        for(int i = left; i <= right; i++){
            li = map.get(i);
            Collections.sort(li, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
            List<Integer> lis = new ArrayList();
            for(int[] arr : li)
                lis.add(arr[1]);
            adjList.add(lis); 
        }
 
        return adjList;
    }
    
    public void traverse(TreeNode root, int col, int row, Map<Integer, List<int[]>> map){
        if(root == null) return;
        
        left = Math.min(left, col);
        right = Math.max(right, col);
        
        if(!map.containsKey(col))
            map.put(col, new ArrayList());
        map.get(col).add(new int[]{row, root.val});
        
        traverse(root.left, col-1, row+1, map);
        traverse(root.right, col+1, row+1, map);
    }
}