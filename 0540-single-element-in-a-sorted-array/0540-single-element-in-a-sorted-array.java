class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        if(n == 1)
            return nums[0];
        
        if(nums[l] != nums[l+1])
            return nums[l];
        if(nums[r-1] != nums[r])
            return nums[r];
        
        while(l <= r){
            int mid = l + (r-l)/2;
            
            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1])
                return nums[mid];
            else if((mid%2 == 0 && nums[mid] == nums[mid+1])
                   || (mid%2 == 1 && nums[mid-1] == nums[mid]))
                l = mid + 1;   
            else
                r = mid - 1;
        }
        
        return -1;
    }
}