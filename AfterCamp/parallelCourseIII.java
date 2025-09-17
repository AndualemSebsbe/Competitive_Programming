package AfterCamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class parallelCourseIII {
    public int minimumTime(int n, int[][] relations, int[] time) {
       int[] inDegree = new int[n + 1];
       HashMap<Integer, List<Integer>> graph = new HashMap<>();
       
       int src = 0, dst = 0;
        for(int[] rel : relations){
            src = rel[0]; dst = rel[1];
            inDegree[dst] += 1;
            graph.computeIfAbsent(src, l -> new ArrayList<>()).add(dst);
        }
        
    PriorityQueue<int[]> min_heap = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    
    for(int i = 1; i < n + 1; i++){
        if(inDegree[i] == 0)
            min_heap.add(new int[]{i, time[i - 1]});
    }
    
    int max = 0;
    while(min_heap.size() > 0){
        int[] val = min_heap.remove();
        int curr = val[0];
        if(graph.containsKey(curr)){
            List<Integer> list = graph.get(curr);
            for(int i = 0; list != null && i < list.size(); i++){
                inDegree[list.get(i)] -= 1;
                if(inDegree[list.get(i)] == 0){
                    time[list.get(i) - 1] += time[curr - 1];
                    min_heap.add(new int[]{list.get(i), time[list.get(i) - 1]});                    
                }
                
            }
        }
        max = Math.max(max, time[curr - 1]);
    }   
    return max;
  }
}