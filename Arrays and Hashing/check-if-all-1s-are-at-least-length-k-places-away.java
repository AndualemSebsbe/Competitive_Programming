class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        List<Integer> idxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                idxes.add(i);
        }

        int size = idxes.size();
        if (size == 1)
            return true;

        for (int i = 0; i < idxes.size() - 1; i++) {
            if (idxes.get(i + 1) - idxes.get(i) <= k) 
                return false;
        }
        
        return true;
    }
}