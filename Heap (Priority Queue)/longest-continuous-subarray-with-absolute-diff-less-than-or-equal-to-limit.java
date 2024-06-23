class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0, n = nums.length;
        int l = 0, r = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        while(r < n){
            minHeap.add(new int[]{nums[r], r});
            maxHeap.add(new int[]{nums[r], r});

            while((maxHeap.peek()[0] - minHeap.peek()[0]) > limit){
                l = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;

                while(maxHeap.peek()[1] < l)
                    maxHeap.poll();
                while(minHeap.peek()[1] < l)
                    minHeap.poll();
            }
            
            // System.out.println(Arrays.deepToString(minHeap.toArray()));
            res = Math.max(res, r - l + 1);
            r += 1;
        }

        return res;
    }
}