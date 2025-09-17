class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = countPairsWithMaxDistance(nums, mid);

            if (count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    int countPairsWithMaxDistance(int[] nums, int maxDistance) {
        int count = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > maxDistance)
                left += 1;
            
            count += right - left;
        }

        return count;
    }
}