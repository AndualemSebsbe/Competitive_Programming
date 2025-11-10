class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();        
        Stack<Integer> st = new Stack<>();
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) {
                map.put(st.peek(), num);
                st.pop();
            }

            st.add(num);
        }

        for (int i = 0; i < len1; i++) {
            int num = nums1[i];
            if (map.containsKey(num))
                nums1[i] = map.get(num);
            else 
                nums1[i] = -1;
        }
        
        return nums1;
    }
}