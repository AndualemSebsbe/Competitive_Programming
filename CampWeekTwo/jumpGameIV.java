import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class jumpGameIV {  
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> valIndex = new HashMap<>();
        for(int i = 0; i < n; i++)
         valIndex.computeIfAbsent(arr[i], l -> new ArrayList<>()).add(i);   
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(0);
        visited.add(0);
        int step = 0;
        while(queue.size() > 0){
            int size = queue.size();
            
            while(size-- > 0){
                int val = queue.poll();
                if(val == n - 1)
                return step;
                
                List<Integer> list = valIndex.get(arr[val]);
                list.add(val - 1);
                list.add(val + 1);
                for(int i : list){
                    if((i >=0) && (i < n) && (!visited.contains(i))){
                        queue.add(i);
                        visited.add(i);
                    }
                }
                list.clear();
            }
            
            step++;
        }
        
        return step;
    }   
}