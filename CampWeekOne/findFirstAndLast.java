class findFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int first = findPosition(nums, target, true);
        if(first == -1) return new int[]{-1, -1};
        
        return new int[]{first, findPosition(nums, target, false)};
    }
    public int findPosition(int[] nums, int target, boolean isFirst){
        int l = 0, r = nums.length - 1, best = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                r = isFirst ? mid - 1 : r;
                l = isFirst ? l : mid + 1;
                best = mid;
            }
        }
        return best;
    }
}