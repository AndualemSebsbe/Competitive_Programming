class moveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length, left = 0, right = 0;
        for(int i=0; i < len && right < len; i++){
        if(nums[right] != 0){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
             left++;
        }
           right++; 
        }
        
    }
}