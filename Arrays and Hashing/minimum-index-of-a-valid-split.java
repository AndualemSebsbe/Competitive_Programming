class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap();
        int maxFreq = 0;
        for (int num : nums) {
            int occ = map.getOrDefault(num, 0) + 1;
            map.put(num, occ);
            maxFreq = Math.max(maxFreq, occ);
        }

        int dominantNum = nums.get(0);
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val == maxFreq)
                dominantNum = key;
        }

        int n = nums.size();
        int[] count = new int[n]; 
        for (int i = 0; i < n; i++) {
            if (i != 0)
                count[i] = count[i - 1];
            if (nums.get(i) == dominantNum)
                count[i] += 1;
        }

        for (int i = 0; i < n - 1; i++) {
            if (count[i] * 2 > (i + 1) && 
                (((maxFreq - count[i]) * 2) > (n - 1 - i)))
                    return i;
        }

        return -1;
    }
}