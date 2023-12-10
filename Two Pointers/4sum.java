class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();

        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < n - 2; j++){   
                if(j > i + 1 && nums[j] == nums[j-1])
                    continue;            
 
                int l = j + 1, r = n - 1; 
                // to prevent integer overflow
                long sum = nums[i] + nums[j];
                long val = (long)target - sum;               
                while(l < r){
                    sum = nums[l] + nums[r];
                    if(sum > val)
                        r -= 1;
                    else if(sum < val)
                        l += 1;
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], 
                            nums[l], nums[r]));
                            
                        l += 1;
                        while(l < r && nums[l] == nums[l-1])
                            l += 1;
                    }
                }
            }
        }

        return res;
    }
}