class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0, n = answerKey.length();
        int max = 0;
        int[] count = new int[26];

        for(int r = 0; r < n; r++){
            char c = answerKey.charAt(r);
            max = Math.max(max, ++count[c - 'A']);
            if(r - l + 1 > max + k)
                count[answerKey.charAt(l++) - 'A'] -= 1;
        }

        return n - l;
    }
}