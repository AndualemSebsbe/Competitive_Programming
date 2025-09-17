class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int leftCount = 0, pivotCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot)
                leftCount += 1;
            else if (nums[i] == pivot)
                pivotCount += 1;
        }

        int l = 0, r = leftCount + pivotCount;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot)
                res[l++] = nums[i];
            else if (nums[i] > pivot)
                res[r++] = nums[i];
            else
                res[leftCount++] = nums[i];
         }

         return res;
    }
}