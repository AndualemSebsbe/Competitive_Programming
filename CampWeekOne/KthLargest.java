import java.util.PriorityQueue;

class KthLargest {
    int y = 0;
    PriorityQueue<Integer> minHeap;
    
    public KthLargest(int k, int[] nums) {
      minHeap = new PriorityQueue<>();
      y = k;
      if(nums.length >= k){
          for(int i = 0; i < k ; i++){
          minHeap.add(nums[i]);
      }
      }
      else{
          for(int i = 0; i < nums.length ; i++){
          minHeap.add(nums[i]);
      }
      }
      
      for(int i = k; i < nums.length; i++){
          if(minHeap.peek() < nums[i]){
            minHeap.poll();
            minHeap.add(nums[i]);
          }
      }
    }
    
    public int add(int val) {
        if(minHeap.size() < y)
            minHeap.add(val);
        else if((minHeap.peek() != null) && (minHeap.peek() < val)){
            minHeap.poll();
            minHeap.add(val);
          }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */