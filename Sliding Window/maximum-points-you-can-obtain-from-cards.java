class Solution {  
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, total = 0;
        for(int point : cardPoints)
            total += point;

        int m = n - k;
        int sum = 0;
        for(int i = 0; i < m; i++)
            sum += cardPoints[i];
        
        int minSum = sum;
        for(int i = m; i < n; i++){
            sum += cardPoints[i];
            sum -= cardPoints[i - m];
            minSum = Math.min(sum, minSum);
        }

        return total - minSum;
    }
}