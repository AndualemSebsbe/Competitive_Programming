import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        backtrack(nums, 0, list);

        return res;
    }

    void backtrack(int[] nums, int start, List<Integer> list){
        res.add(new ArrayList<>(list));
        
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);

            backtrack(nums, i + 1, list);

            list.remove(list.size() - 1);
        }
    }
}