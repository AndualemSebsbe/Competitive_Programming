class findSmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int len = nums.length;
        int l = 1, r = 1000000;
        
            while(l <= r){
                int mid = l + (r - l)/2;
                long res = sum(nums, mid);
                if(res <= threshold) r = mid - 1;
                else
                    l = mid + 1;
            }
        return l;
    }
    
    public long sum(int[] nums, int mid){
        long res = 0;
        for(int i : nums)
            res += (i - 1)/mid + 1;
        return res;
    }
}