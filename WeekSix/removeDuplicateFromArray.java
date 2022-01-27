class removeDuplicateFromArray {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
            return len;
        int l = 0;
        int r = 1;
        int count = 1, i=1;
        while(r < len){
            if(nums[l] == nums[r])
            {
                r++;
            }
            else{
                nums[i] = nums[r];
                count++; i++;
                l = r;
                r++;
            }
        }
       return count; 
    }
}