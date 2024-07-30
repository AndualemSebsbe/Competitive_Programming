class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] ascend = new int[n][4];
        int[][] descend = new int[n][4];

        for(int i = 0; i < n; i++){
            ascend[i][1] = 1;
            descend[i][1] = 1;
        }

        for(int count = 2; count < 4; count++){
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if(rating[i] < rating[j])
                        ascend[i][count] += ascend[j][count - 1];
                    
                    if(rating[i] > rating[j])
                        descend[i][count] += descend[j][count - 1];
                }
            }
        }

        int teams = 0;
        for(int i = 0; i < n; i++){
            teams += ascend[i][3];
            teams += descend[i][3];
        }

        return teams;
    }
}