class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, id = 0, r = n - 1;
        while(id <= r){
            if(nums[id] == 0){
                swap(nums, l, id);
                l += 1;
                id += 1;
            }
            else if(nums[id] == 2){
                swap(nums, id, r);
                r -= 1;
            }
            else
                id += 1;
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}