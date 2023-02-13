import java.util.HashMap;
import java.util.Map;

class subarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0, res = 0;
        for(int num : nums){
            prefix = (prefix + num)%k;
            if(prefix < 0)
                prefix += k;
            
            if(map.containsKey(prefix))
                res += map.get(prefix);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return res;
    }
}