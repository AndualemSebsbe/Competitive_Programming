import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargest {
    int y = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      this.minHeap = minHeap;
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
        else if(minHeap.peek() != null && minHeap.peek() < val){
            minHeap.poll();
            minHeap.add(val);
          }
        
        return minHeap.peek();
    }
    public static void main(String[] args){
        // Your KthLargest object will be instantiated and called as such:
    int[] nums = {3, 4, 5, 6};
    int k = 3;
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number to be added");
    int val = input.nextInt();
    KthLargest obj = new KthLargest(k, nums);
    int param_1 = obj.add(val);
    System.out.println("the kth Largest Element is " + param_1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */