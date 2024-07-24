class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            String s = nums[i] + "";
            int mappedVal = 0;

            for(char c : s.toCharArray()){
                int val = c - '0';
                mappedVal = mappedVal * 10 + mapping[val];
            }

            pairs[i][0] = mappedVal;
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int idx = pairs[i][1];
            res[i] = nums[idx];
        }

        return res;
    }
}