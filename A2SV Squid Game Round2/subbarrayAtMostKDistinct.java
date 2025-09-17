class subarraysAtmostKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return kSubarray(nums,k)-kSubarray(nums,k-1);
    }

    private int kSubarray(int[] nums,int k){
         int[] occ = new int[nums.length+1];

        int j=0, count=0, unique = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(occ[nums[i]]++==0)
               unique += 1;

            while(unique > k){
                if(occ[nums[j++]]--==1)
                   unique--;
            }

            count += (i-j+1);
        }
        return count;
    }
}