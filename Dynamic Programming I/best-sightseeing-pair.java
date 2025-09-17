class Solution {

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] maxLeftScore = new int[n];
        maxLeftScore[0] = values[0];

        int maxScore = 0;

        for (int i = 1; i < n; i++) {
            int curRightScore = values[i] - i;
            maxScore = Math.max(maxScore, maxLeftScore[i - 1] + curRightScore);

            int curLeftScore = values[i] + i;
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], curLeftScore);
        }

        return maxScore;
    }
}