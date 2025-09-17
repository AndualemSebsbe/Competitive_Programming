import java.util.PriorityQueue;

public class reachFurthestBuilding {
    
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int len = heights.length;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            for(int i = 1; i < len; i++){
                int diff = heights[i] - heights[i-1];
                if(diff > 0){
                    if(minHeap.size() < ladders){
                        minHeap.offer(diff);
                    }
                    else{
                        int br = diff;
                        if((minHeap.size() > 0) && (minHeap.peek() < diff)){
                            br = minHeap.poll();
                            minHeap.add(diff);
                        }
                        
                        if((bricks - br) >= 0){
                            bricks -= br;
                        }
                        else{
                            return i - 1;
                        }                                          
                    }
                }
            }
            return heights.length - 1;
        }
    }
