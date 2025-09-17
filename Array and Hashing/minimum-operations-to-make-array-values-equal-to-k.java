class Solution {
    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            if (num < k)
                return -1;
        }

        Set<Integer> set = new HashSet();
        for (int num : nums)
            set.add(num);
        
        if (set.contains(k))
            return set.size() - 1;
        
        return set.size();
    }
}