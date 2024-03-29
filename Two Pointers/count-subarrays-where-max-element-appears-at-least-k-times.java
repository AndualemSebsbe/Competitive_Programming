class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        for(int num : nums)
            max = Math.max(max, num);

        long totalCount = 0;
        Map<Integer, Integer> map = new HashMap();
        int l = 0;
        for(int r = 0; r < n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.containsKey(max) && map.get(max) >= k){
                map.put(nums[l], map.get(nums[l]) - 1);
                l += 1;
            }
            
            totalCount += l;
        }

        return totalCount;
    }
}