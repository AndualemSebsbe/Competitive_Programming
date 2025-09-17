import java.util.HashMap;
import java.util.Map;

class maxKSumPair {
    public int maxOperations(int[] nums, int k) {
        // Initialize a hashmap
        Map<Integer, Integer> map
            = new HashMap<>();
 
        // Store the final result
        int result = 0;
 
        // Iterate over the array nums[]
        for (int i : nums) {
 
            // Decrement its frequency
            // in map and increment
            // the result by 1
            if (map.containsKey(i) &&
                map.get(i) > 0)
            {
 
                map.put(i, map.get(i) - 1);
                result++;
            }
 
            // Increment its frequency by 1
            // if it is already present in map.
            // Otherwise, set its frequency to 1
            else
            {
                map.put(k - i,
                        map.getOrDefault(k - i, 0) + 1);
            }
        }
        return result;
    }
}