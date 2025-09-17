class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];
        for (int num : nums)
            count[num] += 1;

        int i = 0, distinct = 1;
        int res = 0;
        while (i < n) {
            for (int idx = i; idx < n; idx++) {
                if (count[nums[idx]] > 1)
                    distinct = 0;
            }

            if (distinct == 1) 
                return res;
            
            for (int idx = i; idx < Math.min(i + 3, n); idx++) 
                count[nums[idx]] -= 1;
            i += 3;
            res += 1;
            distinct = 1;
        }

        return res;
    }
}