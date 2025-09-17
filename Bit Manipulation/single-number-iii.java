class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xy = 0;
        for(int num : nums)
            xy ^= num;
        
        xy &= -xy; // get the last set 1
        int[] res = new int[2];
        for(int i = 0; i < n; i++){
            if((nums[i] & xy) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }

        return res;
    }
}