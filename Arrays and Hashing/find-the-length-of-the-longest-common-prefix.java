class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet();
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        int max = 0;
        for (int num : arr2) {

            while (num > 0 && !prefixes.contains(num))
                num /= 10;

            int count = 0;
            while (num > 0) {
                count += 1;
                num /= 10;
            }
            
            max = Math.max(max, count);
        }

        return max;
    }
}