class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remCount = new HashMap();
        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            remCount.put(rem, remCount.getOrDefault(rem, 0) + 1);
        }

        for (int rem : remCount.keySet()) {
            int count = remCount.get(rem);
            if (rem == 0) {
                if (count % 2 != 0)
                    return false;
            }
            else {
                int complement = k - rem;
                if (!remCount.containsKey(complement))
                    return false;
                
                int compCount = remCount.get(complement);
                if (count != compCount)
                    return false;
            }
        }

        return true;
    }
}