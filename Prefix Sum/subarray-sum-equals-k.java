class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int currSum = 0, count = 0;
        for(int num : nums){
            currSum += num;
            if(currSum == k)
                count += 1;
            
            if(map.containsKey(currSum - k))
                count += map.get(currSum - k);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}

// Test Case : nums = [1, 4, -5, 5, 0, 5] k = 5 => count = 8