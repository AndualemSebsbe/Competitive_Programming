class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(result, nums, new ArrayList(), new boolean[nums.length]);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> res, boolean[] used){
        if(res.size() == nums.length){
            result.add(new ArrayList(res));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;
            
            res.add(nums[i]);
            used[i] = true;

            backtrack(result, nums, res, used);

            res.remove(res.size()-1);
            used[i] = false;
        }    
    }
}
