class Solution {  
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0, rightSum = 0, res = 0;
        
        for(int i = 0; i < k; i++) leftSum += cardPoints[i];
        
        res = leftSum;
        for(int i = 0; i < k; i++){
            leftSum -= cardPoints[k-i-1];
            rightSum += cardPoints[n-1-i];
            res = Math.max(res, leftSum + rightSum);
        }
        
        return res;
    }
}