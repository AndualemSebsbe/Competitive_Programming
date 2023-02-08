import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class thirdMaxNumber {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        PriorityQueue<Integer> pq = new 
        PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num : set)
            pq.add(num);
        
        long max = nums[0], thirdMax = -2147483649L;
        for(int i = 0; i < set.size(); i++){
            if(i == 2)
                thirdMax = pq.peek();
            max = Math.max(max, pq.remove());
        }

        return thirdMax == -2147483649L ? (int)max : (int)thirdMax;      
    }
}