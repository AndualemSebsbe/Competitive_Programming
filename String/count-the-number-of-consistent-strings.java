class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] bits = new  int[26];
        for (char c : allowed.toCharArray()) {
            int idx = c - 'a';
            bits[idx] = 1;
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (bits[idx] != 1) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent)
                count += 1;
        }

        return count;
    }
}