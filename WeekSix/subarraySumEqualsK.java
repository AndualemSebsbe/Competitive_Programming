import java.util.HashMap;

class subarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int res = 0, prefixSum = 0, i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefixSum, 1);
        while(i < len){
            prefixSum += nums[i];
            if(map.containsKey(prefixSum - k))
                res += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            i++;
        }
        return res;
    }
}