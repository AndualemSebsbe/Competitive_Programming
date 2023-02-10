import java.util.HashMap;
import java.util.Map;

class numOfPairsofStrings {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
                count += map.get(nums[i]);
            
            int m = nums[i].length(), n = target.length();
            if(target.startsWith(nums[i])){
                String s = target.substring(m);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }

            if(target.endsWith(nums[i])){
                String s = target.substring(0, n-m);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        return count;
    }
}