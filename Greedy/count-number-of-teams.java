class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int teams = 0;
        for(int mid = 1; mid < n - 1; mid++){
            int leftSmaller = 0, rightLarger = 0;
            for(int i = 0; i < mid; i++){
                if(rating[i] < rating[mid])
                    leftSmaller += 1;
            }

            for(int i = mid + 1; i < n; i++){
                if(rating[i] > rating[mid])
                    rightLarger += 1;
            }

            teams += leftSmaller * rightLarger; // count teams in ascending order

            int leftLarger = mid - leftSmaller;
            int rightSmaller = (n - mid -  1) - rightLarger;
            teams += leftLarger * rightSmaller; // count temas in descending order
        }

        return teams;
    }
}