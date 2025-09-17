class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int posCount = n - upperBound(nums);
        int negCount = lowerBound(nums);

        return Math.max(posCount, negCount);
    }

    // upperBound = First index where the value is greter than zero
    int upperBound(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int best = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > 0) {
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    // lowerBound = First index where the value is equals to or greter than zero
    int lowerBound(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int best = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= 0) {
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }
}