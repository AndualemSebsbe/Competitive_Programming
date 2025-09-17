import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class minHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] degree = new int[n];
        if(n == 1)
            list.add(0);
        if(n == 1) return list;
        
        int src = 0, dst = 0;
         for(int[] edge : edges){
             src = edge[0]; dst = edge[1];
             degree[src] += 1;
             degree[dst] += 1;
             graph.computeIfAbsent(src, l -> new ArrayList<>()).add(dst);
             graph.computeIfAbsent(dst, l -> new ArrayList<>()).add(src);
         }
        
        Queue<Integer> leaves = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(degree[i] == 1)
                leaves.add(i);
        }
        
        while(n > 2){
            int size = leaves.size();
            n -= size;
            
            while(size-- > 0){
                Integer leaf = leaves.remove();
                for(Integer val : graph.get(leaf)){
                    degree[val] -= 1;
                    if(degree[val] == 1)
                        leaves.add(val);
                }
            }
        }
        
        return new ArrayList<>(leaves);
    }
}