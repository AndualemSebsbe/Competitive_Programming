import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class restoreArrayFromAdjacenntPairs {
    int i = 0;
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = adjacentPairs.length;
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int[] pair : adjacentPairs){
            int src = pair[0], dst = pair[1];
            if(!graph.containsKey(src))
                graph.put(src, new ArrayList<>());
            graph.get(src).add(dst);
            indegree.put(src, indegree.getOrDefault(src, 0) + 1);

            if(!graph.containsKey(dst))
                graph.put(dst, new ArrayList<>());
            graph.get(dst).add(src);
            indegree.put(dst, indegree.getOrDefault(dst, 0) + 1);
        }

        int[] nums = new int[len+1];
        Set<Integer> visited = new HashSet<>();
        
        for(int key : indegree.keySet()){
            if(indegree.get(key) == 1){
                nums[i++] = key;
                visited.add(key);
                dfs(graph, key, nums, visited);
                break;
            }
        }

        return nums;
    }

    void dfs(Map<Integer, List<Integer>> graph, int key,
     int[] nums, Set<Integer> visited){
        if(graph.containsKey(key)){
            for(int val : graph.get(key)){
                if(!visited.contains(val)){
                    nums[i++] = val;
                    visited.add(val);
                    dfs(graph, val, nums, visited);
                }
            }
        }
    }
}