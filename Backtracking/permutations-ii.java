class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        Arrays.sort(nums);
        backtrack(res, nums, new ArrayList(), new boolean[n]);
        
        return res;
    }
    
    void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
                continue;
            
            list.add(nums[i]);
            used[i] = true;

            backtrack(res, nums, list, used);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}