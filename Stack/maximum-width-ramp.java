class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack();
        int r = 0, n = nums.length;
        int max = 0;
        while (r < n) {
            while (!st.isEmpty() && r < n && nums[st.peek()] <= nums[r])
                r += 1;
            
            if (r == n)
                continue;

            st.add(r);
            max = Math.max(max, r - st.peek());
        }

        r = n - 1;
        while (!st.isEmpty() && r >= st.peek()) {
            if (nums[st.peek()] <= nums[r]) {
                max = Math.max(max, r - st.peek());
                st.pop();
            }
            else
                r -= 1;
        }

        return max;
    }
}