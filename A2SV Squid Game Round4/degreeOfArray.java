import java.util.HashMap;
import java.util.Map;

class degreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            if(!first.containsKey(nums[i]))
                first.put(nums[i], i);
            
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            if(count.get(nums[i]) > degree){
                res = i - first.get(nums[i])+1;
                degree = count.get(nums[i]);
            }
            else if(count.get(nums[i]) == degree){
                res = Math.min(res, i - first.get(nums[i])+1);
            }
        }

        return res;
    }
}