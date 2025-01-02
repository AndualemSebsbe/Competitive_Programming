class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String curWord = words[i];
            if (vowels.contains(curWord.charAt(0)) &&
                vowels.contains(curWord.charAt(curWord.length() - 1))) {
                sum++;
            }

            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] curQuery = queries[i];
            ans[i] = prefixSum[curQuery[1]] -
                (curQuery[0] == 0 ? 0 : prefixSum[curQuery[0] - 1]);
        }

        return ans;
    }
}