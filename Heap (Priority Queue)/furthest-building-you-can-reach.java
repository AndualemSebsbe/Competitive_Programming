class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i = 0; i < n - 1; i++){
            int diff = heights[i + 1] - heights[i];
            if(diff > 0)
                minHeap.add(diff);
            
            if(minHeap.size() > ladders)
                bricks -= minHeap.poll();
            
            if(bricks < 0)
                return i;
        }

        return n - 1;
    }
}