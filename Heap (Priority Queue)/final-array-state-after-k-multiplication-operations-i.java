class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int num : nums)
            minHeap.add(num);
        
        while (k-- > 0) {
            int min = minHeap.poll();
            for (int i = 0; i < n; i++) {
                if (nums[i] == min) {
                    nums[i] = nums[i] * multiplier;
                    minHeap.add(nums[i]);
                    break;
                }
            }
        }

        return nums;
    }
}