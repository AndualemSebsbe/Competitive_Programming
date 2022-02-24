import java.util.Collections;
import java.util.PriorityQueue;

class lastStone {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
          maxHeap.add(i);
        if(maxHeap.size() == 1)
            return maxHeap.peek();
        while(!maxHeap.isEmpty() && maxHeap.size() >= 2){
            int y = maxHeap.remove();
            int x = maxHeap.remove();
            
            if(x != y){
                maxHeap.add(y - x);
            }
            if(maxHeap.size() == 1)
                return maxHeap.peek();
        }
        return 0;
    }
}