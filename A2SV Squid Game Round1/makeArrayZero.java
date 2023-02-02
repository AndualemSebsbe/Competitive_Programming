class makeArrayZero {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        while(count != n){
            int min = findMin(nums);
            if(min == Integer.MAX_VALUE)
                return count;
            
            for(int i = 0; i < n; i++)
                if(nums[i] != 0)
                    nums[i] -= min;
            count += 1;        
        }

        return count;
    }

    int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int num : nums)
            if(num != 0)
                min = Math.min(min, num);
        
        return min;
    }
}