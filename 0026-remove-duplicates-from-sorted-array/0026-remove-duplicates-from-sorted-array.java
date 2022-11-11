class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1, n = nums.length;
        
        for(int i = 1; i < n; i++){
            while(i < n && nums[count-1] == nums[i])
                i++;
            
            if(i != n)
                nums[count++] = nums[i];
        }
        
        return count;
    }
}