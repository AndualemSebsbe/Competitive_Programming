class Solution {
    List<List<Integer>> subsets = new ArrayList();
    public int countMaxOrSubsets(int[] nums) {
        List<Integer> list = new ArrayList();
        backtrack(list, nums, 0);

        int max = 0;
        for (int num : nums)
            max = max | num;
        
        int count = 0;
        for (List<Integer> subset : subsets) {
            int XOR = 0;
            for (int num : subset)
                XOR = XOR | num;

            if (XOR == max)
                count += 1;
        }

        return count;
    }

    void backtrack(List<Integer> list, int[] nums, int start) {
        if (list.size() != 0)
            subsets.add(new ArrayList(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);

            backtrack(list, nums, i + 1);
            
            list.remove(list.size() - 1);
        }
    }
}