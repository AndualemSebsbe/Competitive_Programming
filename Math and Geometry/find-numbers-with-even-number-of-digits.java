class Solution {
    public int findNumbers(int[] nums) {
        int evenCount = 0;
        for (int num : nums) {
            int count = 0;
            while (num > 0) {
                count += 1;
                num /= 10;
            }
            
            if (count % 2 == 0)
                evenCount += 1;
        }

        return evenCount;
    }
}