class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            int xorVal = 0;
            for(int num : nums){
                xorVal ^= (num & (1 << i));
            }

            int kBitVal = (k & (1 << i));

            if(xorVal != kBitVal)
                count += 1;
        }

        return count;
    }
}