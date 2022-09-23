import java.util.PriorityQueue;

public class minOperationsToHalveArraySum {

    public int halveArray(int[] nums) {
        
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b > a ? 1 : a==b ? 0 : -1);
        int idx = 0;
        double sum = 0.0;
        for(int num : nums){
            pq.add((double)num);
            sum += nums[idx++];
        }
        
        double half = sum/2;
        int count = 0;
        while(!pq.isEmpty() && sum > half){
            double max = pq.poll();
            max /= 2;
            pq.add(max);
            sum -= max;
            count += 1;
        }
        
        return count;
    }
}