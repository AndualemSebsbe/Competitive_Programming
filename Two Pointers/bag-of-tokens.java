class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int l = 0, r = n - 1;
        int score = 0, res = 0;
        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                l += 1;
                score += 1;
                res = Math.max(res, score);
            }
            else if(score > 0){
                power += tokens[r];
                r -= 1;
                score -= 1;
            }
            else
                break;
        }

        return res;
    }
}