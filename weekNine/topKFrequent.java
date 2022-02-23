import java.util.HashMap;
import java.util.PriorityQueue;

class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) -                   map.get(a));
        
        maxHeap.addAll(map.keySet());
        
        int[] kFrequent = new int[k];     
        for(int i=0; i<k; i++)
            kFrequent[i] = maxHeap.remove();
        return kFrequent;                  
    }
}