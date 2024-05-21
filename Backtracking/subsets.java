class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList();
        res.add(new ArrayList(list));
        backtrack(nums, 0, list);

        return res;
    }

    void backtrack(int[] nums, int i, List<Integer> list){
        if(i == nums.length)
            return;
        
        for(int j = i; j < nums.length; j++){
            list.add(nums[j]);
            res.add(new ArrayList(list));

            backtrack(nums, j+1, list);

            list.remove(list.size()-1);
        }
    }
}