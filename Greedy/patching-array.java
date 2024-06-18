class Solution {
    public int minPatches(int[] nums, int n) {
        long maxNum = 0;
        int patches = 0, i = 0, m = nums.length;
        while(maxNum < n){
            if(i < m && maxNum + 1 >= nums[i]){
                maxNum += nums[i];
                i += 1;
            }
            else {
                patches += 1;
                maxNum += (maxNum + 1);
            }
        }

        return patches;
    }
}