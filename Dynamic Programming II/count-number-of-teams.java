class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        Integer[][][] memo = new Integer[n][4][2];
        int teams = 0;
        for(int i = 0; i < n; i++){
            teams += countTeams(rating, i, 1, 1, memo);
            teams += countTeams(rating, i, 1, 0, memo);
        }

        return teams;
    }

    int countTeams(int[] rating, int i, int count, int ascend, Integer[][][] memo){
        if(count == 3)
            return 1;
        if(i == rating.length)
            return 0;

        if(memo[i][count][ascend] != null)
            return memo[i][count][ascend];
        
        int teams = 0; 
        for(int j = i + 1; j < rating.length; j++){
            if(ascend == 1 && rating[i] < rating[j])
                teams += countTeams(rating, j, count + 1, ascend, memo);
            
            if(ascend == 0 && rating[i] > rating[j])
                teams += countTeams(rating, j, count + 1, ascend, memo);
        }

        return memo[i][count][ascend] = teams;
    }
}