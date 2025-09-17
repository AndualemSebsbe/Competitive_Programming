class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0, count = 0;
        for(int num : nums){
            sum += num;
            if(sum == goal)
                count += 1;
            
            if(map.containsKey(sum - goal))
                count += map.get(sum - goal);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}