class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        int numOfOdds = 0, count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 != 0)
                numOfOdds += 1;

            if(numOfOdds == k)
                count += 1;
            
            if(map.containsKey(numOfOdds - k))
                count += map.get(numOfOdds - k);
            
            map.put(numOfOdds, map.getOrDefault(numOfOdds, 0) + 1);
        }

        return count;
    }
}