import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class jumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.add(start);
        while(queue.size() > 0){
            int val = queue.poll();
            
            if(arr[val] == 0) return true;
            
            visited.add(val);
            if((!visited.contains(val - arr[val])) && ((val - arr[val]) >= 0))
                queue.add(val - arr[val]);
            if((!visited.contains(val + arr[val])) && ((val + arr[val]) < arr.length))
                queue.add(val + arr[val]);
            // if((queue.size() > 0) && (queue.peek() == val)) return false;
        }
        return false;
    }
}