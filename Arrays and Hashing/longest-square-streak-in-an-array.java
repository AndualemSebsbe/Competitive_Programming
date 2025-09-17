class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        Arrays.sort(nums); 
        
        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && map.containsKey(sqrt))
                map.put(num, 1 + map.get(sqrt));
            else
                map.put(num, 1);
        }

        int res = 0;
        for (int key : map.keySet()) {
            int streak = map.get(key);
            res = Math.max(res, streak);
        }

        return res > 1 ? res : -1;
    }
}