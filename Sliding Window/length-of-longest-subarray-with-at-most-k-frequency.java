class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int l = 0, max = 0;
        for(int r = 0; r < n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.get(nums[r]) > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                l += 1;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}