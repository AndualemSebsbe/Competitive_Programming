class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int curSum = 0, count = 0;
        for(int num : nums){
            curSum = (curSum + num) % k;
            if(curSum == 0)
                count += 1;

            if(curSum < 0)
                curSum += k; 

            if(map.containsKey(curSum))
                count += map.get(curSum);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}