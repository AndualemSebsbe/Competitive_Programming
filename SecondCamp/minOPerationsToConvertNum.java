import java.util.LinkedList;
import java.util.Queue;

public class minOPerationsToConvertNum {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[1001];
        int res = 0;
        q.add(start);
    
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(curr == goal) return res;
                if(curr < 0 || curr > 1000 || visited[curr] == 1)
                    continue;
                visited[curr] = 1;
                for(int num : nums){
                    q.add(curr + num);
                    q.add(curr - num);
                    q.add(curr ^ num);
                }
            }   
            res++;
        }
        return -1;
    }
}