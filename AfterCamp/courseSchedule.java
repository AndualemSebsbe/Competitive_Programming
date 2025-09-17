package AfterCamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        int dst = 0, src = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        
        for(int[] pre : prerequisites){
            dst = pre[0]; src = pre[1];
            inDegree[dst] += 1;
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
            
            if(inDegree[i] == 0)
                queue.add(i);
        }
        
        int count = 0;
        while(queue.size() > 0){
            int curr = queue.remove();
            count += 1;
            List<Integer> list = new ArrayList<>();
            list = graph.get(curr);
            for(int i = 0; (list != null) && (i < list.size()); i++){
                inDegree[list.get(i)] -= 1;
                if(inDegree[list.get(i)] == 0)
                    queue.add(list.get(i));
            }           
//             System.out.println(list);
        }
        
        return count == numCourses;
    }
}