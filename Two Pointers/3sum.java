class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        
        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int start = i + 1;
            int end = n - 1;
            
            while(start < end){
                int currSum = nums[i] + nums[start] + nums[end];
                if(currSum > 0) 
                    end -= 1;
                else if(currSum < 0) 
                    start += 1;
                else{
                    res.add(Arrays.asList(nums[i], nums[start], 
                        nums[end]));
                    start += 1;
                    while(start < end && nums[start] == nums[start - 1])
                        start += 1; 
                }  
            }
        }
        
        return res;
    }
}