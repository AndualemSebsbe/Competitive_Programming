class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int res = 0, times = 0;
        int[] flipped = new int[n];
        Arrays.fill(flipped, 0);

        for(int i = 0; i < n; i++){
            if(i >= k)
                times -= flipped[i - k];
            
            if((nums[i] == 1 && times % 2 == 1) || (nums[i] == 0 && times % 2 == 0)){
                if(i + k > n)
                    return -1;
                
                res += 1;
                times += 1;
                flipped[i] = 1;
            }
        }

        return res;
    }
}