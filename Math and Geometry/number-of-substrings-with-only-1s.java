class Solution {
    public int numSub(String s) {
        List<Integer> nums = new ArrayList<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                count += 1;
            else if (count != 0) {
                nums.add(count);
                count = 0;
            }
        }

        if (count != 0)
            nums.add(count);

        long res = 0;
        int mod = 1_000_000_007;
        for (int num : nums) {
            long sum = (long) ((long)num * (num + 1)) / 2;
            res = (res + sum) % mod;
        }

        return (int)res;
    }
}