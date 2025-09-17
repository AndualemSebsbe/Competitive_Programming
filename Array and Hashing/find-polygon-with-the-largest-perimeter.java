class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long max = -1, sum = nums[0];

        for(int i = 1; i < n - 1; i++){
            sum += nums[i];

            if(sum > nums[i + 1]){
                max = Math.max(max, sum + nums[i + 1]);
            }
        }

        return max;
    }
}