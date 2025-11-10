class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int max = 0;
        for (int num : nums2) 
            max = Math.max(max, num);

        int[] nextGreater = new int[max + 1];
        Arrays.fill(nextGreater, -1);
        
        Stack<Integer> st = new Stack<>();
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                nextGreater[st.peek()] = num;
                st.pop();
            }

            st.add(num);
        }

        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) 
            res[i] = nextGreater[nums1[i]];
        
        return res;
    }
}