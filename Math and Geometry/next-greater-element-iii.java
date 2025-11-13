class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();

        while (n > 0) {
            int rem = n % 10;
            nums.add(rem);
            n /= 10;
        }

        Collections.reverse(nums);

        int idx = -1, len = nums.size();
        for (int i = len - 1; i > 0; i--) {
            if (nums.get(i - 1) < nums.get(i)) {
                idx = i - 1;
                break;
            }                    
        }

        if (idx == -1)
            return -1;

        for (int i = len - 1; i >= 0; i--) {
            if (nums.get(i) > nums.get(idx)) {
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx + 1, len - 1);

        long res = 0;
        for (int num : nums) {
            res *= 10;
            res += num;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return -1;
        return (int) res;
    }

    void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }

    void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }
}