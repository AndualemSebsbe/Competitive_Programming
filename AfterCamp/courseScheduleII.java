import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class courseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> vis = new ArrayList();
        HashMap<Integer, List<Integer>> graph = new HashMap();
     
        int src = 0, dst = 0;
        int[] inDegree = new int[numCourses];
        
        for(int[] pre : prerequisites){
            dst = pre[0]; src = pre[1];
            inDegree[dst] += 1;
           // graph.computeIfAbsent(src, l -> new ArrayList()).add(dst); OR
            if(!graph.containsKey(src)){
                List<Integer> list = new ArrayList<>();
                list.add(dst);
                graph.put(src, list);
            }
            else{
                graph.get(src).add(dst);
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if((inDegree[i] == 0) && (!vis.contains(i))){
                dfs(i, vis, graph, inDegree);
            }
        }
        
        int[] topoSort = new int[vis.size()];
        // System.out.println(vis.size());
        int i = 0;
        for(Integer val : vis){
            topoSort[i] = val;
           i++;
        }
        if(numCourses != vis.size())
            return new int[]{};
    return topoSort;    
    }
    
    public void dfs(int i, List<Integer> vis, Map<Integer, List<Integer>> graph, int[] inDegree){
        if(inDegree[i] != 0) return;
        
        vis.add(i);
        List<Integer> list = graph.get(i);
        for(int j = 0; (list != null) && (j < list.size()); j++){
            inDegree[list.get(j)] -= 1;
            dfs(list.get(j), vis, graph, inDegree);
        }  
    }
}