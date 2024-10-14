class Solution {
    public long maxKelements(int[] nums, int k) {
        long max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums)
            pq.add(num);
        
        while (k-- > 0) {
            int num = pq.poll();
            max += num;
            pq.add((int)Math.ceil(num / 3.0));
        }

        return max;
    }
}