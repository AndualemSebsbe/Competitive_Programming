class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numOfKSubarray(nums, k) - numOfKSubarray(nums, k - 1);
    }

    int numOfKSubarray(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int totalCount = 0, l = 0;
        for(int r = 0; r < n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l += 1;
            }

            totalCount += (r - l);
        }

        return totalCount;
    }
}