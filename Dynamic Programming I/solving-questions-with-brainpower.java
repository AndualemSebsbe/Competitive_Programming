class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        Long[] memo = new Long[n];

        return maxPoints(questions, 0, memo);
    }

    long maxPoints(int[][] questions, int i, Long[] memo) {
        if (i >= questions.length)
            return 0;
        
        if (memo[i] != null)
            return memo[i];
        
        int points = questions[i][0];
        int brainPower = questions[i][1];
        long solve = points + maxPoints(questions, i + brainPower + 1, memo);
        long dontSolve = maxPoints(questions, i + 1, memo);

        memo[i] = Math.max(solve, dontSolve);
        return memo[i];
    }
}