class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!st.isEmpty() && nums[idx] > nums[st.peek()]) {
                map.put(st.peek(), nums[idx]);
                st.pop();
            }

            st.add(idx);
        }

        for (int i = 0; i < n; i++)
            nums[i] = map.getOrDefault(i, -1);

        return nums;
    }
}