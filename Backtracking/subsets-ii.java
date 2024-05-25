class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        backtrack(nums, 0, list);

        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> list){
        res.add(new ArrayList(list));
        
        int n = nums.length;
        for(int i = start; i < n; i++){

            if(i > start && nums[i] == nums[i - 1])
                continue;

            list.add(nums[i]);

            backtrack(nums, i + 1, list);

            list.remove(list.size() - 1);
        }
    }
}