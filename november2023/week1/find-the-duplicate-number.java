class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = nums.length;
        
        while(l < r){
            int mid = l + (r-l)/2;
            
            int count = 0;
            for(int num: nums)
                if(num <= mid) count +=1;
            if(count > mid){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}