class Solution {
    public int largestCombination(int[] candidates) {
        int maxSize = 0;
        for (int i = 0; i < 32; i++) {
            int size = 0;
            for (int num : candidates) {
                if (((num >> i) & 1) == 1)
                    size += 1;
            }

            maxSize = Math.max(maxSize, size);
        }

        return maxSize;
    }
}