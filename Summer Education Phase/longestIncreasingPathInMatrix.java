import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class longestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int n = row*col;
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(r+1 < row && matrix[r+1][c] > matrix[r][c]){
                    List<Integer> lst = graph.getOrDefault(r*col + c, new ArrayList());
                    lst.add((r+1)*col + c);
                    graph.put(r*col + c, lst);
                    inDegree[(r+1)*col + c] += 1;
                }
                
                if(r-1 >= 0 && matrix[r-1][c] > matrix[r][c]){
                    List<Integer> lst = graph.getOrDefault(r*col + c, new ArrayList());
                    lst.add((r-1)*col + c);
                    graph.put(r*col + c, lst);
                    inDegree[(r-1)*col + c] += 1;
                }
                
                if(c+1 < col && matrix[r][c+1] > matrix[r][c]){
                    List<Integer> lst = graph.getOrDefault(r*col + c, new ArrayList());
                    lst.add(r*col + c + 1);
                    graph.put(r*col + c, lst);
                    inDegree[r*col + c + 1] += 1;
                }
                
                if(c-1 >= 0 && matrix[r][c-1] > matrix[r][c]){
                    List<Integer> lst = graph.getOrDefault(r*col + c, new ArrayList());
                    lst.add(r*col + c - 1);
                    graph.put(r*col + c, lst);
                    inDegree[r*col + c - 1] += 1;
                }
            }
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0)
                q.add(i);
        }
        
        int step = 0;
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                if(graph.containsKey(cur)){
                    for(Integer child : graph.get(cur)){
                        inDegree[child] -= 1;
                        if(inDegree[child] == 0)
                            q.add(child);
                    }
                }
            }
            step += 1;
        }
        
        return step;
    }
}