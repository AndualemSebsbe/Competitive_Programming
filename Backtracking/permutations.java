//Time complexity: n!*n
//Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), new boolean[n]);

        return res;
    }

    void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            
            list.add(nums[i]);
            used[i] = true;

            backtrack(res, nums, list, used);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}