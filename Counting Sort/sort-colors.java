class Solution {
    public void sortColors(int[] nums) {
        int[] counting = new int[3];
        for(int num : nums)
            counting[num] += 1;
        
        int idx = 0;
        for(int i = 0; i < 3; i++){
            while(counting[i]-- > 0)
                nums[idx++] = i;
        }
    }
}